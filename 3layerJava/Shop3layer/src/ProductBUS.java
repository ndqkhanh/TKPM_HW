import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductBUS {
    public static ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductDAO.getAll();
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setThumbnail(rs.getString(2));
                product.setName(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getFloat(5));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static int add(Product product) {
        return ProductDAO.add(product);
    }

    public static int update(int id, Product product) {
        return ProductDAO.update(id, product);
    }

    public static int delete(int id) {
        return ProductDAO.delete(id);
    }
}
