package As1;

import java.io.*;
import java.util.*;

public class As11 {
    public static void main(String[] args) {
        int cheapestPrice, tmp, length;
        String cheapestOne, line;
        //Open files to read and write
        try{
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));

            //Attempt times
            line = rd.readLine();
            length = Integer.parseInt(line);

            //Attemt
            if (length != 0) {
                line = rd.readLine();
                StringTokenizer st = new StringTokenizer(line);
                cheapestPrice = Integer.parseInt(st.nextToken());
                
                //Get item's name including space
                cheapestOne = st.nextToken();
                while (st.hasMoreTokens()) {
                    cheapestOne += " ";
                    cheapestOne += st.nextToken();
                }
                
                //Find the cheapest one
                for (int i = 0; i < length-1; i++) {
                    line = rd.readLine();
                    StringTokenizer st2 = new StringTokenizer(line);
                    tmp = Integer.parseInt(st2.nextToken());
                    if (tmp < cheapestPrice) {
                        cheapestPrice = tmp;
                        cheapestOne = st2.nextToken();
                        while(st2.hasMoreTokens()){
                            cheapestOne += " ";
                            cheapestOne += st2.nextToken();
                        }
                    }
                }
                //write result
                wr.write(cheapestOne);
            }

            //close the file
            rd.close();
            wr.close();
        }

        //exception
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}