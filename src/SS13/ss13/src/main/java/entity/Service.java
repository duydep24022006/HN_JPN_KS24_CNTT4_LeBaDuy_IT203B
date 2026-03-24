package entity;

import java.sql.Timestamp;

public class Service {
    private String serviceName;
    private int quantity;
    private Timestamp serviceTime;

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Timestamp getServiceTime() { return serviceTime; }
    public void setServiceTime(Timestamp serviceTime) { this.serviceTime = serviceTime; }
}
