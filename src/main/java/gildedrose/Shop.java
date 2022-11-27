package gildedrose;

import java.util.List;

public class Shop {

    private ItemsRepository repository;
    public int solde;


    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Shop(ItemsRepository repository) {
        this.repository = repository;
    }

    public void updateQuality() {
        List<Item> items = this.repository.getInventory();
        for (Item item : items) {
            item.update();
            }
        this.repository.saveInventory(items);
    }

    public Integer sellItem(String type, int quality) throws ItemNotFoundException {
        try{
            Item item = repository.findItem(type, quality);
            System.out.println("l'item trouvé est :"+item.getType());
            solde = solde + item.getValue();
            repository.deleteItem(item);
            
        }
        catch (ItemNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return solde;
    }

    }
