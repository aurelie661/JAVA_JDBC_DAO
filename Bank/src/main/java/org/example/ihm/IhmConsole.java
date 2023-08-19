package org.example.ihm;
import org.example.entity.Customer;
import org.example.service.CustomerSERVICE;
import java.util.Scanner;

public class IhmConsole {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerSERVICE customerSERVICE = new CustomerSERVICE();
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("\t\t###  IHM Console  ###");
            System.out.println("\t\t1. Ajouter un client");
            System.out.println("\t\t2. Modifier un client");
            System.out.println("\t\t3. Supprimer un client");
            System.out.println("\t\t4. Effectuer un dépot");
            System.out.println("\t\t5. Effectuer un retrait");
            System.out.println("\t\t6. Afficher toutes les opérations d'un client");
            System.out.println("\t\t7. Quitter");
            System.out.println();
            System.out.print("\t\tChoix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1 -> AddCustomer();
                case 2 -> updateCustomer();
                case 3 -> deleteCustomer();
                case 7 -> running = false;
                default -> System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }
    private static void AddCustomer(){
        System.out.print("Nom du client : ");
        String firstName = scanner.nextLine();
        System.out.print("Prénom du client : ");
        String lastName = scanner.nextLine();
        System.out.print("Numéro de téléphone du client : ");
        String phoneNumber = scanner.nextLine();
        if(customerSERVICE.createCustomer(firstName,lastName,phoneNumber)){
            System.out.println();
            System.out.println("Client ajouté avec succés. ");
            System.out.println();
        }else{
            System.out.println("Client non ajouté.");
            System.out.println();
        }
    }
    private  static void updateCustomer(){
        for (Customer c :
                customerSERVICE.getAllCustomers()) {
            System.out.println(c);
            System.out.println();
        }
        System.out.print("Quel client voulez-vous modifier (Veuillez noter l'id du client):");
        long idCustomer = scanner.nextLong();
        scanner.nextLine();
        if(customerSERVICE.getCustomerbyId(idCustomer) != null){
            System.out.print("Nom du client : ");
            String firstName = scanner.nextLine();
            System.out.print("Prénom du client : ");
            String lastName = scanner.nextLine();
            System.out.print("Numéro de téléphone du client : ");
            String phoneNumber = scanner.nextLine();
            Customer customerFound = new Customer((int) idCustomer,firstName,lastName,phoneNumber);
            if(customerSERVICE.updateCustomer(customerFound)){
                System.out.println();
                System.out.println("Le client a bien été modifié");
                System.out.println();
            }else{
                System.out.println();
                System.out.println("Le client n'a pas été modifié");
                System.out.println();
            }
        }else {
            System.out.println("Aucun client n'a cet id !");
        }
    }
    private static void deleteCustomer(){
        for (Customer c :
                customerSERVICE.getAllCustomers()) {
            System.out.println(c);
            System.out.println();
        }
        System.out.print("Quel client voulez-vous supprimer (Veuillez noter l'id du client):");
        long idCustomer = scanner.nextLong();
        scanner.nextLine();
        if(customerSERVICE.getCustomerbyId(idCustomer) != null){
            Customer customerFound = customerSERVICE.getCustomerbyId(idCustomer);
            customerSERVICE.deleteCustomer(customerFound);
            System.out.println("Client supprimer avec succés.");
        }else{
            System.out.println("Aucun client trouvé pour cet id!");
        }
    }
}
