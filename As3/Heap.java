package As3;

public class Heap {
    public int[] d;
    public int dataSize = 0;

    public Heap(int size) {
        if (size < 0) return;
        d = new int[size+1];
        for (int i = 1; i < size+1; i++) {
            d[i] = Integer.MAX_VALUE;
        }
    }

    public boolean isEmpty() {
        return dataSize == 0;
    }

    public boolean isFull() {
        return dataSize == d.length - 1;
    }

    public void insert(int x) {
        if (this.isFull()) {
            int[] a = new int[dataSize*2];
            for (int i = 0; i <= dataSize; i++) {
                a[i] = d[i];
            }
            this.d = new int[dataSize*2];
            for (int i = 0; i <= dataSize; i++) {
                d[i] = a[i];
            }
            for (int i = 1; i < dataSize; i++) {
                d[i+dataSize] = Integer.MAX_VALUE;
            }
        }

        d[++dataSize] = x;

        // do heapify **************************************
        int index = dataSize;
        int tmp;
        while (index > 1) {
            if(d[index/2] > d[index]) {
                tmp = d[index/2];
                d[index/2] = d[index];
                d[index] = tmp;
                index = index/2;
            }
            else break;
        }
    }

    public int deleteMin() {
        if (isEmpty()) return Integer.MAX_VALUE;

        int ret;
        ret = d[1];
        if (dataSize == 1) {d[1] = Integer.MAX_VALUE; dataSize--; return ret;}
        else {
            d[1] = d[dataSize];
            d[dataSize--] = Integer.MAX_VALUE;
            
            // do heapify **********************************
            int index = 1;
            int tmp;
            while (2*index <= dataSize) {
                if (d[index] > d[2*index + 1] || d[index] > d[2*index]) {
                    if(d[2*index + 1] > d[2*index]) {
                        tmp = d[2*index];
                        d[2*index] = d[index];
                        d[index] = tmp;
                        index = 2*index;
                    }
                    else {
                        tmp = d[2*index + 1];
                        d[2*index + 1] = d[index];
                        d[index] = tmp;
                        index = 2*index + 1;
                    }
                }
                else break;
            }
        }
        return ret;
    }

    public int queryMin() {
        if (isEmpty()) return Integer.MAX_VALUE;
        return d[1];
    }
    
    public static void sort(int[] a, int n) {
        // make minimun heap
        Heap newHeap = new Heap(n);
        int arrDataSize = n;
        newHeap.dataSize = arrDataSize;
        int index;
        int count = arrDataSize/2;
        int tmp;
        while (count > 0) {
            index = count;
            count--;
            while( 2*index < arrDataSize) {
                if (a[index] > a[2*index] || a[index] > a[2*index + 1]) {
                    if (a[2*index] < a[2*index + 1]) {
                        tmp = a[2*index];
                        a[2*index] = a[index];
                        a[index] = tmp;
                        index = 2*index;
                    }
                    else {
                        tmp = a[2*index + 1];
                        a[2*index+1] = a[index];
                        a[index] = tmp;
                        index = 2*index + 1;
                    }
                } else break;
            }
        }

        for (int i = 1; i <= n; i++) {
            newHeap.d[i] = a[i];
        }
        // do Heap sort
        for (int i = n; i > 0; i--) {
            a[i] = newHeap.deleteMin();
        }
    }

}