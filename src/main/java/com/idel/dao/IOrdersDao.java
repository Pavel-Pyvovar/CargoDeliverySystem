package com.idel.dao;

import com.idel.entities.Orders;

import java.util.List;

public interface IOrdersDao {
    void add(Orders order);
    void update(Orders order);
    List<Orders> findAllUserOrders(int email);
//    void delete(int orderId);
//    void findAll();
//    void clearTable() throws SQLException;
}
