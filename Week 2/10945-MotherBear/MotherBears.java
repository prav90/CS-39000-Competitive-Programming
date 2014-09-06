import java.io.*;
import java.util.*;

public class MotherBears {
  static boolean isSpecial(char i) {
    if( (i >='a' && i <= 'z'))
      return false;
    return true;
  }
  static boolean isPalindrome(String str) {
   int n = str.length();
   int i = 0, j = n-1;
   boolean isPalindrome = true;
   while(i < j) {
     while(i < j && isSpecial(str.charAt(i)) ) {
       i++;
     }
     while(j > i && isSpecial(str.charAt(j)) ) {
       j--;
     }
     //System.out.println("i " + i + " j" + j);
     //System.out.println("Comparing " + str.charAt(i) + " and " + str.charAt(j) );
     
     if(str.charAt(i) != str.charAt(j)) {
       isPalindrome = false;
       break;
     }
     i++;
     j--;
   }
   return isPalindrome;
  }
  public static void main(String [] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer sz;
    while(true) {
      String ip = br.readLine();
      
      if(ip.equals("DONE"))
        break;
      
      ip = ip.toLowerCase();
      if(isPalindrome(ip)) {
        pr.println("You won't be eaten!");
      }
      else {
        pr.println("Uh oh..");
      }
    }
    pr.close();
  }
}