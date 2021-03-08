package com.idel.dao;

import com.idel.entities.Users;

import java.sql.SQLException;
import java.util.List;

public interface IUsersDao {
    void add(Users user);
    void update(Users user);
    void delete(int userId);
    List<Users> findAll();
    void clearTable() throws SQLException;
}
