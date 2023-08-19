package org.example.ihm;

import org.example.service.CustomerSERVICE;

import java.util.Scanner;

public class IhmConsole {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerSERVICE customerSERVICE = new CustomerSERVICE();

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Ajouter un client");
            System.out.println("2. Effectuer un dépot");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Afficher toutes les opérations d'un client");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AddCustomer();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
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

        customerSERVICE.createCustomer(firstName,lastName,phoneNumber);
    }
}
