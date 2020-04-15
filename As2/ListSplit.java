package As2;

class Node {
    public int data;
    public Node next;
}
class ListSplit {
    public Node outn, outp, tmp;

    public ListSplit() {
        outn = null;
        outp = null;
    }

    public void split(Node first) {
        while (first != null) {
            if (first.data >= 0) {
                if (outp == null) {
                    outp = first;
                    first = first.next;
                }
                else {
                    tmp = outp;
                    while  (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = first;
                    tmp = null;
                }
            } else {
                if (outn == null) {
                    outn = first;
                    first = first.next;
                }
                else {
                    tmp = outn;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = first;
                    tmp = null;
                }
            }
        }
    }
}