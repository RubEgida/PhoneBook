package service;

import model.NumberType;
import model.User;

import java.util.*;

/**
 * CRUD methods.
 * @author Ruben
 */
public class ContactsManagement {
    ArrayList<User> list;

    /**
     * Constructor for creating object at list.
     */
    public ContactsManagement() {
        list = new ArrayList<>();
    }

    /**
     * Adding contact in list.
     * @param contact - contact
     */
    public void add(final User contact) {
        if (!find(contact.getUserFirstName())) {
            list.add(contact);
        } else {
            System.out.println("This number have in contacts.");
        }
    }

    /**
     * Find contact with name.
     * @param name - contact name
     * @return have contact or no
     */
    public boolean find(final String name) {
        for (User u: list) {
            if (u.getUserFirstName().equals(name)) {
                System.out.println(u);
                return true;
            }
        }
        return false;
    }

    /**
     * Contact deleting.
     * @param name - contact name
     */
    public void delete(final String name)
    {
        User contactDel = null;

        for (User uu : list) {
            if (uu.getUserFirstName().equals(name)) {
                contactDel = uu;
            }
        }

        if (contactDel == null) {
            System.out.println("Invalid Contact name.");
        } else {
            list.remove(contactDel);
            System.out.println("Successfully removed contact from the list");
        }
    }

    /**
     * Contact find and return.
     * @param name - contact name
     * @return find contact
     */
    public User findContact(final String name) {
        for (User l : list) {
            if (l.getUserFirstName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Contact updating.
     * @param name - contact name
     * @param input - console input
     */
    public void update(final String name, Scanner input) {
        if (find(name)) {
            HashMap<NumberType, Integer> map = new HashMap<>();
            User c = findContact(name);
            System.out.print("What is the new contact name? -> ");
            String firstName = input.next();

            System.out.print("What is the new contact MOBILE number? -> ");
            int phoneNumber;
            try {
                phoneNumber = input.nextInt();
            } catch (NoSuchElementException e) {
                input = new Scanner(System.in);
                System.out.println("\t !!!Enter only Armenian Phone numbers!!!");
                System.out.print("Like this(98-888-888)! Enter phone number -> ");
                phoneNumber = input.nextInt();
            }

            System.out.print("What is the new contact inbox? -> ");
            String inbox = input.next();


            map.put(NumberType.MOBILE, phoneNumber);

            c.setNumberType(map);
            c.setUserFirstName(firstName);
            c.setInbox(inbox);

            System.out.println("Contact Updated Successfully.");
        }
        else {
            System.out.println("Contact Not Found in the Contact list.");
        }
    }

    /**
     * Contacts list.
     */
    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no contacts\n");
        } else {
            for (User contact : list) {
                System.out.println(contact.toString());
            }
        }
    }
}
