package bt45p.service;

import bt45p.entity.Account;
import bt45p.prepository.AccountDAO;

import java.sql.*;

public class TransferService {
    private Connection conn;
    private AccountDAO dao;

    public TransferService(Connection conn) {
        this.conn = conn;
        this.dao = new AccountDAO(conn);
    }

    public void transfer(String senderId, String receiverId, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false);

            Account sender = dao.getAccountById(senderId);
            if (sender == null || sender.getBalance() < amount) {
                System.out.println(" Số dư không đủ hoặc tài khoản không tồn tại!");
                conn.rollback();
                return;
            }

            try (CallableStatement cs1 = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                cs1.setString(1, senderId);
                cs1.setBigDecimal(2, new java.math.BigDecimal(-amount));
                cs1.execute();
            }

            try (CallableStatement cs2 = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                cs2.setString(1, receiverId);
                cs2.setBigDecimal(2, new java.math.BigDecimal(amount));
                cs2.execute();
            }

            conn.commit();
            System.out.println(" Chuyển khoản thành công!");

            for (Account acc : dao.getAccounts(senderId, receiverId)) {
                System.out.println(acc);
            }

        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}