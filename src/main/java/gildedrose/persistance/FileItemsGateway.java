package gildedrose.persistance;

import gildedrose.core.domain.ItemsGateway;
import gildedrose.core.domain.item.*;
import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FileItemsGateway implements ItemsGateway {

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
                items.add(new LegendaryItem());
            }
            else if(itemName == "Aged Brie"){
                items.add(AgingItem.builder().sellIn(sellIn).quality(quality).build());
            }
            else if(itemName == "Backstage Passes"){
                items.add(EventItem.builder().sellIn(sellIn).quality(quality).build());
            }
            else if(itemName == "Conjured"){
                items.add(ConjuredItem.builder().sellIn(sellIn).quality(quality).build());
            }
            else{
                items.add(GenericItem.builder().sellIn(sellIn).quality(quality).build());
            }
        }
        sc.close();
        return items;

    }

    @Override
    public void saveInventory(List<Item> items) throws FileNotFoundException {
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
    public Item findItem(String type, int quality) throws FileNotFoundException {

        List<Item> items = getInventory();
        Item result = null;

        for(Item i : items){

            if((i.getItemName() == type) && (i.getQuality() == quality)){

                result = i;

            }

        }

        return result;
    }

    @Override
    public void updateInventory(Item item) throws FileNotFoundException {

        List<Item> items = getInventory();
        int i = 0;

        for (Item item1 : items){

            if(item1 == item){

                items.remove(i);

            }

            else i++;

        }

        saveInventory(items);

    }

}
