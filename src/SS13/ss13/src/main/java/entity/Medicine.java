package entity;

public class Medicine {
    private String medicineId;
    private String name;
    private int stock;

    public Medicine(String medicineId, String name, int stock) {
        this.medicineId = medicineId;
        this.name = name;
        this.stock = stock;
    }

    public String getMedicineId() { return medicineId; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return medicineId + " | " + name + " | " + stock;
    }
}
