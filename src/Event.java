public class Event {

     private String title;
     private String date;
     private String location;
     private Contact contactInvolved;
     private int start_Time , end_Time;
    public Event(String title, String date, String location, Contact contactInvolved, int start_Time,int end_Time) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.start_Time = start_Time;
        this.end_Time=end_Time;
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


    public int getEnd_Time() {
        return end_Time;
    }

    public int get_StartTime() {
        return start_Time;
    }


}
