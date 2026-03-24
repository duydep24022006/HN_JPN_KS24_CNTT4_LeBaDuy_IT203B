package repository;

import utility.DBContext;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class SurgeryDAO {

    public BigDecimal getSurgeryFee(String surgeryId) {
        String sql = "{call GET_SURGERY_FEE(?, ?)}";

        try (Connection conn = DBContext.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, surgeryId);                 // IN parameter
            cs.registerOutParameter(2, Types.DECIMAL);  // OUT parameter

            cs.execute();

            return cs.getBigDecimal(2);                 // lấy kết quả OUT
        } catch (SQLException e) {
            System.out.println("Lỗi khi gọi Stored Procedure: " + e.getMessage());
            return null;
        }
    }
}