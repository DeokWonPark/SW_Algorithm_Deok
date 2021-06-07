문제
-----

+ Baekjoon OJ 16988 Baaaaaaaaaduk2 (Easy)
+ https://www.acmicpc.net/problem/16988

풀이 
------

+ 알고리즘 - 시뮬레이션




+ 코드

  ``` java
  import java.io.*;
  import java.util.LinkedList;
  import java.util.Queue;
  class Bdk{
  	int x;
  	int y;
  	Bdk(int x,int y){
  		this.x=x;
  		this.y=y;
  	}
  }
  public class Main {
  	private static int N,M;
  	private static int map[][];
  	private static int go[][] = {{-1,0},{0,-1},{1,0},{0,1}};
  	private static int max = 0;
  	
  	public static int bfs(Bdk start, boolean check[][]) {
  		int count = 0;
  		int zero = 0;
  		check[start.x][start.y] = true;
  		
  		Queue<Bdk>q = new LinkedList<Bdk>();
  		q.add(start);
  		
  		while(!q.isEmpty()) {
  			Bdk cur = q.poll();
  			count++;
  			
  			if(map[cur.x][cur.y] == 0) zero++;
  			
  			for(int i=0;i<4;i++) {
  				int x,y;
  				x = cur.x + go[i][0];
  				y = cur.y + go[i][1];
  				
  				if(x>=0 && x<N && y>=0 && y<M) {
  					if(map[x][y] != 1 && check[x][y] == false) {
  						q.add(new Bdk(x,y));
  						check[x][y] = true;
  					}
  				}
  			}
  		}
  		
  		if(zero != 0) count = 0;
  		return count;
  	}
  	
  	public static void move(String str) {
  		String seat[] = str.split(" ");
  		
  		int one, two;
  		one = Integer.parseInt(seat[0]);
  		two = Integer.parseInt(seat[1]);
  		
  		int sx,sy,dx,dy;
  		sx = one / M;
  		sy = one % M;
  		dx = two / M;
  		dy = two % M;
  		
  		if(map[sx][sy] != 0 || map[dx][dy] != 0) return;
  		
  		map[sx][sy] = 1;
  		map[dx][dy] = 1;
  		
  		int count = 0;
  		boolean check[][] = new boolean[N][M];
  		for(int i=0;i<N;i++) {
  			for(int j=0;j<M;j++) {
  				if(map[i][j] != 2 || check[i][j] == true) continue;
  				
  				count += bfs(new Bdk(i,j),check);
  			}
  		}
  		
  		max = Math.max(max, count);
  		
  		map[sx][sy] = 0;
  		map[dx][dy] = 0;
  	}
  	
  	public static void search(int MAX, int index, int start, String str) {
  		if(start>=2) {
  			str.substring(0, str.length()-1);
  			move(str);
  			return;
  		}
  		if(MAX <= index) return;
  		
  		search(MAX, index+1, start, str);
  		search(MAX, index+1, start+1, str+index+" ");
  	}
  
  	public static void main(String[] args)throws IOException{
  		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  		
  		String line[] = bf.readLine().split(" ");
  		N = Integer.parseInt(line[0]);
  		M = Integer.parseInt(line[1]);
  		
  		map = new int[N][M];
  		for(int i=0;i<N;i++) {
  			String lines[] = bf.readLine().split(" ");
  			for(int j=0;j<M;j++) {
  				map[i][j] = Integer.parseInt(lines[j]);
  			}
  		}
  		
  		search(N*M,0,0,"");
  		System.out.print(max);
  	}
  }
  
  ```
