package gildedrose.persistance;

import gildedrose.core.domain.ItemsGateway;
import gildedrose.core.domain.item.*;
import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
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
        List<Item> items = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Demo.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(DELIMITER);   //sets the delimiter pattern
        int count = 0;
        while(sc.hasNext())
        {
            System.out.println(count);
            String itemName = sc.next();
            System.out.println(itemName);
            int sellIn = parseInt(sc.next());
            System.out.println(sellIn);
            int quality = parseInt(sc.next());
            System.out.println(quality);
            int basePrice = parseInt(sc.next());
            System.out.println(basePrice);
            Item i = null;
            count += 1;
            System.out.println(count);
            if(itemName.equals("LegendaryItem")){
                items.add(LegendaryItem.builder().itemName(itemName).sellIn(sellIn).quality(quality).basePrice(basePrice).build());
            }
            else if(itemName.equals("AgingItem")){
                items.add(AgingItem.builder().itemName(itemName).sellIn(sellIn).quality(quality).basePrice(basePrice).build());
            }
            else if(itemName.equals("EventItem")){
                items.add(EventItem.builder().itemName(itemName).sellIn(sellIn).quality(quality).basePrice(basePrice).build());
            }
            else if(itemName.equals("ConjuredItem")){
                items.add(ConjuredItem.builder().itemName(itemName).sellIn(sellIn).quality(quality).basePrice(basePrice).build());
            }
            else{System.out.println(count);
                items.add(GenericItem.builder().itemName(itemName).sellIn(sellIn).quality(quality).basePrice(basePrice).build());
                System.out.println(count);
            }
            System.out.println(count);
        }
        sc.close();
        System.out.println(count);
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
