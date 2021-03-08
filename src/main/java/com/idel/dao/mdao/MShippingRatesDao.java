package com.idel.dao.mdao;

import com.idel.connection.DataSourceFactory;
import com.idel.dao.IShippingRatesDao;
import com.idel.entities.ShippingRates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MShippingRatesDao implements IShippingRatesDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public MShippingRatesDao() {}

    private Connection getConnection() throws SQLException {
        return DataSourceFactory.getMySQLDataSource().getConnection();
    }
    
    @Override
    public void add(ShippingRates shippingRate) {
        try {
            String queryString = "INSERT INTO ShippingRates(MaxWeight, CityPrice, RegionPrice, CountryPrice) VALUES(?,?,?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, shippingRate.getMaxWeight());
            preparedStatement.setInt(2, shippingRate.getCityPrice());
            preparedStatement.setInt(3, shippingRate.getRegionPrice());
            preparedStatement.setInt(4, shippingRate.getCountryPrice());
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

//    @Override
//    public void update(Users user) {
//        try {
//            // TODO: Update query string to fit ShippingRates table
//            String queryString = "UPDATE ShippingRates SET FirstName=? WHERE UserId=?";
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(queryString);
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setInt(2, user.getUserId());
//            preparedStatement.executeUpdate();
//            System.out.println("Table Updated Successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null)
//                    preparedStatement.close();
//                if (connection != null)
//                    connection.close();
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void delete(int userId) {
//        try {
//            // TODO: Update queryString to fit ShippingRates table
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
//
//    @Override
//    public void findAll() {
//        // TODO: Update findall to fit ShippingRates object.
//        // TODO: return result set instead of printing to console
//        try {
//            String queryString = "SELECT * FROM Users";
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(queryString);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(
//                    "UserId " + resultSet.getInt("UserId")
//                    + ", FirstName " + resultSet.getString("FirstName")
//                    + ", SecondName " + resultSet.getString("SecondName")
//                    + ", Password " + resultSet.getString("Password")
//                    + ", Email " + resultSet.getString("Email"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null)
//                    resultSet.close();
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
