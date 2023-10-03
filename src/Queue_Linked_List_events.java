public class Queue_Linked_List_events extends Queue_Linkedlist<Event> {


    public Queue_Linked_List_events() {
        super();
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


}
