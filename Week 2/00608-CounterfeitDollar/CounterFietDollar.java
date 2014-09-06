import java.io.*;
import java.util.*;

public class CounterFietDollar {
    
  public static void main(String [] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer sz;
    int t = Integer.parseInt(br.readLine());
    for(int casen = 1; casen <= t; casen++) {

      String [] balance1 = new String[3];
      String [] balance2 = new String[3];
      String [] result = new String[3];
      for(int i = 0; i < 3; i++) {
        sz = new StringTokenizer(br.readLine());
        balance1[i] = sz.nextToken();
        balance2[i] = sz.nextToken();
        result[i] = sz.nextToken();
      }
      boolean [] original = new boolean[12];
      boolean [] up = new boolean[12];
      boolean [] down = new boolean[12];
      for(int i = 0; i < 3; i++) {
        if(result[i].equals("even")) {
          for(int j = 0; j < balance1[i].length(); j++) {
            oiginal[balance1[i].charAt(j)] = true;
          }
          for(int j = 0; j < balance2[i].length(); j++) {
            oiginal[balance2[i].charAt(j)] = true;
          }
        }
        else if(result[i].equals("up")) {
          boolean [] firstMatch = new boolean[12];
          for(int j = 0; j < balance1[i].length(); j++) {
            firstMatch[balance1[i].charAt(j)] = true;
          }
          boolean [] secondMatch = new boolean[12];
          for(int j = 0; j < balance2[i].length(); j++) {
            secondMatch[balance2[i].charAt(j)] = true;
          }
          for(int j = 0; j < 12; j++) {
            if(firstMatch[i] && secondMatch[i]) {
              up[i] = true;
            }
          }
        }
        else {
          boolean [] firstMatch = new boolean[12];
          for(int j = 0; j < balance1[i].length(); j++) {
            firstMatch[balance1[i].charAt(j)] = true;
          }
          boolean [] secondMatch = new boolean[12];
          for(int j = 0; j < balance2[i].length(); j++) {
            secondMatch[balance2[i].charAt(j)] = true;
          }
          for(int j = 0; j < 12; j++) {
            if(firstMatch[i] && secondMatch[i]) {
              down[i] = true;
            }
          }
        }
        
        int candidate = -1;
        for(int i = 0; i < 12; i++) {
          if(
        }
        
      }
    }
    pr.close();
  }
}