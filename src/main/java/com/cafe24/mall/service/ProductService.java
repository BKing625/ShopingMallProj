package com.cafe24.mall.service;

import com.cafe24.mall.repository.OptionDao;
import com.cafe24.mall.repository.ProductDao;
import com.cafe24.mall.vo.OptionVo;
import com.cafe24.mall.vo.ProductVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Stack;

@Service
public class ProductService {
    private final ProductDao productDao;
    private final OptionDao optionDao;
    public ProductService(ProductDao productDao, OptionDao optionDao) {
        this.productDao = productDao;
        this.optionDao = optionDao;
    }


    @Transactional
    public Boolean add(ProductVo addVo){
        if(0==productDao.registry(addVo))
            return false;

        List<OptionVo> option = addVo.getOptions();
        Long prodNumber = addVo.getProductNumber();
        Stack<OptionVo> treeStack = new Stack<>();
        for(int i = option.size(); i>0; i--){
            treeStack.push(option.get(i-1));
        }

        while(!treeStack.isEmpty()){
            OptionVo oVo = treeStack.pop();
            oVo.setProductNumber(prodNumber);
            if(0 == optionDao.registry(oVo)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }

            if(oVo.getSubOptions()==null)
                continue;
            for(int i = oVo.getSubOptions().size(); i>0;i--) {
                OptionVo subOVo = oVo.getSubOptions().get(i-1);
                subOVo.setParentOptionNumber(oVo.getOptionNumber());
                treeStack.push(subOVo);
            }
        }
        return true;
    }
}
