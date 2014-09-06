import java.util.*;
import java.io.*;


public class Amazing {
  public static void main(String [] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    
    
    while(true) {
      StringTokenizer sz = new StringTokenizer(br.readLine(), ":");
      int a = Integer.parseInt(sz.nextToken());
      int b = Integer.parseInt(sz.nextToken());
      
      if( a == 0 || b == 0) break;
      
      int [][] maze = new int[a][b];
      for(int i = 0; i < a; i++) {
        String ip = br.readLine();
        for(int j = 0; j < b; j++) {
          maze[i][j] = Integer.parseInt( ""+ip.charAt(j));
        }
      }
      for(int i = 0; i < a; i++) {
        for(int j = 0; j < b; j++) {
          System.out.print(maze[i][j]+" ");
        }
        System.out.println();
      }
      System.out.println();
      
    }
    
    pw.close();
  }
}