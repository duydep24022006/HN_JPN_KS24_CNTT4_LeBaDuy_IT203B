package SS9.Kt45P.Factory;

import SS9.Kt45P.Entity.DigitalProduct;
import SS9.Kt45P.Entity.PhysicalProduct;
import SS9.Kt45P.Entity.Product;

public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double extra) {
        if (type == 1) {
            return new PhysicalProduct(id, name, price, extra);
        } else if (type == 2) {
            return new DigitalProduct(id, name, price, extra);
        }
        return null;
    }
}
