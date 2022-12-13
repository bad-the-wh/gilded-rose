package gildedrose;

import java.sql.*;


public class TestConnection {
    public static void main(String... args){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT * FROM  ITEMS");
            ResultSet item = preparedStatement.executeQuery();
            while(item.next()){
                System.out.println(item.getString("TYPE"));
            }          
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

