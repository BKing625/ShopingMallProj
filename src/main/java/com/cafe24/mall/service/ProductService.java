package com.cafe24.mall.service;

import com.cafe24.mall.repository.OptionDao;
import com.cafe24.mall.repository.ProductDao;
import com.cafe24.mall.vo.OptionVo;
import com.cafe24.mall.vo.ProductVo;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class ProductService {
    private final ProductDao productDao;
    private final OptionDao optionDao;

    public ProductService(ProductDao productDao, OptionDao optionDao) {
        this.productDao = productDao;
        this.optionDao = optionDao;
    }


    @Transactional
    public Boolean add(ProductVo addVo) {
        if (0 == productDao.registry(addVo))
            return false;

        
        if(!addOptionTree(addVo.getProductNumber(), addVo.getOptions())){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    public List<ProductVo> getList() {
        return getList(1);
    }

    public List<ProductVo> getList(int page) {
        return productDao.getList(page);
    }

    public Boolean delete(Long productNumber) {
        return productDao.delete(productNumber) == 1;
    }

    @Transactional
    public Boolean modify(ProductVo updateVo) {
        // TODO: 2019-07-28 Need to change, consider various situations
        //  (how to processing product in order)
        if (0 == productDao.update(updateVo))
            return false;
        Long prodNumber = updateVo.getProductNumber();
        if (optionDao.delete(prodNumber) <= 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        if(!addOptionTree(prodNumber, updateVo.getOptions())){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }
    
    private Boolean addOptionTree(Long prodNum, List<OptionVo> options){
        Stack<OptionVo> treeStack = new Stack<>();
//        for (int i = options.size(); i > 0; i--) {
//            treeStack.push(options.get(i - 1));
//        }
        for(OptionVo option : options)
            treeStack.push(option);

        while (!treeStack.isEmpty()) {
            OptionVo oVo = treeStack.pop();
            oVo.setProductNumber(prodNum);
            if (0 == optionDao.registry(oVo)) {
                return false;
            }

            if (oVo.getSubOptions() == null)
                continue;
//
//            for (int i = oVo.getSubOptions().size(); i > 0; i--) {
//                OptionVo subOVo = oVo.getSubOptions().get(i - 1);
//                subOVo.setParentOptionNumber(oVo.getOptionNumber());
//                treeStack.push(subOVo);
//            }
            for (OptionVo subOption : oVo.getSubOptions()){
                subOption.setParentOptionNumber(oVo.getOptionNumber());
                treeStack.push(subOption);
            }
        }
        return true;
    }

    public ProductVo get(Long prodNum) {
        ProductVo resVo = productDao.get(prodNum);

        List<OptionVo> options = optionDao.getList(prodNum);

        Map<Long, OptionVo> hashMap = new HashMap<>();

        Long temp = 0L;
        for(OptionVo op : options){
            hashMap.put(op.getOptionNumber(),op);
            temp = op.getOptionNumber();
//            System.out.println(op);
        }

        for(OptionVo op : options){
            if(op.getParentOptionNumber()==null){
                resVo.addOption(op);
            } else{
                hashMap.get(op.getParentOptionNumber()).addChildren(op);
            }
        }

        return resVo;
    }
}
