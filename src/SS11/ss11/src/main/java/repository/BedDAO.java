package repository;

import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedDAO {
    public void updateBedStatus(String bedId) {
        String sql ="UPDATE bed SET status = 'Đang sử dụng' WHERE id = ?";

        try(Connection conn= DBContext.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
        ){
            ps.setString(1,bedId);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Cập nhật thành công: "+bedId);

            }else{
                System.out.println("Mã giường không tồn tại: "+bedId);
            }

        }catch (SQLException e){
            System.out.println("lỗi cập nhật DB");
            e.printStackTrace();
        }
    }
}
