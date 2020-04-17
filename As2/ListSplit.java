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
        Node nlst, plst;
        nlst = null;
        plst = null;
        while (first != null) {
            if (first.data > 0) {
                if (outp == null) {
                    outp = first;
                    plst = outp;
                    first = first.next;
                } else {
                    plst.next = first;
                    plst = first;
                    first = first.next;
                }
            }
            else if (first.data < 0) {
                if (outn == null) {
                    outn = first;
                    nlst = outn;
                    first = first.next;
                } else {
                    nlst.next = first;
                    nlst = first;
                    first = first.next;
                }
            } else{}
        }
    }
}