public class Contact implements Comparable<Contact> {
    private String name ,  email , address, bday ,notes;
    private int phoneNum;
    //public Queue_Linked_List<Event> eventsForContact;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBday() {
        return bday;
    }

    public String getNotes() {
        return notes;
    }

    public int getPhoneNum() {
        return phoneNum;
    }


    public Contact(String name, String email, String address, String bday, String notes, int phoneNum)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.bday = bday;
        this.notes = notes;
        this.phoneNum = phoneNum;
        //this.eventsForContact =new Queue_Linked_List<Event>();
    }

    @Override
    public int compareTo(Contact o) {
       return this.name.compareTo(o.name);
    }
    /*public void addEventForContact(Event e)
    {
        eventsForContact.enqueue(e);
    }*/
    /*
    public Event searchInEvents(String  c)
    {
        int size= eventsForContact.length();
        for (int i = 0; i < size; i++)
        {
            Event e= eventsForContact.serve();
            eventsForContact.enqueue(e);
            if (e.getTitle().equalsIgnoreCase(c))
                return e;
        }

        return null;
    }
    public void deleteEventForContact(Event e)
    {
        int size= eventsForContact.length();
        for (int i = 0; i < size; i++) {
            Event tmp= eventsForContact.serve();
            if (tmp.getTitle().equalsIgnoreCase(e.getTitle()))
                break;
            eventsForContact.enqueue(tmp);
        }
    }
    */
}
