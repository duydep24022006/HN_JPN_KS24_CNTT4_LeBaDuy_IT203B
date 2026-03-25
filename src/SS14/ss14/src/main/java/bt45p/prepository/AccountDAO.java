package bt45p.prepository;

import bt45p.entity.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection conn;

    public AccountDAO(Connection conn) {
        this.conn = conn;
    }

    public Account getAccountById(String accountId) throws SQLException {
        String sql = "SELECT AccountId, FullName, Balance FROM Accounts WHERE AccountId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance")
                );
            }
        }
        return null;
    }

    public List<Account> getAccounts(String... ids) throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT AccountId, FullName, Balance FROM Accounts WHERE AccountId IN (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ids[0]);
            ps.setString(2, ids[1]);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance")
                ));
            }
        }
        return list;
    }
}

