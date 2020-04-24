import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.TreeSet;

class Start{
	int x;
	int y;
	Start(int x_,int y_){
		this.x=x_;
		this.y=y_;
	}
}
public class test_ {
	

	static int min=1000;
	static int go[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	public static int BFS(Start s,int check[][],int m,int n,int map[][],int l) {
		check[s.x][s.y]=1;
		Deque<Start> q=new ArrayDeque<Start>();
		q.add(s);
		
		while(!q.isEmpty()) {
			Start y=q.poll();
			if(y.x==n-1 && y.y==m-1) {
				return check[y.x][y.x]-1;
			}
			for(int j=0;j<4;j++) {
				int i=(l+j)%4;
				if(y.x+go[i][0]>=0 && y.x+go[i][0]<n && y.y+go[i][1]>=0 && y.y+go[i][1]<m) {
					if(check[y.x+go[i][0]][y.y+go[i][1]]==0) {
						Start y_=new Start(y.x+go[i][0],y.y+go[i][1]);
						if(map[y_.x][y_.y]==0) {
							check[y_.x][y_.y]=check[y.x][y.y]+1;
							q.add(y_);
						}
					}
				}
			}
			
		}
		return -1;
	}
	
	
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int map[][]=new int[n][m];
        int check[][]=new int [n][m];
        
        for(int i=0;i<puddles.length;i++) {
        	int x=puddles[i][0];
        	int y=puddles[i][1];
        	map[x][y]=1;
        }
        Start s=new Start(0,0);
        
        int len;
        for(int i=0;i<4;i++) {
        	for(int w=0;w<n;w++) {
        		for(int b=0;b<m;b++) {
        			check[w][b]=0;
        		}
        	}
        	len=BFS(s,check,m,n,map,i);
        	if(min>=len) {
            	min=len;
            	answer++;
            }
        }
       
        return answer;
    }
	
	public static void main(String[] args) {
	
		
		
	}
}
