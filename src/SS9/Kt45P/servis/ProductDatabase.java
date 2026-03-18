package SS9.Kt45P.servis;

import SS9.Kt45P.Entity.Product;

import java.util.List;

import java.util.*;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.set(i, newProduct);
                return;
            }
        }
    }


    public void deleteProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getProducts() {
        return products;
    }
}
