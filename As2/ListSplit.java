package As2;

class Node {
    public int data;
    public Node next;
}

class ListSplit {
    public Node outn, outp;

    public ListSplit() {
        outn = null;
        outp = null;
    }

    public void split(Node first) {
        Node lstp, lstn;
        lstp = null; lstn = null;
        while (first != null) {
            if (first.data > 0) {
                if (outp == null) {
                    outp = first;
                } else {
                    lstp.next = first;
                }
                lstp = first;
            }
            else if (first.data < 0) {
                if (outn == null) {
                    outn = first;
                } else {
                    lstn.next = first;
                }
                lstn = first;
            } else {}
            first = first.next;
        }
        lstp.next = null;
        lstn.next = null;
        lstp = null;
        lstn = null;
    }
}