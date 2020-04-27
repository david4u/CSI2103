package As2;

public class CIter {
    public CNode cur;
    public CNode prev;
    public CList caller;

    public CIter() {
        cur = null;
        prev = null;
        caller = null;
    }

    public boolean isValid() {
        if ( cur == null){
            return false;
        }
        else return true;
    }
    public int getValue() {
        if (!isValid()) return -1;
        else return cur.data;
    }
    public boolean setValue(int x) {
        if (!isValid()) return false;
        else {
            cur.data = x;
            return true;
        }
    }
    public int delete() {
        if (!isValid()) return -1;
        else {
            if (!cur.equals(prev)) { // there are at least two elements
                int tmp = cur.data;
                prev.next = cur.next;
                if (cur.equals(caller.first)) {
                    caller.first = cur.next;
                }
                else if (cur.equals(caller.last)) {
                    caller.last = prev;
                }
                cur.next = null;
                cur = prev.next;
                return tmp;
            } else { // case that cur and prev are same. There are only one elements in the list.
                int tmp = cur.data;
                cur.next = prev.next = null;
                cur = prev = null;
                caller.first = null;
                caller.last = null;
                return tmp;
            }
        }
    }
    public boolean insertAfter(int x) {
        if (!isValid()) return false;
        else {
            CNode newnode = new CNode();
            newnode.data = x;
            newnode.next = cur.next;
            cur.next = newnode;
            if (cur.equals(prev)) { // only one elements before inserting
                prev = newnode;
            }
            if (cur.equals(caller.last)) { // when we insert new data after last element
                caller.last = newnode;
            }
            return true;
        }
    }
    public void next() {
        if (!isValid()) return;
        else {
            cur = cur.next;
            prev = prev.next;
        }
    }
}