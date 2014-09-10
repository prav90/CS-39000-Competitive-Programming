import java.io.*;
import java.util.*;
/* http://blog.csdn.net/lyy289065406/article/details/6661421 */
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
	  
	  int even = 0;
	  int up = 0;
	  int down = 0;
      for(int j = 0; j < 3; j++) {
		if(result[j].equals("even")) {
			for(int i = 0; i < balance1[j].length(); i++) {
				even |= 1<<(balance1[j].charAt(i) - 'A');
			}
			for(int i = 0; i < balance2[j].length(); i++) {
				even |= 1<<(balance2[j].charAt(i) - 'A');
			}
		}
		else if(result[j].equals("up")) {
			int first = 0;
			for(int i = 0; i < balance1[j].length(); i++) {
				first |= 1<<(balance1[j].charAt(i) - 'A');
			}
			if(down == 0) down = first;
			else down = down & first; // intersection
			int second = 0;
			for(int i = 0; i < balance2[j].length(); i++) {
				second |= 1<<(balance2[j].charAt(i) - 'A');
			}
			if(up == 0) up = second;
			else up = up & second; // intersection
		}
		else {
			int first = 0;
			for(int i = 0; i < balance1[j].length(); i++) {
				first |= 1<<(balance1[j].charAt(i) - 'A');
			}
			if(up == 0) up = first;
			else up = up & first; // intersection
			int second = 0;
			for(int i = 0; i < balance2[j].length(); i++) {
				second |= 1<<(balance2[j].charAt(i) - 'A');
			}
			if(down == 0) down = second;
			else down = down & second; // intersection
		}
      }
	  
	  //System.out.println(Integer.toBinaryString( even ));
	  //System.out.println(Integer.toBinaryString( up ));
	  //System.out.println(Integer.toBinaryString( down ));
	  
	  for(char s = 'A'; s <= 'L'; s++) {
		int shift = s - 'A';
		if((even & (1<<shift)) > 0) { // if a coin is marked as even
			up &= ~(1 << shift); // clear that bit
			down &= ~(1 << shift); // clear that bit
		}
	  }
	  //System.out.println(up);
	  //System.out.println(down);
	  if(up > 0) { // counterfeit coin is light
		for(char s = 'A'; s <= 'L'; s++) {
			int shift = s - 'A';
			if( (up & (1<<shift)) > 0) {
				pr.print(s + " is the counterfiet coin and it is light.");
			}
		}
	  }
	  else if( down > 0){ // counterfeit coin is heavy
		for(char s = 'A'; s <= 'L'; s++) {
			int shift = s - 'A';
			if( (down & (1<<shift)) > 0) {
				pr.print(s + " is the counterfiet coin and it is heavy.");
			}
		}
	  }
	  else { // the unset coin  in even is the counterfeit coin
		for(char s = 'A'; s <= 'L'; s++) {
			int shift = s - 'A';
			if( (even & (1<<shift)) == 0) {
				pr.print(s + " is the counterfiet coin and it is heavy.");
			}
		}
	  }
	  if(casen < t) {
		pr.println();
	  }
    }
    pr.close();
  }
}