import java.io.*;
import java.util.*;
public class As31 {
    public static void main(String[] args) {
        String line;
        int lineLength;
        char handle;
        Stack myStack = new Stack();
        try {
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
            line = rd.readLine();
            while( line != null) {
                lineLength = line.length();
                for (int i = 0; i < lineLength; i++) {
                    handle = line.charAt(i);
                    if ( ((handle >= 'A') && (handle <= 'Z')) || ((handle >='a') && (handle <='z')) ) {
                        wr.write(Character.toString(handle));
                    }
                    else if ((handle == '+')||(handle =='-')) {
                        while (!myStack.isEmpty()) {
                            if (myStack.top() == '(') {break;}
                            wr.write(Character.toString(myStack.pop()));
                        }
                        myStack.push(handle);
                    }
                    else if ((handle == '*') || (handle == '/')) {
                        while (!myStack.isEmpty()) {
                            if (myStack.top() == '+' || myStack.top() == '-' || myStack.top() == '(') {break;}
                            wr.write(Character.toString(myStack.pop()));
                        }
                        myStack.push(handle);
                    }
                    else if (handle == '(') {
                        myStack.push('(');
                    }
                    else if (handle == ')') {
                        while(myStack.top() != '(') {
                            wr.write(Character.toString(myStack.pop()));
                        }
                        myStack.pop();
                    }
                    else {}
                }
                while(!myStack.isEmpty()) {
                    wr.write(Character.toString(myStack.pop()));
                }
                wr.newLine();
                line = rd.readLine();
            }
            rd.close();
            wr.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
	}
}
class Node {
    public char data;
    public Node next;
    public Node() {
        data = ' ';
        next = null;
    }
}

class Stack {
    public Node top;
    public Stack() {
        this.top = null;
    }
    public void push(char x) {
        Node newnode = new Node();
        newnode.data = x;
        newnode.next = top;
        top = newnode;
    }
    public char pop() {
        char val = top.data;
        top = top.next;
        return val;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public char top() {
        return top.data;
    }
}