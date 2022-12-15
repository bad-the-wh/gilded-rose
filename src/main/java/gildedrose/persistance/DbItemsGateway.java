package gildedrose.persistance;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import gildedrose.core.domain.ItemsGateway;
import gildedrose.core.domain.item.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;


import static java.lang.Integer.parseInt;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class DbItemsGateway implements ItemsGateway{

    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getInventory(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT * FROM  ITEMS");
            ResultSet line = preparedStatement.executeQuery();

            while(line.next()){
                String type = line.getString("TYPE");
                int sellIn = line.getInt("SELLIN");
                int quality = line.getInt("QUALITY");
                int basePrice = line.getInt("BASEPRICE");
                if(type.equals("LegendaryItem")){
                    items.add(LegendaryItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                }
                else if(type.equals("AgingItem")){
                    items.add(AgingItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                }
                else if(type.equals("EventItem")){
                    items.add(EventItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                }
                else if(type.equals("ConjuredItem")){
                    items.add(ConjuredItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                }
                else{
                    System.out.println(type);
                    items.add(GenericItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                    System.out.println("test");
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
            Statement _deleteTableDtataStmt = null;
            String _deleteTableData ="TRUNCATE TABLE ITEMS";
            _deleteTableDtataStmt.executeUpdate(_deleteTableData);
            Iterator it = items.iterator();
            PreparedStatement preparedStatement=conn.prepareStatement("INSERT INTO ITEMS(TYPE,SELLIN,QUALITY,BASEPRICE) VALUES (?,?;?,?)");
            while(it.hasNext())
            {
                Item i = (Item)it.next();
                String type = i.getItemName();
                int sellIn = i.getSellIn();
                int quality = i.getQuality();
                int basePrice = i.getBasePrice();
                preparedStatement.setString(1, type);
                preparedStatement.setInt(2, sellIn);
                preparedStatement.setInt(3, quality);
                preparedStatement.setInt(4,basePrice);
                ResultSet line = preparedStatement.executeQuery();
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
                int sellIn = line.getInt("SELLIN");
                int basePrice = line.getInt("BASEPRICE");
                if(type == "LegendaryItem"){
                    item=LegendaryItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build();
                }
                else if(type == "AgingItem"){
                    item=AgingItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build();
                }
                else if(type == "EventItem"){
                    item=EventItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build();
                }
                else if(type == "ConjuredItem"){
                    item=ConjuredItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build();
                }
                else{
                    item=GenericItem.builder().sellIn(sellIn).quality(quality).basePrice(basePrice).build();
                }
            }else{
                System.out.println("Objet non trouvé");
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
        return item;
    }


    @Override
    public void updateInventory(Item item) throws FileNotFoundException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://epsi-tp001.cdtv1lsfjbfz.eu-west-3.rds.amazonaws.com/GILDEROSE?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","admin","EPSITP01");
            PreparedStatement preparedStatement=conn.prepareStatement("DELETE FROM ITEMS WHERE TYPE= ? and SELLIN=? and QUALITY= ? and BASEPRICE=?");
            String type = item.getItemName();
            int sellIn = item.getSellIn();
            int quality = item.getQuality();
            int basePrice = item.getBasePrice();
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, sellIn);
            preparedStatement.setInt(3, quality);
            preparedStatement.setInt(4,basePrice);
            ResultSet line = preparedStatement.executeQuery();
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
