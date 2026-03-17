package OBSERVER_B4;

public interface Subject {

    void attach(Observer o);

    // hủy đăng ký
    void detach(Observer o);

    // thông báo cho tất cả thiết bị
    void notifyObservers();
}