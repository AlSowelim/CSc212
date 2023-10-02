public class Queue_Linked_List_events {
    private Nodes<Event> head;
    private Nodes<Event> tail;

    private int size;

    public Queue_Linked_List_events() {
        head=null;
        tail=null;
        size=0;
    }


    public Event serve() {
        Nodes<Event>tmp=head;
        head=head.next;
        size--;
        if (size==0)
            tail=null;
        return tmp.data;
    }

    public void enqueue(Event e)
    {
        if (tail==null)
        {
            head=new Nodes<Event>(e);
            tail=head;
        }
        else
        {
            tail.next=new Nodes<Event>(e);
            tail=tail.next;
        }
        size++;

    }


        public void enqueAlalphabetically(Event s)
        {
            for (int i = 0; i < length(); i++)
            {
                Event tmp=serve();
                if (tmp!=null)
                {

                    if (tmp.getTitle().compareTo(s.getTitle()) < 0)
                {
                    enqueue(s);
                }
                enqueue(tmp);
                }

            }
        }

    public int length() {
        return size;
    }


    public boolean full() {
        return false;
    }

}
