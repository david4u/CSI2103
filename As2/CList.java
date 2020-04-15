package As2;

public class CList {
    public CNode first, last;
    public CList() {
        first = null;
        last = null;
    }
    public void append(int x) {
        CNode newnode = new CNode();
        newnode.data = x;
        if (first == null) {
            newnode.next = newnode;
            first = newnode;            
            last = newnode;
        } else {
            last.next = newnode;
            last = newnode;
            last.next = first;
        }
    }
    public CIter getIter() {
        CIter myIter = new CIter();
        myIter.cur = first;
        myIter.prev = last;
        (myIter.caller).first = first;
        (myIter.caller).last = last;
        return myIter;
    }
}