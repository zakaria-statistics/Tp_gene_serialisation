package Tp_generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Produit> listProduct = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        //Test d'implementation des cas:

        IMetier<Produit> metier = new MetierProduitImpl(listProduct, "product.txt");

        int x = 0;
        do {
            System.out.println("-----Product------");
            System.out.println("1. Add product to product list");
            System.out.println("2. find product by id");
            System.out.println("3. Display all product details");
            System.out.println("4. delete product");
            System.out.println("5. Serialize Product");
            System.out.println("6. Exit");
            System.out.println("Choice:");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter id product :");
                    long id = scan.nextLong();
                    System.out.println("Enter name product :");
                    String nom = scan.next();
                    System.out.println("Enter marque product :");
                    String marque = scan.next();
                    System.out.println("Enter price product :");
                    double prix = scan.nextDouble();
                    System.out.println("Enter description product :");
                    String desc = scan.next();
                    System.out.println("Enter nbrEnStock product :");
                    int nbrEnStock = scan.nextInt();
                    Produit p = new Produit(id, nom, marque, prix, desc, nbrEnStock);
                    metier.add(p);
                    break;
                case 2:
                    System.out.println("enter id Product :");
                    long idpr = scan.nextLong();
                    Produit prod = metier.findById(idpr);
                    System.out.println(prod);
                    break;
                case 3:
                    System.out.println(metier.getAll());
                    break;
                case 4:
                    System.out.println("enter id product :");
                    long idp = scan.nextLong();
                    metier.delete(idp);
                    System.out.println(metier.getAll());
                    break;
                case 5:
                    metier.saveAll();
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("choose from the switch list!");
            }

        }while (x!=7);
    }
}
