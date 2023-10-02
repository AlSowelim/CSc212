public class Queue_Linkedlist_contacts {
    private Nodes<Contact> head;
    private Nodes<Contact> tail;

    private int size;

    public Queue_Linkedlist_contacts() {
        head=null;
        tail=null;
        size=0;
    }

    public int getSize() {
        return size;
    }

    public Contact serve() {
        Nodes<Contact>tmp=head;
        head=head.next;
        size--;
        if (size==0)
            tail=null;
        return tmp.data;
    }

    public void enqueue(Contact e)
    {
        if (tail==null)
        {
            head=new Nodes<Contact>(e);
            tail=head;
        }
        else
        {
            tail.next=new Nodes<Contact>(e);
            tail=tail.next;
        }
        size++;

    }
}
