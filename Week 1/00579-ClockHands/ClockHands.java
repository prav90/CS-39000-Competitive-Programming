import java.util.*;
import java.io.*;


public class ClockHands {
  public static void main(String [] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    
    
    while(true) {
      StringTokenizer sz = new StringTokenizer(br.readLine(), ":");
      int hour = Integer.parseInt(sz.nextToken());
      int mins = Integer.parseInt(sz.nextToken());
      if(hour == 0 && mins == 0) break;

      double hourangle = hour * 30; // 30 degress per hour
      double minsangle = mins * 6; // 6 degress per minute
      hourangle += ((double) mins/60) * 30; // offset hour
      
      if(Math.abs(hourangle - minsangle) < 180)
        pw.printf("%.3f\n",Math.abs(hourangle - minsangle));
      else
        pw.printf("%.3f\n",360 - Math.abs(hourangle - minsangle));
    }
    
    pw.close();
  }
}