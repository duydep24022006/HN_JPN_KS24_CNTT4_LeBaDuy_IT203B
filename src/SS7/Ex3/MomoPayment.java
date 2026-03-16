package SS7.Ex3;

public class MomoPayment implements EWalletPayable {

    @Override
    public void processEWallet(double amount) {

        System.out.println(
                "Xử lý thanh toán MoMo: " + (long)amount + " - Thành công"
        );

    }
}
