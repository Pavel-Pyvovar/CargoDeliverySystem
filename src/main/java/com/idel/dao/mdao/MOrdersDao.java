package com.idel.dao.mdao;

import com.idel.dao.IOrdersDao;
import com.idel.entities.Orders;
import com.idel.connection.DataSourceFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MOrdersDao implements IOrdersDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public MOrdersDao() {}

    private Connection getConnection() throws SQLException {
        return DataSourceFactory.getMySQLDataSource().getConnection();
    }
    
    @Override
    public void add(Orders order) {
        try {
            String queryString = "INSERT INTO Orders(UserId, CarriageType, CarriageWeight, ShippingDate, ShippingRateId) VALUES(?,?,?,?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setString(2, order.getCarriageType());
            preparedStatement.setInt(3, order.getCarriageWeight());
            preparedStatement.setDate(4, (Date) order.getShippingDate());
            preparedStatement.setInt(5, order.getShippingRateId());
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

    @Override
    public void update(Orders order) {
        try {
            String queryString = "UPDATE Orders SET CarriageWeight=? WHERE OrderId=?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, order.getCarriageWeight());
            preparedStatement.setInt(2, order.getOrderId());
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
//
//    @Override
//    public void delete(int userId) {
//        try {
//            String queryString = "DELETE FROM Users WHERE UserId=?";
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(queryString);
//            preparedStatement.setInt(1, userId);
//            preparedStatement.executeUpdate();
//            System.out.println("Data deleted Successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null)
//                    preparedStatement.close();
//                if (connection != null)
//                    connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public List<Orders> findAllUserOrders(int userId) {
        // TODO: Select the right type for UserId argument.
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Orders> orders = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM Orders WHERE UserId=?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Orders order = new Orders();
                order.setUserId(resultSet.getInt("UserId"));
                order.setOrderId(resultSet.getInt("OrderId"));
                order.setShippingRateId(resultSet.getInt("ShippingRateId"));
                order.setCarriageWeight(resultSet.getInt("CarriageWeight"));
                order.setCarriageType(resultSet.getString("CarriageType"));
                order.setShippingDate(resultSet.getDate("ShippingDate"));
                orders.add(order);
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
        return orders;
    }
//
//    @Override
//    public void clearTable() throws SQLException {
//        try {
//            String queryString = "DELETE FROM Users";
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(queryString);
//            preparedStatement.executeUpdate();
//            System.out.println("Table Users is successfully cleared!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null){
//                    connection.close();
//                }
//                if (preparedStatement != null){
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
