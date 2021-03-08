package com.idel.runner;

import java.sql.SQLException;

import com.idel.dao.DaoFactory;
import com.idel.dao.mdao.MDaoFactory;
import com.idel.dao.mdao.MOrdersDao;

public class TestLoginService
{


   public static void main(String[] args) throws SQLException
   {
       MDaoFactory factory = DaoFactory.getDaoFactory();
       MOrdersDao ordersDao = factory.createOrdersDao();
   }

}