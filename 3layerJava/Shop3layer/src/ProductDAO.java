import java.sql.*;
import java.util.Properties;

public class ProductDAO {
    public static Connection connection = null;

    public static boolean connectDB() {
        try {
            // Connect MySQL
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String conString = "jdbc:mysql://localhost:3306/shop";
            Properties info = new Properties();
            info.setProperty("characterEncoding", "utf8");
            info.setProperty("user", "root");
            info.setProperty("password", "root");

            connection = DriverManager.getConnection(conString, info);
            if (connection != null) {
                System.out.println("Connect database successfully");
                return true;
            } else {
                System.out.println("Connect database failed");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet getAll() {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                String sql = "Select * from products";
                return st.executeQuery(sql);
            } else {
                System.out.println("Connect failed");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static int add(Product product) {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                String sql = "Insert into products (thumbnail, name, description, price) values ('" + product.getThumbnail() + "', '" + product.getName() + "', '" + product.getDescription() + "', " + product.getPrice() + ")";
                return st.executeUpdate(sql);
            } else {
                System.out.println("Connect failed");
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int update(int id, Product product) {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                // check id exist
                String sqlCheck = "Select * from products where id = " + id;
                ResultSet rs = st.executeQuery(sqlCheck);
                if (!rs.next()) {
                    System.out.println("Id not exist");
                    return 0;
                }
                st = connection.createStatement();
                String sql = "Update products set thumbnail = '" + product.getThumbnail() + "', name = '" + product.getName() + "', description = '" + product.getDescription() + "', price = " + product.getPrice() + " where id = " + id;
                return st.executeUpdate(sql);
            } else {
                System.out.println("Connect failed");
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                // check id exist
                String sqlCheck = "Select * from products where id = " + id;
                ResultSet rs = st.executeQuery(sqlCheck);
                if (!rs.next()) {
                    System.out.println("Id not exist");
                    return 0;
                }
                st = connection.createStatement();
                String sql = "Delete from products where id = " + id;
                return st.executeUpdate(sql);
            } else {
                System.out.println("Connect failed");
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
