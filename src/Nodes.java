public class Nodes<T> {
    T data;
    Nodes<T> next;
    Nodes<T> pre;

    public Nodes(T c)
    {
        data=c;
       pre=next=null;
    }
}
