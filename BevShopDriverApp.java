package aa;

import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop shop = new BevShop();
        boolean running = true;

        while (running) {
        	//input to start a new order 
            System.out.println("#------------------------------------#");
            System.out.println("Would you please start a new order?");
            shop.startNewOrder(true);
            //user name
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            //user age 
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            //output based in user age 
            if (age >= 21) {
                System.out.println("Your age is above 21 and you are eligible to order alcohol.");
            } else {
                System.out.println("Your age is not appropriate for alcohol drinks!!");
            }

            boolean addingAlcohol = true;
            int alcoholCount = 0;
            
            //max user at 3 drinks 
            while (addingAlcohol) {
                if (age >= 21 && alcoholCount < 3) {
                    System.out.print("Would you please add an alcohol drink? (yes/no): ");
                    String response = scanner.nextLine().trim().toLowerCase();
                    
                    //add drink if use inputs yes
                    if (response.equals("yes")) {
                        shop.addAlcohol("Alcohol", Size.LARGE);
                        alcoholCount++;
                        //num of drinks and price
                        System.out.println("The current order of drinks is " + alcoholCount);
                        System.out.println("The Total Price on the Order: " + shop.calculateTotalSales());
                        if (alcoholCount == 3) {
                        	//print when alc is maxed 
                            System.out.println("You have a maximum alcohol drinks for this order.");
                            addingAlcohol = false;
                        }
                    } else {
                        addingAlcohol = false;
                    }
                } else {
                    break;
                }
            }

            boolean addingCoffee = true;
            while (addingCoffee) {
            	//ask user for coffee
                System.out.print("Would you please add a COFFEE to your order? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes")) {
                	//add coffee as user says yes
                    shop.addCoffee("Coffee", Size.MEDIUM, false, false);
                    //output num of drinks and price
                    System.out.println("Total items on your order is " + shop.getNumOfOrders());
                    System.out.println("The Total Price on the Order: " + shop.calculateTotalSales());
                } else {
                    addingCoffee = false;
                }
            }

            boolean addingSmoothie = true;
            while (addingSmoothie) {
            	//ask user for smoothie 
                System.out.print("Would you please add a SMOOTHIE to your order? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes")) {
                	//add smoothie after user says yes
                    shop.addSmoothie("Smoothie", Size.SMALL, 2, true);
                    //output price
                    System.out.println("The Total Price on the Order: " + shop.calculateTotalSales());
                } else {
                    addingSmoothie = false;
                }
            }
            //total price
            System.out.println("The Total Price at the end of this order: $" + shop.calculateTotalSales());
            System.out.println("#------------------------------------#");
            
            //ask user if a new order wants to be started
            System.out.print("Would you like to start a new order? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("no")) {
                running = false;
            }
        }

        scanner.close();
    }
}
