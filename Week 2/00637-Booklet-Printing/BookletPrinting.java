import java.io.*;
import java.util.*;

public class BookletPrinting {
    
  public static void main(String [] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer sz;
    int field = 1;
    while(true) {
      
      int n = Integer.parseInt(br.readLine());      
      if(n == 0) break;
      
      int modPages = n % 4;
      pr.println("Printing order for "+n+" pages:");
      if(n == 1) {
        pr.println("Sheet 1, front: Blank, 1");
      }
      else if(n == 2) {
        pr.println("Sheet 1, front: Blank, 1");
        pr.println("Sheet 1, front: 2, Blank");
      }
      else if(modPages == 3) {
        pr.println("Sheet 1, front: Blank, 1");
        pr.println("Sheet 1, front: 2, 3");
      }
      else {
      }
      
      
    }
    pr.close();
  }
}