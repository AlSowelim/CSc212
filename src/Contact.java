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
    }

    @Override
    public int compareTo(Contact o) {
       return this.name.compareTo(o.name);
    }
}
