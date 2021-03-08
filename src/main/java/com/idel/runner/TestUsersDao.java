package com.idel.runner;

import com.idel.dao.DaoFactory;
import com.idel.dao.mdao.MDaoFactory;
import com.idel.dao.mdao.MUsersDao;
import com.idel.entities.Users;

import java.sql.SQLException;
import java.util.List;

public class TestUsersDao {
    public static void main(String[] args) throws SQLException {
        MDaoFactory daoFactory = new MDaoFactory();
        MUsersDao userDao = daoFactory.createUsersDao();
        Users pavlo = new Users();
        pavlo.setFirstName("Pavlo");
        pavlo.setSecondName("Pyvovar");
        pavlo.setPassword("HelloWorld!");
        pavlo.setEmail("pavlo.pyvovar@icloud.com");
        userDao.add(pavlo);

//        Users pasha = new Users();
//        pasha.setFirstName("Pasha");
//        pasha.setUserId(1);
//        userDao.update(pasha);
//
//        List<Users> users = userDao.findAll();
//
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i));
//        }
//        int userId = pasha.getUserId();
//        userDao.delete(userId);
//        userDao.clearTable();
    }
}
