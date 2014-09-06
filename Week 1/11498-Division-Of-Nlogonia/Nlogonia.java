import java.util.*;
import java.io.*;

public class Nlogonia {
  public static void main(String [] args)  throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    
    while(true) {
      StringTokenizer sz = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(sz.nextToken());
      if(t == 0) break;
      
      sz = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(sz.nextToken());
      int m = Integer.parseInt(sz.nextToken());
      
      while(t-- > 0) {
        sz = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(sz.nextToken());
        int y = Integer.parseInt(sz.nextToken());
        // on the boundary
        if(x == n || y == m) {
          pw.println("divisa");
        }
        else if( y > m) { // to the north
          if(x > n) { // NE
            pw.println("NE");
          }
          else { // NW
            pw.println("NO");
          }
        }
        else { // south
          if(x > n) {
            pw.println("SE");
          }
          else {
            pw.println("SO");
          }
        }
      }
    }
    pw.close();
  }
}