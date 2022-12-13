package gildedrose.persistance;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import gildedrose.core.domain.ItemsGateway;
import gildedrose.core.domain.item.*;

import java.sql.*;


import static java.lang.Integer.parseInt;

public class DbItemsGateway implements ItemsGateway{

    FileWriter file = null;
    public List<Item> items;
    
    @Override
    public List<Item> getInventory(){
        List<Item> items = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT * FROM  ITEMS");
            ResultSet item = preparedStatement.executeQuery();
            while(item.next()){
                items.add(item.getString("TYPE"),item.getInt("SELLIN"),item.getInt("QUALITY"),item.getInt("BASEPRICE"));
            }
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
        return items; 
    }

    @Override
    public void saveInventory(List<Item> items) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Item findItem(String type, int quality)  {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateInventory(Item item) throws FileNotFoundException {
        // TODO Auto-generated method stub
        
    }

}