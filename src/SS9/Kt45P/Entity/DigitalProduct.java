package SS9.Kt45P.Entity;

public class DigitalProduct extends Product {
    private double sizeMB;

    public DigitalProduct(String id, String name, double price, double sizeMB) {
        super(id, name, price);
        this.sizeMB = sizeMB;
    }

    @Override
    public void displayInfo() {
        System.out.println("Digital Product - ID: " + getId() + ", Name: " + getName() +
                ", Price: " + getPrice() + ", Size: " + sizeMB + "MB");
    }
}

