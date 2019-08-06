package com.cafe24.mall.backend.service;

import com.cafe24.mall.backend.vo.OrderVo;
import com.cafe24.mall.backend.repository.OrderDao;
import com.cafe24.mall.backend.repository.OrderDetailsDao;
import com.cafe24.mall.backend.vo.OrderDetailsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final OrderDetailsDao odsDao;

    public OrderService(OrderDao orderDao, OrderDetailsDao odsDao) {
        this.orderDao = orderDao;
        this.odsDao = odsDao;
    }

    @Transactional
    public Boolean add(OrderVo addVo){
        if(addVo.getGoodsList()==null
                || addVo.getGoodsList().size() == 0
                || 0 ==orderDao.registry(addVo)) return false;

        for(OrderDetailsVo odsVo : addVo.getGoodsList()){
            odsVo.setOrderNumber(addVo.getOrderNumber());
            if(1!=odsDao.registry(odsVo)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return true;
    }

    public Boolean cancel(OrderVo cancelVo) {
        if(cancelVo.getOrderNumber()==null ||
            cancelVo.getUserNumber()==null)
            return false;
        cancelVo.setOrderState("주문취소");

        return 1==orderDao.update(cancelVo);
    }

    public List<OrderVo> getList(Long userNumber, int page){
        return orderDao.getList(userNumber, page);
    }

    public OrderVo get(Long orderNum, Long userNum){
        OrderVo resVo = orderDao.get(orderNum, userNum);

        if(resVo == null) return null;

        resVo.setGoodsList(odsDao.getList(orderNum));
        return resVo;
    }

}
