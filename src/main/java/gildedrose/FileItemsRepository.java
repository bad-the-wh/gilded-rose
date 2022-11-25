package gildedrose;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileItemsRepository implements ItemsRepository{

    FileWriter file = null;
    public List<Item> items;
    //Délimiteurs qui doivent être dans le fichier CSV
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    //En-tête de fichier
    private static final String HEADER = "ItemName,SellIn,Quality";

    @Override
    public List<Item> getInventory(){
        List<Item> items = null;
        Scanner sc = null;
        try {
            sc = new Scanner(new File("../../../../Demo.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(DELIMITER);   //sets the delimiter pattern
        while(sc.hasNext())
        {
            String itemName = sc.next();
            int sellIn = parseInt(sc.next());
            int quality = parseInt(sc.next());
            Item i = null;
            if(itemName == "Sulfuras"){
                items.add(new LegendaryItem(sellIn, quality));
            }
            else if(itemName == "Aged Brie"){
                items.add(new AgingItem(sellIn, quality));
            }
            else if(itemName == "Backstage Passes"){
                items.add(new EventItem(sellIn, quality));
            }
            else if(itemName == "Conjured"){
                items.add(new ConjuredItem(sellIn, quality));
            }
            else{
                items.add(new GenericItem(sellIn, quality));
            }
        }
        sc.close();
        return items;

    }

    @Override
    public void saveInventory(List<Item> items) {
        try
        {
            file = new FileWriter("../../../../Demo.csv");
            //Ajouter l'en-tête
            file.append(HEADER);
            //Ajouter une nouvelle ligne après l'en-tête
            file.append(SEPARATOR);
            //Itérer bookList
            Iterator it = items.iterator();
            while(it.hasNext())
            {
                Item i = (Item)it.next();
                file.append(i.getItemName());
                file.append(DELIMITER);
                file.append(String.valueOf(i.getSellIn()));
                file.append(DELIMITER);
                file.append(String.valueOf(i.getQuality()));
                file.append(SEPARATOR);
            }

            file.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public Item findItem(String type, int quality) {
        // TODO Auto-generated method stub
        return null;
    }

}
