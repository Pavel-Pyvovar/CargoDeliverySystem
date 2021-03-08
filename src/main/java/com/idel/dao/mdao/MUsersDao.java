package com.idel.dao.mdao;

import com.idel.entities.Users;
import com.idel.connection.DataSourceFactory;
import com.idel.dao.IUsersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MUsersDao implements IUsersDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public MUsersDao() {}

    private Connection getConnection() throws SQLException {
        return DataSourceFactory.getMySQLDataSource().getConnection();
    }
    
    public void add(Users user) {
        try {
            String queryString = "INSERT INTO Users(FirstName, SecondName, Password, Email) VALUES(?,?,?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Users user) {
        try {
            String queryString = "UPDATE Users SET FirstName=? WHERE UserId=?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("Table Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int userId) {
        try {
            String queryString = "DELETE FROM Users WHERE UserId=?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Users> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Users> users = new ArrayList<Users>();
        try {
            String queryString = "SELECT * FROM Users";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setUserId(resultSet.getInt("UserId"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setSecondName(resultSet.getString("SecondName"));
                user.setPassword(resultSet.getString("Password"));
                user.setEmail(resultSet.getString("Email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public Users findUser(String email, String password) {
        // TODO: Investigate whether throws clause is needed here.
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Users user = null;
        try {
            String queryString = "SELECT * FROM Users WHERE email=? AND password=?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            // TODO: check whether the following casting works.
            user = (Users) preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public void clearTable() throws SQLException {
        try {
            String queryString = "DELETE FROM Users";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.executeUpdate();
            System.out.println("Table Users is successfully cleared!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
