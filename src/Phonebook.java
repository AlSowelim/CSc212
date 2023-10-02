public class Phonebook {

    LinkedListADT contactlist=new LinkedListADT();

    public void displayContactShareEvent()
    {
        Queue_Linked_List_events shared=new Queue_Linked_List_events();
        Queue_Linked_List_events events=contactlist.copyEvents();
        for (int i = 0; i <events.length() ; i++)
        {
            Event e=events.serve();
            for (int j =0 ; j<events.length();j++)
            {
                Event e2=events.serve();
                events.enqueue(e2);
                if (e.getTitle().equalsIgnoreCase(e2.getTitle()))
                {
                    shared.enqueue(e);
                    shared.enqueue(e2);
                }
            }
        }
        for (int k = 0; k < shared.length() ; k++)
        {
            Event e=shared.serve();
            System.out.println(" for the event :"+e.getTitle()+" in "+e.getDate());
            System.out.println(e.getContactInvolved().getName());
        }
    }
    public void displaySharedfNames()
    {
        Queue_Linkedlist_contacts shared=new Queue_Linkedlist_contacts();
        Queue_Linkedlist_contacts q=new Queue_Linkedlist_contacts();
        contactlist.findFirst();
        //copy contacts to a queue
        for (int i = 0; i < contactlist.getSize(); i++)
        {
            q.enqueue(contactlist.retrive());
            contactlist.findnext();
        }
        for (int j = 0; j <q.getSize() ; j++)
        {
            Contact c= q.serve();
            for (int k = 0; k < q.getSize(); k++)
            {
                Contact c2=q.serve();
                        q.enqueue(c2);
                        if (c.getName().equalsIgnoreCase(c2.getName()))
                        {
                            shared.enqueue(c);
                            shared.enqueue(c2);
                        }
            }
        }
        //now display
        for (int m = 0; m < shared.getSize() ; m++)
        {
            Contact e=shared.serve();
            System.out.println(" Contacts have mutual  name");
            System.out.println(e.getName());
        }



    }
    public static void main(String[] args) {

        System.out.println("Hello world!");

    }
}
