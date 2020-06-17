// package As4;

// // skeleton code -- do not modify!
// //
// // CSI 2103-02, Spring 2020
// //
// // PS4

// import java.io.*;

// class As41 {
	
//     public static void  main(String[] args) {
// 		BufferedReader  rd = null;
// 		BufferedWriter  wr = null;
// 		String 			s;
// 		int[]           x, x2, y, y2, c, ans;
// 		int				n, m, i, pos, pos2;
// 		boolean			ret;
// 		long			starttime, elapsedtime;
		
// 		try {
// 			// read in the input
// 			rd = new BufferedReader(new FileReader("input.txt"));
// 			s = rd.readLine();
// 			pos = s.indexOf(" ");
// 			n = Integer.parseInt(s.substring(0, pos));
// 			m = Integer.parseInt(s.substring(pos + 1));
			
// 			x = new int[m];
// 			x2 = new int[m];
// 			y = new int[m];
// 			y2 = new int[m];
// 			c = new int[m];

// 			for (i = 0; i < m; i++) {
// 				s = rd.readLine();
// 				pos = s.indexOf(" ");
// 				x[i] = x2[i] = Integer.parseInt(s.substring(0, pos));				
// 				pos2 = s.substring(pos + 1).indexOf(" ") + pos + 1;
// 				y[i] = y2[i] = Integer.parseInt(s.substring(pos + 1, pos2));
// 				c[i] = Integer.parseInt(s.substring(pos2 + 1));
// 			}
// 			rd.close();
// 			rd = null;
// 			ans = new int[n - 1];

// 			starttime = System.nanoTime();
// 			ret = MST.find(n, m, x, y, c, ans);
// 			elapsedtime = System.nanoTime() - starttime;
// 			System.out.println(Double.toString((double)elapsedtime / 1000000000));

// 			// write the output
// 			wr = new BufferedWriter(new FileWriter("output.txt"));
// 			if (ret) {
// 				wr.write(Integer.toString(n - 1));
// 				wr.newLine();
// 				for (i = 0; i < n - 1; i++) {
// 					wr.write(x2[ans[i]] + " " + y2[ans[i]]);
// 					wr.newLine();
// 				}
// 			} else {
// 				wr.write("-1");
// 				wr.newLine();
// 			}
// 			wr.close();
// 			wr = null;
// 		}
// 		catch (Exception e) {
// 			// if the code throws any exception, stack trace will be output and the program will halt
// 			e.printStackTrace();
// 			System.out.println("Error.");
// 		}
// 		finally {
// 			if (rd != null) {
// 				try {
// 					rd.close();
// 				}
// 				catch (Exception e) {
// 					e.printStackTrace();
// 					System.out.println("Error.");
// 				}
// 			}
// 			if (wr != null) {
// 				try {
// 					wr.close();
// 				}
// 				catch (Exception e) {
// 					e.printStackTrace();
// 					System.out.println("Error.");
// 				}
// 			}
// 		}
// 	}
	
// }
// class MST {

//     public static boolean find(int n, int m, int[] x, int[] y, int[] c, int[] ans) {
//         if (m < n-1)  return false;
//         Node[] edges = new Node[m+1];
//         for (int i = 0; i < edges.length; i++) {
//             edges[i] = new Node();
//         }
//         CNode[] cycleCheck = new CNode[n];
//         for (int i = 0; i < n; i++) {
//             cycleCheck[i] = new CNode(i);
//         }
//         for (int i = 1; i <= m; i++) {
//             edges[i].cost = c[i-1];
//             edges[i].from = x[i-1];
//             edges[i].to = y[i-1];
//             edges[i].numericIndex = i-1;
//         }
//         Heap.sort(edges, m);

