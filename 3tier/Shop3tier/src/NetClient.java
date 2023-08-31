import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;

public class NetClient {
    public static ArrayList<Product> getAllProducts() {
        try {
            URL url = new URL("http://localhost:6789/product-list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            // Parse JSON response to list of Product objects
            Gson gson = new Gson();
            ArrayList<Product> productList = new ArrayList<>();
            Product[] products = gson.fromJson(sb.toString(), Product[].class);
            Collections.addAll(productList, products);
            return productList;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return null;
    }

    public static boolean addProduct(Product product) {
        try {
            URL url = new URL("http://localhost:6789/add-product");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.getOutputStream().write(new Gson().toJson(product).getBytes());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
            return Boolean.parseBoolean(sb.toString());
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return false;
    }

    public static boolean updateProduct(int id, Product product) {
        try {
            URL url = new URL("http://localhost:6789/update-product/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.getOutputStream().write(new Gson().toJson(product).getBytes());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
            return Boolean.parseBoolean(sb.toString());
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return false;
    }

    public static boolean deleteProduct(int id) {
        try {
            URL url = new URL("http://localhost:6789/delete-product/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
            return Boolean.parseBoolean(sb.toString());
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return false;
    }
}