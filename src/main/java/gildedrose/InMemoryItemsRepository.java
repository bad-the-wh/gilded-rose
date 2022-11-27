package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemsRepository implements ItemsRepository{
    private List<Item> items;

    public InMemoryItemsRepository() {
        items = new ArrayList<Item>();
        items.add(new GenericItem(5, 8));
        items.add(new GenericItem(0, 8));
        items.add(new GenericItem(0, 1));

        items.add(new AgingItem(5, 8));
        items.add(new AgingItem(5, 50));

        items.add(new LegendaryItem(6, 80));

        items.add(new EventItem(12, 8));
        items.add(new EventItem(11, 50));
        items.add(new EventItem(9, 33));
        items.add(new EventItem(4, 21));
        items.add(new EventItem(0, 30));

        items.add(new ConjuredItem(5, 8));
        items.add(new ConjuredItem(0, 8));
        items.add(new ConjuredItem(0, 3));

    }

    @Override
    public List<Item> getInventory() {
        return items;
    }

    @Override
    public void saveInventory(List<Item> items) {
        this.items=items;

    }
    
    @Override

    public Item findItem(String type, int quality) throws ItemNotFoundException {
        Item found = null;
        
        for(Item i: items) {
            String typeItem = i.getType();
            if (type.equals(typeItem)){
                int iquality = i.getQuality();
                if (iquality==quality){
                    found = i;
                }
            }
        }
        if (found == null){
            throw new ItemNotFoundException("objet non disponnible, la vente est anuulée");
        }
        return found;
    }

    @Override
    public void deleteItem(Item item) {
        int index = items.indexOf(item);
        items.remove(index);
    }

}
