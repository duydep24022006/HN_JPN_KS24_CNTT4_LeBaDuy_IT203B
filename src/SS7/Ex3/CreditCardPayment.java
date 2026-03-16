package SS7.Ex3;

public class CreditCardPayment implements CardPayable {

    @Override
    public void processCard(double amount) {

        System.out.println(
                "Xử lý thanh toán thẻ tín dụng: " + (long)amount + " - Thành công"
        );

    }
}

