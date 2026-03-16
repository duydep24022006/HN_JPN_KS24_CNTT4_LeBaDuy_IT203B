package SS7.Ex5.notification;

public class SMSNotification implements NotificationService {

    public void send(String message,String recipient){
        System.out.println("Đã gửi SMS");
    }
}
