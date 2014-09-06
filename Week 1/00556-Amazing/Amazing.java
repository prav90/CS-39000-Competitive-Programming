import java.io.*;
import java.util.*;
public class Amazing {
  static char getNextDir(char dir) {
    char next = 'r';
    switch(dir) {
      case 'r':
        next = 't'; // turning left from right makes the robot go top
        break;
      case 't':
        next = 'l'; // turn left from a top dir makes the robot point left
        break;
      case 'l':
        next = 'd'; // 90 deg left turn from left points down
        break;
      case 'd':
        next = 'r'; // 90 deg turn from d
    }
    return next;
  }
  static boolean isWallToRight(char dir, int [][] maze, int x, int y, int r, int c) {
    switch(dir) {
      case 'r':
        if(x + 1 == r || maze[x+1][y] == 1)
        return true;
        else 
          return false;
      case 't':
        if(y + 1 == c || maze[x][y+1] == 1)
        return true;
        else 
          return false;
      case 'l':
        if(x  == 0 || maze[x-1][y] == 1)
        return true;
        else 
          return false;
      case 'd':
        if(y == 0 || maze[x][y-1] == 1)
        return true;
        else 
          return false;
    }
// this will never be reached
    return false;
  }
  static boolean canMove(char dir, int [][] maze, int x, int y, int r, int c) {
    switch(dir) {
      case 'r':
        if(y+1 == c || maze[x][y+1] == 1)
        return false;
        else 
          return true;
      case 't':
        if(x == 0 || maze[x-1][y] == 1)
        return false;
        else 
          return true;
      case 'l':
        if(y  == 0 || maze[x][y-1] == 1)
        return false;
        else 
          return true;
      case 'd':
        if(x+1 == r || maze[x+1][y] == 1)
        return false;
        else 
          return true;
    }
// this will never be reached
    return false;
  }
  public static void main(String [] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer sz;
    while(true) {
      sz = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(sz.nextToken());
      int c = Integer.parseInt(sz.nextToken());
      if(r == 0 && c == 0) break;
      int [][] maze = new int[r][c];
      for(int i = 0; i < r; i++) {
        String ip = br.readLine();
        for(int j = 0; j < c; j++) {
          maze[i][j] = Integer.parseInt(""+ip.charAt(j));
        }
      }
      int currX = r-1, currY = 0;
      int [][] visited = new int[r][c];
      char currDirection = 'r'; // move right
      do{ 
//System.out.println("x : " + currX + " y : " + currY );
//System.out.println("is wall? "+ isWallToRight(currDirection, maze, currX, currY, r, c));
//System.out.println("can Move ?" + canMove(currDirection, maze, currX, currY, r, c));
        visited[currX][currY] += 1;
// figure out which direction to move from the current square
// wall should always be on the right of the robot
// if there is no wall to the right
// then move in the direction of the wall side - not a left turn
        if(!isWallToRight(currDirection, maze, currX, currY, r, c)) {
// set direction to the previous wall side
          if(currDirection == 'd') {
            currDirection = 'l';
          }
          else if(currDirection == 't') {
            currDirection = 'r';
          }
          else if(currDirection == 'l') {
            currDirection = 't';
          }
          else if(currDirection == 'r') {
            currDirection = 'd';
          }
        }
        while(!canMove(currDirection, maze, currX, currY, r, c)) {
          currDirection = getNextDir(currDirection);
        }
        if(currDirection == 'r') {
          currY += 1;
        }
        else if(currDirection == 'l') {
          currY -= 1;
        }
        else if(currDirection == 't') {
          currX -= 1;
        }
        else { // direction = down
          currX += 1;
        }
      } while(currX != r-1 || currY != 0);
      int [] visitedCount = new int[5];
      for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
          if(maze[i][j] != 1)
            visitedCount[visited[i][j]]++;
        }
      }
      pr.printf("%3d%3d%3d%3d%3d\n", visitedCount[0],
                visitedCount[1],visitedCount[2],visitedCount[3],visitedCount[4]);
    }
    pr.close();
  }
}