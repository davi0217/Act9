import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.Notification;
import javax.xml.catalog.CatalogResolver.NotFoundAction;

public class App {
    public static void main(String[] args) throws Exception {

        HashSet<String> ciudades = new HashSet<>();

        Scanner escaner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println(
                        "Please choose an option:\n1 - Add a city\n2 - Show all cities\n3 - Check a city\n 4 - Delete a city\n5 - Exit");
                int num = escaner.nextInt();
                switch (num) {
                    case 1:
                        System.out.print("Enter the name of the city you want to add: ");
                        String cityToAdd = escaner.next();
                        if (ciudades.contains(cityToAdd.toLowerCase())) {
                            System.out.println("Your city is already on the list");
                        } else {
                            ciudades.add(cityToAdd.toLowerCase());
                        }
                        break;
                    case 2:
                        if (ciudades.isEmpty()) {
                            System.out.print("The list of cities is empty\n");

                        } else {
                            for (String ciudad : ciudades) {
                                System.out.println("- " + ciudad);
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter the name of the city you want to look for:");
                        String cityToSearch = escaner.next().toLowerCase();
                        if (ciudades.contains(cityToSearch)) {
                            System.out.println("Your city is on the list");
                        } else {
                            System.out.println("Your city is not on the list");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the name of the city you want to delete: ");
                        String cityToDelete = escaner.next();
                        if (ciudades.contains(cityToDelete.toLowerCase())) {
                            ciudades.remove(cityToDelete.toLowerCase());
                        } else {
                            System.out.println("Your city is not on the list");
                        }
                        break;
                    case 5:
                        return;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please insert a number");
                escaner.nextLine();
            }
        }

    }
}
