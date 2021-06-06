문제
-----

+ Baekjoon OJ 16985 Maaaaaaaaaze
+ https://www.acmicpc.net/problem/16985

풀이 
------

+ 알고리즘 - 시뮬레이션




+ 코드

  ``` java
  import java.io.*;
  import java.util.LinkedList;
  import java.util.Queue;
  class MAZ{
  	int x;
  	int y;
  	int z;
  	int dist;
  	MAZ(int x, int y, int z, int dist){
  		this.x=x;
  		this.y=y;
  		this.z=z;
  		this.dist = dist;
  	}
  }
  public class Main {
  	private static int map[][][] = new int[5][5][5];
  	private static int go[][] = {{-1,0,0},{1,0,0},{0,-1,0},{0,0,-1},{0,1,0},{0,0,1}};
  	private static int min = Integer.MAX_VALUE;
  	
  	public static void spin(int f, int map[][][]) {
  		int newMap[][] = new int[5][5];
  		
  		for(int i=0;i<5;i++) {
  			for(int j=0;j<5;j++) {
  				newMap[j][4-i] = map[f][i][j];
  			}
  		}
  		map[f] = newMap;
  	}
  	
  	public static void bfs(MAZ start, MAZ end, boolean check[][][], int newMap[][][]) {
  		check[start.z][start.x][start.y] = true;
  		
  		Queue<MAZ>q = new LinkedList<MAZ>();
  		q.add(start);
  		
  		while(!q.isEmpty()) {
  			MAZ cur = q.poll();
  			
  			if(cur.z == end.z && cur.x == end.x && cur.y == end.y) {
  				min = Math.min(min, cur.dist);
  				break;
  			}
  			
  			for(int i=0;i<6;i++) {
  				int x,y,z;
  				z = cur.z + go[i][0];
  				x = cur.x + go[i][1];
  				y = cur.y + go[i][2];
  				
  				if(z>=0 && z<5 && x>=0 && x<5 && y>=0 && y<5) {
  					if(check[z][x][y] == false && newMap[z][x][y] == 1) {
  						check[z][x][y] = true;
  						q.add(new MAZ(x,y,z,cur.dist+1));
  					}
  				}
  			}
  		}
  	}
  	
  	public static void move(int sx,int sy, int dx, int dy, int newMap[][][]) {
  		for(int i=0;i<4;i++) {
  			spin(0,newMap);
  			if(newMap[0][sx][sy] == 0) continue;
  			for(int j=0;j<4;j++) {
  				spin(1,newMap);
  				for(int a=0;a<4;a++) {
  					spin(2,newMap);
  					for(int b=0;b<4;b++) {
  						spin(3,newMap);
  						for(int c=0;c<4;c++) {
  							spin(4,newMap);
  							if(newMap[4][dx][dy] == 0) continue;
  							
  							boolean check[][][] = new boolean[5][5][5];
  							bfs(new MAZ(sx,sy,0,0), new MAZ(dx,dy,4,0),check,newMap);
  						}
  					}
  				}
  			}
  		}
  	}
  	public static void make(String str) {
  		int newMap[][][] = new int[5][5][5];
  		
  		for(int i=0;i<5;i++) {
  			int cur = str.charAt(i) - '0';
  			newMap[i] = map[cur];
  		}
  		
  		move(0,0,4,4,newMap);
  		move(0,4,4,0,newMap);
  		move(4,0,0,4,newMap);
  		move(4,4,0,0,newMap);
  		
  	}
  	
  	public static void search(int start, int mask, String str) {
  		if(start >= 5) {
  			make(str);
  			return;
  		}
  		
  		for(int i=0;i<5;i++) {
  			if((mask & (1 << i)) != 0) continue;
  			
  			search(start+1, (mask | (1 << i)), str+i);
  		}
  	}
  
  	public static void main(String[] args)throws IOException{
  		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  		
  		for(int i=0;i<5;i++) {
  			for(int j=0;j<5;j++) {
  				String line[] = bf.readLine().split(" ");
  				for(int k=0;k<5;k++) {
  					map[i][j][k] = Integer.parseInt(line[k]);
  				}
  			}
  		}
  		
  		search(0,0,"");
  		
  		if(min == Integer.MAX_VALUE) min = -1;
  		System.out.print(min);
  	}
  }
  
  ```
