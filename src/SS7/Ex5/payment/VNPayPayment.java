package SS7.Ex5.payment;

public class VNPayPayment implements PaymentMethod {

    public void pay(double amount){
        System.out.println("Thanh toán VNPay: "+amount);
    }
}