//         // now edges are sorted descending order for cost by heap sort.
//         // Do kruskal's Algorithm !
//         int ansindex = 0;
//         boolean[] visitCheck = new boolean[n];
//         for (int i = m; i >= 1; i--) {
//             int fromV, toV;
//             fromV = edges[i].from;
//             toV = edges[i].to;
//             if ((visitCheck[fromV] == false) && visitCheck[toV] == false) {
//                 visitCheck[fromV] = true;
//                 visitCheck[toV] = true;
//                 cycleCheck[toV].underGoTo(cycleCheck[fromV]);
//                 ans[ansindex] = edges[i].numericIndex;
//                 ansindex++;
//             } else {
//                 visitCheck[fromV] = true;
//                 visitCheck[toV] = true;
//                 if (cycleCheck[fromV].topOfVertex == cycleCheck[toV].topOfVertex) {}
//                 else {
//                     if (cycleCheck[cycleCheck[fromV].topOfVertex].number > cycleCheck[cycleCheck[toV].topOfVertex].number) {
//                         cycleCheck[toV].underGoTo(cycleCheck[fromV]);
//                     } else {
//                         cycleCheck[fromV].underGoTo(cycleCheck[toV]);
//                     }
//                     ans[ansindex] = edges[i].numericIndex;
//                     ansindex++;
//                 }
//             }
//             if (ansindex == n-1) {return true;}
//         }
//         // return result.
//         if (ansindex != n-1) {
//             return false; 
//         } else {
//             return true;
//         }
//     }
// }

// // Change (just a little bit) the Code that used at As3. for doing Heap Sort.
// class Heap {
//     public Node[] d;
//     public int dataSize = 0;

//     public Heap(int size) {
//         if (size < 0) return;
//         d = new Node[size+1];
//         for (int i = 1; i < size+1; i++) {
//             d[i] = new Node();
//         }
//     }

//     public boolean isEmpty() {
//         return dataSize == 0;
//     }

//     public Node deleteMin() {
//         if (isEmpty()) return null;

//         Node ret;
//         ret = d[1];
//         if (dataSize == 1) return ret;
//         else {
//             d[1] = d[dataSize];
//             dataSize--;

//             // do heapify **********************************
//             int index = 1;
//             Node tmp;
//             while (2*index <= dataSize) {
//                 if (2*index == d.length - 1) {
//                     if (d[index].cost > d[2*index].cost) {
//                         tmp = d[2*index];
//                         d[2*index] = d[index];
//                         d[index] = tmp;
//                         index = 2*index;
//                     }
//                     else break;
//                 }
//                 else{
//                     if (d[index].cost > d[2*index + 1].cost || d[index].cost > d[2*index].cost) {
//                         if(d[2*index + 1].cost > d[2*index].cost) {
//                             tmp = d[2*index];
//                             d[2*index] = d[index];
//                             d[index] = tmp;
//                             index = 2*index;
//                         }
//                         else {
//                             tmp = d[2*index + 1];
//                             d[2*index + 1] = d[index];
//                             d[index] = tmp;
//                             index = 2*index + 1;
//                         }
//                     }
//                     else break;
//                 }
//             }
//         }
//         return ret;
//     }

//     public static void sort(Node[] a, int n) {
//         // make minimun heap
//         Heap newHeap = new Heap(n);
//         int arrDataSize = n;
//         newHeap.dataSize = arrDataSize;
//         int index;
//         int count = arrDataSize/2;
//         Node tmp;
//         while (count > 0) {
//             index = count;
//             count--;
//             while( 2*index < arrDataSize) {
//                 if (a[index].cost > a[2*index].cost || a[index].cost > a[2*index + 1].cost) {
//                     if (a[2*index].cost < a[2*index + 1].cost) {
//                         tmp = a[2*index];
//                         a[2*index] = a[index];
//                         a[index] = tmp;
//                         index = 2*index;
//                     }
//                     else {
//                         tmp = a[2*index + 1];
//                         a[2*index+1] = a[index];
//                         a[index] = tmp;
//                         index = 2*index + 1;
//                     }
//                 } else break;
//             }
//         }

//         for (int i = 1; i <= n; i++) {
//             newHeap.d[i] = a[i];
//         }
//         // do Heap sort
//         for (int i = n; i > 0; i--) {
//             a[i] = newHeap.deleteMin();
//         }
//     }
// }

// class Node {
//     public int numericIndex;
//     public int from, to;
//     public int cost;
//     public Node() {
//         this.cost = 0;
//         this.from = 0;
//         this.to = 0;
//         this.numericIndex = 0;
//     }
// }

// class CNode {
//     public int topOfVertex;
//     public int number;
//     public CNode(int x) {
//         this.topOfVertex = x;
//         this.number = 1;
//     }
//     public void underGoTo(CNode x) {
//         this.topOfVertex = x.topOfVertex;
//         this.number = -1;
//         x.number += 1;
//     }
// }