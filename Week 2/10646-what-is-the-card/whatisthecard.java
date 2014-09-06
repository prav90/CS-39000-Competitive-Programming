import java.io.*;
import java.util.*;

public class whatisthecard {
    
  public static void main(String [] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer sz;
    int t = Integer.parseInt(br.readLine());
    for(int casen = 1; casen <= t; casen++) {
      String [] arr = new String[53];
      sz = new StringTokenizer(br.readLine());
      for(int i = 1 ; i <= 52; i++) {
        arr[i] = sz.nextToken();
      }
      int y = 0;
      int top = 52-25;
      
      for(int i = 0; i < 3; i++) {
        //System.out.println("Top : " + top + " val :" + arr[top] + "y = " + y);
        String topCard = arr[top];
        int x = 0;
        if(topCard.charAt(0) - '0' >= 2 && topCard.charAt(0) - '0' <= 9) {
          x = topCard.charAt(0) - '0';
        }
        else {
          x = 10;
        }
        y += x;        
        top--;
        x = 10 - x;
        top -= x;
        //System.out.println("Top : " + top + " y = " + y);
      }
      
      y -= top;
      //System.out.println(y);
      if(y == 0) {
        pr.println("Case "+casen+": "+arr[top]);
      }
      else {
        System.out.println("Case "+casen+": "+arr[27+y]);
      }
      
      
    }
    pr.close();
  }
}