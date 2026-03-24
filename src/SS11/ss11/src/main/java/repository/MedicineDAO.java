package repository;

import entity.Medicine;
import utility.DBContext;

import java.sql.*;

public class MedicineDAO {
    public void prinMedicineList(){
        String sql="select * from medicine";
        try(
                Connection conn= DBContext.getConnection();
                PreparedStatement ps= conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                ){
            System.out.println("===DANH MỤC THUỐC===");
            boolean isEmpty=true;
            while (rs.next()) {
                Medicine m = new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity")
                );

                System.out.println(m);
            }
            if(isEmpty){
                System.out.println("khoogn có trong kho");
            }
        }catch (SQLException e){
            System.out.println("lỗi truy vấn ");
            e.printStackTrace();
        }
    }
}
