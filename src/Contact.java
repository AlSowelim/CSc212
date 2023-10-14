public class Contact implements Comparable<Contact> {
    private String name ,  email , address, bday ,notes;
    private int phoneNum;

    @Override
    public String toString() {
        return "Contact{}";
    }

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
       String first= this.name;
       String second =o.name;
       int ans, lessLength=Math.min(first.length(),second.length());
       for (int i=0 ; i<lessLength;i++)
       {
           ans=first.charAt(i)-second.charAt(i);
           if (ans>0)
           {
               return 1;
           }
           else if (ans<0)
           {
               return -1;
           }
       }
       if (first.length()>second.length())
           return 1;
       else if (first.length()<second.length())
           return -1;
       return 0;
    }
}
