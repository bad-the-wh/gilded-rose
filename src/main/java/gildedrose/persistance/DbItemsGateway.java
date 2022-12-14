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
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT * FROM  ITEMS");
            ResultSet line = preparedStatement.executeQuery();
            
            while(line.next()){
                String type = line.getString("TYPE");
                int sellin = line.getInt("SELLIN");
                int quality = line.getInt("QUALITY");
                int basePrice = line.getInt("BASEPRICE");
                if(type == "LegendaryItem"){
                    items.add(new LegendaryItem(sellin,quality,basePrice));
                }
                else if(type == "AgingItem"){
                    items.add(new AgingItem(sellin,quality,basePrice));
                }
                else if(type == "EventItem"){
                    items.add(new EventItem(sellin,quality,basePrice));
                }
                else if(type == "ConjuredItem"){
                    items.add(new ConjuredItem(sellin,quality,basePrice));
                }
                else{
                    items.add(new GenericItem(sellin,quality,basePrice));
                }
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
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            
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

    @Override
    public Item findItem(String type, int quality)  {
        Item item = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT * FROM  ITEMS WHERE TYPE=? AND QUALITY=?");
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, quality);
            ResultSet line = preparedStatement.executeQuery();
            if (line != null ){
                int sellin = line.getInt("SELLIN");
                int basePrice = line.getInt("BASEPRICE");
                if(type == "LegendaryItem"){
                    items.add(new LegendaryItem(sellin,quality,basePrice));
                }
                else if(type == "AgingItem"){
                    items.add(new AgingItem(sellin,quality,basePrice));
                }
                else if(type == "EventItem"){
                    items.add(new EventItem(sellin,quality,basePrice));
                }
                else if(type == "ConjuredItem"){
                    items.add(new ConjuredItem(sellin,quality,basePrice));
                }
                else{
                    items.add(new GenericItem(sellin,quality,basePrice));
                }
            }else{
                // item non trouvé dans la base 
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
    }
    }

    @Override
    public void updateInventory(Item item) throws FileNotFoundException {
        // TODO Auto-generated method stub
        
    }

}