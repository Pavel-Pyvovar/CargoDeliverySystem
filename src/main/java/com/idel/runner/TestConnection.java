//package runner;
//
//import connection.DataSourceFactory;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TestConnection {
//    public static void main(String[] args) {
//        testConnection();
//    }
//
//    private static void testConnection() {
//        DataSource ds = DataSourceFactory.getMySQLDataSource();
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            con = ds.getConnection();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select UserId, FirstName from Users");
//            while(rs.next()){
//                System.out.println("User ID="+rs.getInt("UserId")+", Name="+rs.getString("FirstName"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if(rs != null) rs.close();
//                if(stmt != null) stmt.close();
//                if(con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
