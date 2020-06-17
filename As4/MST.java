public class MST {

    public static boolean find(int n, int m, int[] x, int[] y, int[] c, int[] ans) {
        if (m < n-1)  return false;
        Node[] edges = new Node[m+1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Node();
        }
        CNode[] cycleCheck = new CNode[n];
        for (int i = 0; i < n; i++) {
            cycleCheck[i] = new CNode(i);
        }
        for (int i = 1; i <= m; i++) {
            edges[i].cost = c[i-1];
            edges[i].from = x[i-1];
            edges[i].to = y[i-1];
            edges[i].numericIndex = i-1;
        }
        Heap.sort(edges, m);

        // now edges are sorted descending order for cost by heap sort.
        // Do kruskal's Algorithm !
        int ansindex = 0;
        boolean[] visitCheck = new boolean[n];
        for (int i = m; i >= 1; i--) {
            int fromV, toV;
            fromV = edges[i].from;
            toV = edges[i].to;
            if ((visitCheck[fromV] == false) && visitCheck[toV] == false) {
                visitCheck[fromV] = true;
                visitCheck[toV] = true;
                cycleCheck[toV].underGoTo(cycleCheck[fromV]);
                ans[ansindex] = edges[i].numericIndex;
                ansindex++;
            } else {
                visitCheck[fromV] = true;
                visitCheck[toV] = true;
                if (cycleCheck[fromV].topOfVertex == cycleCheck[toV].topOfVertex) {}
                else {
                    if (cycleCheck[cycleCheck[fromV].topOfVertex].number > cycleCheck[cycleCheck[toV].topOfVertex].number) {
                        cycleCheck[toV].underGoTo(cycleCheck[fromV]);
                    } else {
                        cycleCheck[fromV].underGoTo(cycleCheck[toV]);
                    }
                    ans[ansindex] = edges[i].numericIndex;
                    ansindex++;
                }
            }
            if (ansindex == n-1) {return true;}
        }
        // return result.
        if (ansindex != n-1) {
            return false; 
        } else {
            return true;
        }
    }
}
class CNode {
    public int topOfVertex;
    public int number;
    public CNode(int x) {
        this.topOfVertex = x;
        this.number = 1;
    }
    public void underGoTo(CNode x) {
        this.topOfVertex = x.topOfVertex;
        this.number = -1;
        x.number += 1;
    }
}
class Node {
    public int numericIndex;
    public int from, to;
    public int cost;
    public Node() {
        this.cost = 0;
        this.from = 0;
        this.to = 0;
        this.numericIndex = 0;
    }
}


// Change (just a little bit) the Code that used at As3. for doing Heap Sort.
class Heap {
    public Node[] d;
    public int dataSize = 0;

    public Heap(int size) {
        if (size < 0) return;
        d = new Node[size+1];
        for (int i = 1; i < size+1; i++) {
            d[i] = new Node();
        }
    }

    public boolean isEmpty() {
        return dataSize == 0;
    }

    public Node deleteMin() {
        if (isEmpty()) return null;

        Node ret;
        ret = d[1];
        if (dataSize == 1) return ret;
        else {
            d[1] = d[dataSize];
            dataSize--;

            // do heapify **********************************
            int index = 1;
            Node tmp;
            while (2*index <= dataSize) {
                if (2*index == d.length - 1) {
                    if (d[index].cost > d[2*index].cost) {
                        tmp = d[2*index];
                        d[2*index] = d[index];
                        d[index] = tmp;
                        index = 2*index;
                    }
                    else break;
                }
                else{
                    if (d[index].cost > d[2*index + 1].cost || d[index].cost > d[2*index].cost) {
                        if(d[2*index + 1].cost > d[2*index].cost) {
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
        }
        return ret;
    }

    public static void sort(Node[] a, int n) {
        // make minimun heap
        Heap newHeap = new Heap(n);
        int arrDataSize = n;
        newHeap.dataSize = arrDataSize;
        int index;
        int count = arrDataSize/2;
        Node tmp;
        while (count > 0) {
            index = count;
            count--;
            while( 2*index < arrDataSize) {
                if (a[index].cost > a[2*index].cost || a[index].cost > a[2*index + 1].cost) {
                    if (a[2*index].cost < a[2*index + 1].cost) {
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