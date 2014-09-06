import java.util.*;
import java.io.*;


public class CostCutting {
  public static void main(String [] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer sz = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(sz.nextToken());
    for(int c = 1; c <= t; c++) {
      sz = new StringTokenizer(br.readLine());
      Integer [] arr = new Integer[3];
      
      for(int i = 0; i < 3;i++)
        arr[i] = Integer.parseInt(sz.nextToken());
      
      // sort
      for(int i = 0; i < 3; i++) {
        for(int j = i+1; j < 3; j++) {
          if(arr[j] < arr[i]) {
            Integer temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
      }
      pw.println("Case " + c + ": "+arr[1]);
    }
    pw.close();
  }
}