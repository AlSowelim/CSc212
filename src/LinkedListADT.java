
public class LinkedListADT{
     private Nodes<Contact> head=null;
    private int size;

    public LinkedListADT()
    {
        head=null;
        size=0;
    }
    public boolean addContact( Contact c)
    {
        if (head==null)
        {
            head=new Nodes(c);
            size++;
            return true;
        }
        else
        {
            if (search(c)==null)
            {
            Nodes tmp=head;
            while (tmp.next!=null)
                tmp=tmp.next;
            tmp.next=new Nodes(c);
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
                preTarget.next=tmp.next;
            }
        }
    }
    public Contact searchEvent(String contac_or_title)
    {
       Nodes<Contact> tmp=head;
       while (tmp!=null)
       {
           if (tmp.data.getName().equalsIgnoreCase(contac_or_title))
               return tmp.data;
           else if (tmp.data.searchInEvents(contac_or_title)!=null)
           {
               return tmp.data;
           }
           tmp=tmp.next;
       }
       return null;
    }

}

