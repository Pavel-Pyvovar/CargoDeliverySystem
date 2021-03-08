package com.idel.runner;

import java.util.List;

import com.idel.dao.DaoFactory;
import com.idel.dao.mdao.MDaoFactory;
import com.idel.dao.mdao.MOrdersDao;
import com.idel.entities.Orders;

public class TestOrdersDao {
    public static void main(String[] args) {
//        Orders order = new Orders();
//        order.setCarriageType("Electronics");
//        order.setCarriageWeight(2);
//        order.setUserId(10);
//        order.setShippingRateId(2);
//        order.setShippingDate(new Date(System.currentTimeMillis()));

        MDaoFactory factory = DaoFactory.getDaoFactory();
        MOrdersDao ordersDao = factory.createOrdersDao();
        List<Orders> orders = ordersDao.findAllUserOrders(10);
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }
    }
}
