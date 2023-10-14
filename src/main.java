import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Phonebook p=new Phonebook();
        Scanner input=new Scanner(System.in);
        int ans=0;



            while (ans != 8) {
                System.out.println("Welcome to the Linked Tree Phonebook!\n" + "Please choose an option:->");
                System.out.println(
                        "1. Add a contact\n" +
                                "2. Search for a contact\n" +
                                "3. Delete a contact\n" +
                                "4. Schedule an event\n" +
                                "5. Print event details\n" +
                                "6. Print contacts by first name\n" +
                                "7. Print all events alphabetically\n" +
                                "8. Exit");
                try {
                    ans = input.nextInt();
                    input.nextLine();
                }catch (InputMismatchException e)
                {
                    System.out.println("invaild input please enter a proper number");
                    input.nextLine();
                    continue;
                }
                if (ans == 1) {
                    System.out.println("Enter the contact's name:");
                    String cname = input.nextLine();
                    System.out.println("Enter the contact's phone number:");
                    int cnum = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the contact's email address: ");
                    String c_email = input.next();
                    System.out.println("Enter the contact's address:");
                    String c_address = input.nextLine();
                    System.out.println();
                    System.out.println("Enter the contact's birthday: ");
                    String c_bday = input.nextLine();
                    System.out.println();
                    System.out.println("Enter any notes for the contact: ");
                    String notes = input.nextLine();
                    System.out.println();
                    Contact contac = new Contact(cname, c_email, c_address, c_bday, notes, cnum);
                    if (p.contactlist.addContact(contac)) {
                        System.out.println("Contact added successfully");
                    } else {
                        System.out.println("Failed to add the contact Phonebook is full");
                    }

                }

                else if (ans==2)
                {
                    int searchType=0;
                    System.out.println("Enter the search criteria ");
                    System.out.println("1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday");
                    try {


                        searchType = input.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("invaiild input ");
                        input.nextLine();
                        continue;
                    }
                    input.nextLine();
                    if (searchType==1)
                    {
                        System.out.println("Please enter the contact name ->");
                        String name=input.nextLine();
                        Contact c=p.contactlist.searchName(name);

                        if ( c!=null)
                        {
                            //contact info
                            System.out.println(c.toString());
                        }
                        else
                        {
                            System.out.println("Contact not found");
                        }
                    }
                    else if (searchType==2)
                    {
                        System.out.println("please enter phone number -> ");
                        int pnum=input.nextInt();
                        Contact c =p.contactlist.search(pnum);
                        if (c!=null)
                        {
                            System.out.println(c.toString());
                        }
                        else
                        {
                            System.out.println("Contact not found ");
                        }
                    }
                    else if (searchType==3||searchType==4||searchType==5)
                    {
                        System.out.println("Please enter emaill address or bday or address");
                        String target=input.nextLine();
                        LinkedListADT l =p.contactlist.search( target);
                        l.display();
                    }
                }




            }

        System.out.println("Goodbye !");


}}
