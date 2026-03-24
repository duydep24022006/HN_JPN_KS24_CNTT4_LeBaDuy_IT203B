package entity;

public class Bed {
    private String id;
    private String status;

    public Bed(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bed() {
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
