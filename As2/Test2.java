package As2;

public class Test2 {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        Node fnode = new Node();
        double time = 0;
        for (int j = 0; j < 50; j++){
            fnode.data = 1;
            fnode.next = null;
            myList.first = fnode;
            for (int i = 0; i < 5000000; i++) {
                myList.insertAtFront(-1);
                myList.insertAtFront(1);
            }
            double beforeTime = System.currentTimeMillis();
            ListSplit mySplit = new ListSplit();
            mySplit.split(myList.first);
            double afterTime = System.currentTimeMillis();
            double secDiffTime = (afterTime - beforeTime)/1000.0;
            System.out.println("time gap : " + secDiffTime);
            time +=secDiffTime;
        }
        System.out.println(time/50.0);
    }

}

class LinkedList {
    Node first;

    LinkedList() {
        first = null;
    }

    public void insertAtFront(int x) {
        Node newnode = new Node();
        newnode.data = x;
        newnode.next = first;
        first = newnode;
    }

    public void DisplayAll() {
        Node cur;

        for (cur = first; cur!=null; cur = cur.next) {
            System.out.println(cur.data);
        }
    }
}