public class Event {

     private String title;
     private String date;
     private String location;
     private Contact contactInvolved;
     private int time;
    public Event(String title, String date, String location, Contact contactInvolved, int time) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.time = time;
        this.contactInvolved=contactInvolved;
    }


    public Contact getContactInvolved() {
        return contactInvolved;
    }




    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }


    public int getTime() {
        return time;
    }


}
