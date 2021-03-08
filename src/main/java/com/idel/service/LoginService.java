package com.idel.service;

import com.idel.dao.DaoFactory;
import com.idel.dao.mdao.MDaoFactory;
import com.idel.dao.mdao.MUsersDao;
import com.idel.entities.Users;

public class LoginService {
    private MDaoFactory daoFactory = DaoFactory.getDaoFactory();
    private MUsersDao usersDao = daoFactory.createUsersDao();

    public Users findUserByLogin(String email, String password) {
        Users user = usersDao.findUser(email, password);
        return user;
    }

    public void createUser(Users user) {
        usersDao.add(user);
    }
}
