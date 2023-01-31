package com.bridgelabz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBook
{
    static List<ContactPerson> contactList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, ArrayList<ContactPerson>> hashmap = new HashMap<>();
    static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        addressBook.createAddressBook();
    }
    // method for adding contacts in list.
    public static void addContact() {
        System.out.println(" Enter your first name : ");
        String firstName = sc.nextLine();
        System.out.println(" Enter your last name : ");
        String lastName = sc.nextLine();
        System.out.println(" Enter your city name : ");
        String city = sc.nextLine();
        System.out.println("Enter your state  : ");
        String state = sc.nextLine();
        System.out.println(" Enter your zip code : ");
        long zip = sc.nextLong();
        System.out.println(" Enter your phone number : ");
        long phoneNumber = sc.nextLong();
        System.out.println(" Enter your email : ");
        String email = sc.nextLine();

        ContactPerson addressBook = new ContactPerson(firstName, lastName, email, city, state, phoneNumber, zip);
        contactList.add(addressBook);
    }
    // method for editing existing contact
    public void editContact() {
        Scanner nameInput = new Scanner(System.in);
        System.out.println(" Enter the first name ");
        String fName = nameInput.nextLine();
        for (int index = 0; index < contactList.size(); index++) {
            if (contactList.get(index).getfirstName().equals(fName)) {
                contactList.remove(index);
                AddressBook addressBook = new AddressBook();
                addressBook.addContact();
            } else {
                System.out.println(" There is no contact ");
            }
        }
    }
    public void deleteContact() {
        Scanner deleteNameInput = new Scanner(System.in);
        String deleteFirstName = deleteNameInput.nextLine();
        for (int increment = 0; increment < contactList.size(); increment++) {
            if (contactList.get(increment).getfirstName().equals(deleteFirstName)) {
                contactList.remove(increment);
            } else {
                System.out.println(" Name does not exist");
            }
        }
    }
    // Method to create the multiple AddressBook
    public void createAddressBook() {
        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println(
                    "1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = sc.nextInt();
            if (choose == 4) {
                System.out.println("Exited");
                break;
            }
            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();
                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }
                    ArrayList<ContactPerson> new_address_book = new ArrayList<>();
                    contactList = new_address_book;
                    while (true) {
                        int choose1;
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                        choose1 = sc.nextInt();
                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1:
                                addressBook.addContact();
                                break;
                            case 2:
                                addressBook.editContact();
                                break;
                            case 3:
                                addressBook.deleteContact();
                                break;
                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(address_name, (ArrayList<ContactPerson>) contactList);
                        System.out.println(hashmap);
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = sc.next();
                    // condition to check whether address book exists or not.
                    if (hashmap.containsKey(address_name_old)) {
                        ArrayList<ContactPerson> old_address_book = new ArrayList<>();
                        contactList = old_address_book;
                        contactList = hashmap.get(address_name_old);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                            int choose2 = sc.nextInt();
                            if (choose2 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose2) {
                                case 1:
                                    addressBook.addContact();
                                    break;
                                case 2:
                                    addressBook.editContact();
                                    break;
                                case 3:
                                    addressBook.deleteContact();
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(address_name_old, (ArrayList<ContactPerson>) contactList);
                            System.out.println(hashmap);
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    System.out.println(hashmap);
                    break;
                default:
                    System.out.println("Enter valid option");

            }
        }
    }

}