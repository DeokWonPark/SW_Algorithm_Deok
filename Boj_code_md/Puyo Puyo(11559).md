문제
-----

+ Baekjoon OJ 11559 Puyo Puyo
+ https://www.acmicpc.net/problem/11559 

풀이 
------

+ 알고리즘 - DFS, 시뮬레이션

  1. DFS를 통해서 상하좌우로 연결된 넓이가 4이상인 알파벳을 . 으로 바꾼다.
  2. 떨어질 수 있는 알파벳을 떨어트려 배열을 새롭게 만든다.
  3.  1번에서 넓이가 4이상인 알파벳이 없을 때 까지 1, 2를 반복한다.



+ 코드

  ``` java
  import java.io.*;
  public class Main {
  	
  	public static int DFS(char map[][], boolean check[][], int x, int y, int count, char tok, boolean remove) {
  		int go[][] = {{-1,0},{0,-1},{1,0},{0,1}};
  		check[x][y] = true;
  		if(remove) map[x][y] = '.';
  		
  		for(int i=0;i<4;i++) {
  			int n_x,n_y;
  			n_x = x + go[i][0];
  			n_y = y + go[i][1];
  			
  			if(n_x>=0 && n_x<12 && n_y>=0 && n_y<6) {
  				if(check[n_x][n_y] == false && tok == map[n_x][n_y]) {
  					count+=DFS(map,check,n_x,n_y,1,tok,remove);
  				}
  			}
  		}
  		return count;
  	}
  	
  	public static char[][] remove(char map[][]) {
  		
  		char newMap[][] = new char[12][6];
  		
  		for(int i=0;i<6;i++) {
  			newMap[11][i] = map[11][i];
  		}
  		
  		for(int i=10;i>=0;i--) {
  			for(int j=5;j>=0;j--) {
  				if(map[i][j] == '.') {
  					newMap[i][j] = map[i][j];
  					continue;
  				}
  				
  				if(newMap[i+1][j] == '.') {
  					int s=i+1;
  					for(s=i+1;s<12;s++) {
  						if(newMap[s][j] != '.') break;
  					}
  					s--;
  					newMap[s][j] = map[i][j];
  					newMap[i][j] = '.';
  				}
  				else newMap[i][j] = map[i][j];
  			}
  		}
  		
  		return newMap;
  	}
  
  	public static void main(String[] args)throws IOException{
  		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  		
  		char map[][] = new char[12][6];
  		for(int i=0;i<12;i++) {
  			map[i] = bf.readLine().toCharArray();
  		}
  		
  		
  		
  		int count = 0;
  		int result = 0;
  		do {
  			boolean check[][] = new boolean[12][6];
  			count = 0;
  			
  			for(int i=0;i<12;i++) {
  				for(int j=0;j<6;j++) {
  					if(map[i][j] == '.' || check[i][j] == true) continue;
  					
  					int len = DFS(map,check,i,j,1,map[i][j],false);
  					boolean checkR[][] = new boolean[12][6];
  					if(len >= 4) {
  						DFS(map,checkR,i,j,1,map[i][j],true);
  						count++;
  					}
  					
  				}
  			}
  			map = remove(map);
  			
  			result++;
  		}while(count != 0);
  		
  		System.out.print(result-1);
  		
  	}
  }
  
  ```
