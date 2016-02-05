package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Recursion {
	static boolean isTheMazeSolveable() throws IOException {
		char c;
		char[][] maze = new char[10][10];
		BufferedReader bf;
		bf = new BufferedReader(new InputStreamReader(new FileInputStream(
				"C:/text.txt"), Charset.forName("UTF-8")));
		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				c = (char) bf.read();

				maze[i][j] = c;

			}
			bf.read();
			bf.read();
		}
		bf.close();
		int StartX=0, StartY=0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(maze[i][j]=='S'){
					StartX = i;
					StartY= j;
				}
			}
			
		}

		return exploreMaze(maze, StartX, StartY);

	}

	static boolean exploreMaze(char[][] maze, int x, int y) {
	
			
		
		if(x>9 || y>9 || x<0 || y<0){
			return false;
		}
		if(maze[x][y]=='E'){
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(maze[i][j]);
				}
				System.out.println("");
			}
			return true;
		}
		if(maze[x][y]=='*'|| maze[x][y]=='|'){
			return false;
		}
		maze[x][y]='|';
		
		if(exploreMaze(maze, x,y-1))
			return true;
		if(exploreMaze(maze, x,y+1))
			return true;
		if(exploreMaze(maze, x+1,y))
			return true;
		if(exploreMaze(maze, x-1,y-1))
			return true;
		
		return false;
	}

	public static void main(String args[]) throws IOException {

		System.out.println(isTheMazeSolveable());
		
	}

}
