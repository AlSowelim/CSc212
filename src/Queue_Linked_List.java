public class Queue_Linked_List<T>{
    private Nodes<T> head;
    private Nodes<T> tail;

    private int size;

    public Queue_Linked_List() {
        head=null;
        tail=null;
        size=0;
    }


    public T serve() {
        Nodes<T>tmp=head;
        head=head.next;
        size--;
        if (size==0)
            tail=null;
        return tmp.data;
    }

    public void enqueue(T e)
    {
        if (tail==null)
        {
            head=new Nodes<T>(e);
            tail=head;
        }
        else
        {
            tail.next=new Nodes<T>(e);
            tail=tail.next;
        }
        size++;

    }


    public int length() {
        return size;
    }


    public boolean full() {
        return false;
    }

}
