package gildedrose;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
    public static void main(String... args) throws ItemNotFoundException {
        Shop shop;
        ItemsRepository repository;
        repository=new InMemoryItemsRepository();
        shop = new Shop(repository);
        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;     
            
        while (recommencer) {
            printMenu(shop);
            sc.nextLine();
           }
       }
       
    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    
    private static void sellItem(Shop shop) throws ItemNotFoundException {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
        System.out.println("*                                                                                     *");
        System.out.println("* Veuillez donner le type d'article que vous voulez acheter ?                         *");
        System.out.println("*                                                                                     *");
        System.out.println("***************************************************************************************");
        String typeArticle = sc.next();
        System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
        System.out.println("*                                                                                     *");
        System.out.println("* Veuillez donner la qualité que vous voulez acheter ?                                *");
        System.out.println("*                                                                                     *");
        System.out.println("***************************************************************************************");
        int qualityArticle = sc.nextInt();
        sc.nextLine();
        shop.sellItem(typeArticle, qualityArticle);
        }



    private static void updateInventory(Shop shop) {
        clearScreen();
        shop.updateQuality();
        System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
        System.out.println("*                                                                                     *");
        System.out.println("*   Le shop a été mis à jour                                                          *");
        System.out.println("*                                                                                     *");
        System.out.println("***************************************************************************************");
        System.out.println(" press enter ");
    }



    static void displayBalance(Shop shop) {
        clearScreen();
        System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
        System.out.println("*                                                                                     *");
        System.out.println("*   Le solde du magasin est : " + shop.getSolde()+"                                                       *");
        System.out.println("***************************************************************************************");
        System.out.println(" press enter ");
    }

    private static void displayInventory(List<Item> items){
        clearScreen();

        System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
        System.out.println("* Article / Type / SELLIN / QUALITY / VALUE                                           *");
        for(Item i: items) {
            System.out.println("* "+ i.getItemName() +" / "+ i.getType() + " / "+i.getSellIn()+" / "+i.getQuality()+" / "+i.getValue());
        }
        System.out.println("***************************************************************************************");
        System.out.println(" press enter ");               
    } 

    private static void printMenu(Shop shop) throws ItemNotFoundException {
            clearScreen();
            Scanner sc = new Scanner(System.in);
            List<Item> items;
            System.out.println("*******************************Welcome to GILDEROSE shop*******************************");
            System.out.println("*                                                                                     *");
            System.out.println("*   1. Afficher les articles                                                          *");
            System.out.println("*   2. Afficher le solde du magasin                                                   *");
            System.out.println("*   3. Mise à jour des Articles                                                       *");
            System.out.println("*   4. vendre un article                                                              *");
            System.out.println("*                                                                                     *");
            System.out.println("*   0. EXIT                                                                           *");
            System.out.println("***************************************************************************************");
            System.out.println("                               Veuillez enter votre choix");
            int choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    items=shop.repository.getInventory();
                    displayInventory(items);
                    
                    break;
                case 2:
                    displayBalance(shop);
                    
                    break;
                case 3:
                    updateInventory(shop);
                    break;
                case 4:
                    sellItem(shop);
                    
                    break;
                default:
                    clearScreen();
                    System.out.println("Mauvaix choix, recommencer");
            }
    }
    
}

