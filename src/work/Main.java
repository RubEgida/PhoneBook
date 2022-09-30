package work;

import model.NumberType;
import model.User;
import service.ContactsManagement;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static model.NumberType.*;
import static model.InboxType.*;

/**
 * Type for testing.
 * @author Ruben
 */
public class Main {

    /**
     * Method for work.
     * @param args -
     */
    public static void main(String[] args) {

        ContactsManagement hr = new ContactsManagement();
        User record;
        Scanner input = new Scanner(System.in);

        int option;

        do {
            menu();
            try {
                option = input.nextInt();
            } catch (NoSuchElementException e) {
                input = new Scanner(System.in);
                System.out.println("\t !!!Enter only numbers. At 1 from 6 for SELECTION!!!");
                System.out.print("Enter your selection -> ");
                option = input.nextInt();
            }

            switch (option) {
                case 1 -> {
                    HashMap<NumberType, Integer> map = new HashMap<>();
                    System.out.print("What is the Contact name? -> ");
                    String firstname = input.next();
                    int numberType;
                    System.out.print("Enter " + numType(1) + " number -> \t(+374) 0");
                    int phoneNumber;
                    try {
                        phoneNumber = input.nextInt();
                    } catch (NoSuchElementException e) {
                        input = new Scanner(System.in);
                        System.out.println("\t !!!Enter only Armenian Phone numbers!!!");
                        System.out.print("Like this(98-888-888)! Enter phone number -> ");
                        phoneNumber = input.nextInt();
                    }
                    if (Integer.toString(phoneNumber).length() != 8) {
                        System.out.println("""
                                \t!!!Maybe WRONG phone number!!!
                                 \t\tYou can update later.
                                """);
                    }
                    map.put(numType(1), phoneNumber);
                    System.out.println("You want add more numbers? (yes/no)");
                    System.out.print("Enter your selection -> ");
                    String y_n = input.next();
                    if (y_n.equals("yes")) {
                        numSelect();
                        try {
                            numberType = input.nextInt();
                        } catch (NoSuchElementException e) {
                            input = new Scanner(System.in);
                            System.out.println("\t !!!Enter only numbers. At 1 from 4 for SELECTION!!!");
                            System.out.print("Enter your selection -> ");
                            numberType = input.nextInt();
                        }
                        while (numberType > 4) {
                            System.out.print("Enter your selection -> ");
                            numberType = input.nextInt();
                            System.out.print("Enter " + numType(numberType) + " number -> \t(+374) 0");
                        }
                        if (numberType != 1) {
                            System.out.print("Enter " + numType(numberType) + " number -> \t(+374) 0");
                            phoneNumber = input.nextInt();
                            map.put(numType(numberType), phoneNumber);
                        }
                    }
                    System.out.print("Which type inbox you want save?\n 1: " + G_MAIL.getInbox() +
                            "\t 2: " + I_CLOUD.getInbox() + "\t 3: " + OUT_LOOK.getInbox() + "\t 4: " +
                            CUSTOM_MAIL.getInbox() + "\nEnter your selection -> ");
                    int inboxType;
                    try {
                        inboxType = input.nextInt();
                    } catch (NoSuchElementException e) {
                        input = new Scanner(System.in);
                        System.out.println("\t !!!Enter only numbers. At 1 from 4 for SELECTION!!!");
                        System.out.print("Enter your selection -> ");
                        inboxType = input.nextInt();
                    }
                    inboxType(inboxType);
                    while (inboxType > 4) {
                        System.out.print("Enter your selection -> ");
                        inboxType = input.nextInt();
                        inboxType(inboxType);
                    }
                    String inbox = input.next();
                    record = new User(firstname, map, inbox);
                    hr.add(record);
                    System.out.println(record);
                }
                case 2 -> {
                    System.out.print("What is the Contact name? ->");
                    String f_name = input.next();
                    hr.delete(f_name);
                }
                case 3 -> {
                    System.out.print("What is the Contact name? ->");
                    String f$name = input.next();
                    hr.update(f$name, input);
                }
                case 4 -> {
                    System.out.print("What is the Contact name? -> ");
                    String name = input.next();
                    if (!hr.find(name)) {
                        System.out.println("\nContact does not exist!\n");
                    }
                }
                case 5 ->
                        hr.display();

                case 6 -> {
                    System.out.println("\nThank you for using the program. Goodbye!\n");
                    System.exit(0);
                }

                default ->
                        System.out.println("\nInvalid input\n");

            }
        }

        while (true);
    }

    /**
     * Menu look.
     */
    private static void menu() {
        System.out.println("MENU");
        System.out.println("1: Add Contact");
        System.out.println("2: Delete Contact");
        System.out.println("3: Update Contact");
        System.out.println("4: Search Contact");
        System.out.println("5: Display Contact");
        System.out.println("6: Exit program");
        System.out.print("Enter your selection -> ");
    }

    /**
     * For typing.
     * @param numberType - phone number type
     * @return one of types
     */
    private static NumberType numType(final int numberType) {
        switch (numberType){
            case 1 -> {
                return MOBILE;
            }

            case 2 -> {
                return HOME;
            }

            case 3 -> {
                return WORK;
            }

            case 4 -> {
                return SCHOOL;
            }

        }
        return null;
    }

    /**
     * For typing.
     * @param selection - tack inbox type
     */
    private static void inboxType(final int selection) {
        switch (selection) {
            case 1 ->
                System.out.print("Enter " + G_MAIL.getInbox() + " -> \t");

            case 2 ->
                System.out.print("Enter " + I_CLOUD.getInbox() + " -> \t");

            case 3 ->
                System.out.print("Enter " + OUT_LOOK.getInbox() + " -> \t");

            case 4 ->
                System.out.print("Enter " + CUSTOM_MAIL.getInbox() + " -> \t");

            default ->
                System.out.print("\nInvalid input\n");

        }
    }

    /**
     * Look for select.
     */
    private static void numSelect() {
        System.out.print("Which number you want save?\n " +
                "\t 2: " + HOME.getNumberType() + "\t 3: " + WORK.getNumberType() +
                "\t 4: " + SCHOOL.getNumberType() + "\nEnter your selection -> ");
    }

}
