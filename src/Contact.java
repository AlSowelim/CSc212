public class Contact implements Comparable<Contact> {
    String name ,  email , address, bday ,notes;
    int phoneNum;

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
        if (this.name.compareTo(o.name)>0)
        {
            return 1;
        }
        else if (this.name.compareTo(o.name)<0){
            return -1;
        }
        return 0;
    }
}
