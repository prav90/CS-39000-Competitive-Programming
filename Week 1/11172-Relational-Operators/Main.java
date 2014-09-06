import java.util.*;
import java.io.*;

public class Main {
  public static void main(String [] args)  throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer sz = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(sz.nextToken());
    while(t-- > 0) {
      sz = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(sz.nextToken());
      int b = Integer.parseInt(sz.nextToken());
      if(a < b) {
        pw.println("<");
      }
      else if(a > b) {
        pw.println(">");
      }
      else {
        pw.println("=");
      }
    }
    pw.close();
  }
}