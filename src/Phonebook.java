public class Phonebook {

    LinkedListADT contactlist;
    public Phonebook()
    {
        this.contactlist=new LinkedListADT();
    }
    public void displayContactShareEvent()
    {
        //copying events into events queue-list to not cause any problems with the order of the original list
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
        Queue_Linkedlist<Contact> shared=new Queue_Linkedlist<Contact>();
        Queue_Linkedlist<Contact> q=new Queue_Linkedlist<Contact>();
        contactlist.findFirst();
        //copy contacts to a queue
        for (int i = 0; i < contactlist.getSize(); i++)
        {
            q.enqueue(contactlist.retrive());
            contactlist.findnext();
        }
        for (int j = 0; j <q.length() ; j++)
        {
            Contact c= q.serve();
            for (int k = 0; k < q.length(); k++)
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
        for (int m = 0; m < shared.length() ; m++)
        {
            Contact e=shared.serve();
            System.out.println(" Contacts have mutual  name");
            System.out.println(e.getName());
        }



    }

}
