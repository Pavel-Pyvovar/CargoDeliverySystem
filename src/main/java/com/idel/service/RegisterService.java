package com.idel.service;

import com.idel.dao.DaoFactory;
import com.idel.dao.mdao.MDaoFactory;
import com.idel.dao.mdao.MUsersDao;
import com.idel.entities.Users;

public class RegisterService {
    private MDaoFactory daoFactory = DaoFactory.getDaoFactory();
    private MUsersDao usersDao = daoFactory.createUsersDao();

    public void registerUser(Users user) {
        usersDao.add(user);
    }
}
