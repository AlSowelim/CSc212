public class LinkedListADT{
     private Nodes<Contact> head;
     private Nodes<Contact>tail;
     private Nodes<Contact>current;
     public Queue_Linked_List_events generalList;
    private int size;

    public LinkedListADT()
    {
        head=null;
        tail=null;
        current=null;
        size=0;
        generalList=new Queue_Linked_List_events();
    }
    //adding contact and handling any duplication using search method
    public boolean addContact( Contact c)
    {
        Nodes<Contact>tmp=new Nodes<Contact>(c);
        if (head==null)
        {
            head=tmp;
            tail=head;
            size++;
            current=head;
            return true;
        }
        else
        {
            if (search(c.getPhoneNum())==null)
            {
            tail.next=tmp;
            tmp.pre=tail;
            tail=tail.next;

                size++;
                return true;
            }
            return false;
        }
    }
        public void findFirst()
        {
            current=head;

        }
        public void findnext()
            {
                current=current.next;
            }
            public Contact retrive()
            {
                return current.data;
            }

        //general search by phone number
        public Contact search(int c)
        {
            if (head!=null)
            {
                Nodes <Contact>tmp = head;
                while (tmp != null)
                {
                    if (tmp.data.getPhoneNum() == c)
                        break;
                    tmp=tmp.next;
                }
                return tmp.data;
            }
            return null;
        }
    public Contact searchName(String c)
    {
        if (head!=null)
        {
            Nodes <Contact>tmp = head;
            while (tmp != null)
            {
                if (tmp.data.getName().equalsIgnoreCase(c))
                    break;
                tmp=tmp.next;
            }
            return tmp.data;
        }
        return null;
    }

    public int getSize() {
        return size;
    }
    public boolean empty()
    {
        return head==null;
    }
    public int getEventsSize()
    {
        return generalList.length();
    }

    //search using , email, address, birthday returning a list of answers
    public LinkedListADT search( String email_Or_add_Or_Bday)
    {
        LinkedListADT ans=new LinkedListADT();
        Nodes<Contact> tmp=head;
        while (tmp!=null)
        {
            if (tmp.data.getEmail().equalsIgnoreCase(email_Or_add_Or_Bday)||tmp.data.getBday().equalsIgnoreCase(email_Or_add_Or_Bday)||tmp.data.getAddress().equalsIgnoreCase(email_Or_add_Or_Bday))
                ans.addContact(tmp.data);
            tmp=tmp.next;
        }
        return ans;
    }
    //deleting contact with associated events
    public void deleteContact(Contact c)
    {
        if (head!=null)
        {
            if (head.data.getPhoneNum()==c.getPhoneNum())
            {
                deleteEventWithContact(head.data);
                head=head.next;
                size--;
                if (head!=null)
                {
                    head.pre=null;
                }
            } else if (tail.data.getPhoneNum()==c.getPhoneNum())
            {
                tail=tail.pre;
                tail.next.pre=null;
                tail.next=null;
                size--;

            } else
            {
                Nodes <Contact>tmp = head;

                while (tmp != null)
                {
                    if (tmp.data.getPhoneNum()==(c.getPhoneNum()))
                        break;

                    tmp=tmp.next;
                }
                deleteEventWithContact(tmp.data);
                tmp.pre.next=tmp.next;
                if (tmp.next!=null)
                {
                    tmp.next.pre=tmp.pre;
                }
                size--;
            }
        }
    }
    public Event searchEvent(String contac_or_title)
    {
      int size=generalList.length();
        for (int i = 0; i <size ; i++)
        {
            Event tmp= generalList.serve();
            generalList.enqueue(tmp);
            if (tmp.getTitle().equalsIgnoreCase(contac_or_title)||tmp.getContactInvolved().getName().equalsIgnoreCase(contac_or_title))
            {
                return tmp;
            }
        }
        return null;
    }
    //adding event and checking the contact associated is in the phonebook & conflict in date&Time before adding event
    public boolean addEvent( Event e)
    {
        if ( search(e.getContactInvolved().getPhoneNum())!=null)
        {
        int size=generalList.length();
        for (int i=0 ; i<size;i++)
        {
            Event tmp=generalList.serve();
            if (tmp==null)
                break;
            generalList.enqueAlalphabetically(tmp);
            if (tmp.getDate().equalsIgnoreCase(e.getDate())&&((e.get_StartTime()<tmp.getEnd_Time()&&e.get_StartTime()>tmp.get_StartTime())||(e.getEnd_Time()<tmp.getEnd_Time()&&e.getEnd_Time()>tmp.get_StartTime() )))
            {
                return false;
            }
        }
        generalList.enqueue(e);
        return true;
        }
        return false;
    }
    public boolean deleteEventWithContact(Contact c)
    {
        int size =generalList.length();
        for (int i = 0; i <size ; i++)
        {
            Event tmp=generalList.serve();
            if (tmp==null)
                return false;
            else if (tmp.getContactInvolved().getPhoneNum()==c.getPhoneNum())
            {
                return true;
            }
            generalList.enqueue(tmp);
        }
        return false;
    }
    public void displayAlphabeticallyEvent()
    {
        for (int i = 0; i < generalList.length() ; i++)
        {
           Event e= generalList.serve();
           generalList.enqueue(e);
           System.out.println(e.getTitle());
        }
    }
    public Queue_Linked_List_events copyEvents()
    {
        Queue_Linked_List_events q=new Queue_Linked_List_events();
        for (int i = 0; i < generalList.length(); i++)
        {
            Event e=generalList.serve();
            generalList.enqueue(e);
            q.enqueue(e);
        }
        return q;
    }

    public void display()
    {
        Nodes<Contact>tmp=head;
        while (tmp!=null)
        {
            System.out.println(tmp.data.toString());
            tmp=tmp.next;
        }
    }


}

