package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook
{
    static List<ContactPerson> contactList = new ArrayList<ContactPerson>();
    static Scanner sc = new Scanner(System.in);
    // method for adding contacts in list.
    public static void addContact()
    {
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
    // main Method
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        int flag = 1;
        while (flag == 1)
        {
            System.out.println(" Choose your choice : 1.Add 2.Exit ");
            int choice = obj.nextInt();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    flag = 0;
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }

        System.out.println(contactList);
    }
}
