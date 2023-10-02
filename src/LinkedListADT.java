
public class LinkedListADT{
     private Nodes<Contact> head;
     private Nodes<Contact>tail;
     private Queue_Linked_List<Event>generalList;
    private int size;

    public LinkedListADT()
    {
        head=null;
        tail=null;
        size=0;
        generalList=new Queue_Linked_List<Event>();
    }
    public boolean addContact( Contact c)
    {
        if (head==null)
        {
            head=new Nodes<>(c);
            tail=head;
            size++;
            return true;
        }
        else
        {
            if (search(c)==null)
            {
            tail.next=new Nodes<>(c);
            tail=tail.next;
                size++;
                return true;
            }
            return false;
        }
    }

        //general search
        public Contact search(Contact c)
        {
            if (head!=null)
            {
                Nodes <Contact>tmp = head;
                while (tmp != null)
                {
                    if (tmp.data.getPhoneNum() == c.getPhoneNum())
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

    public void deleteContact(Contact c)
    {
        if (head!=null)
        {
            if (head.data.getPhoneNum()==c.getPhoneNum())
            {
                deleteEventWithContact(head.data);
                head=head.next;
            }
            else
            {
                Nodes <Contact>tmp = head;
                Nodes <Contact> preTarget=null;
                while (tmp != null)
                {
                    preTarget=tmp;
                    if (tmp.data.getPhoneNum()==(c.getPhoneNum()))
                        break;

                    tmp=tmp.next;
                }
                deleteEventWithContact(tmp.data);
                preTarget.next=tmp.next;
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
    public boolean addEvent( Event e)
    {
        int size=generalList.length();
        for (int i=0 ; i<size;i++)
        {
            Event tmp=generalList.serve();
            if (tmp==null)
                break;
            generalList.enqueue(tmp);
            if (tmp.getDate().equalsIgnoreCase(e.getDate()))
            {
                return false;
            }
        }
        generalList.enqueue(e);
        return true;
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
}

