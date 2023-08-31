import java.util.ArrayList;

/**
 * PACKAGE_NAME
 * Created by khanh
 * Date 4/15/2023 - 9:19 AM
 * Description: ...
 */
public class Product {
    private int id;
    private String thumbnail;
    private String name;
    private String description;
    private float price;

    public Product() {
    }

    public Product(int id, String thumbnail, String name, int price, String description) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static String[][] convertArrayListToStringArray(ArrayList<Product> products) {
        String[][] data = new String[products.size()][5];
        for (int i = 0; i < products.size(); i++) {
            data[i][0] = String.valueOf(products.get(i).getId());
            data[i][1] = products.get(i).getThumbnail();
            data[i][2] = products.get(i).getName();
            data[i][3] = String.valueOf(products.get(i).getPrice());
            data[i][4] = products.get(i).getDescription();
        }
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "id: " + id + ", thumbnail: " + thumbnail + ", name: " + name + ", price: " + price + ", description: " + description;
    }
}
