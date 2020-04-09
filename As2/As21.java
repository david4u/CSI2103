package As2;

class CNode {
    public int data;
    public CNode next;
}

class CList {
    public CNode first;
    public CList() {

    }
    public void append(int x) {

    }
    public CIter getIter() {
        return new CIter();
    }
}

class CIter {
    public CNode cur;
    public CNode prev;
    public boolean isValid() {
        return true;
    }
    public int delete() {
        return 0;
    }
    public boolean insertAfter(int x) {
        return true;
    }
    public void next() {

    }
    


}