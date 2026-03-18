package SS9.Kt45P.Entity;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    @Override
    public void displayInfo() {
        System.out.println("Physical Product - ID: " + getId() + ", Name: " + getName() +
                ", Price: " + getPrice() + ", Weight: " + weight + "kg");
    }
}

