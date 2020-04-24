import java.io.*;
public class b_2529 {
	
	static int N;
	static String toks[];
	static boolean check[];
	static int arr[];
	static boolean flag=false;
	static StringBuilder sb=new StringBuilder();
	
	static void TS(int start,int value,boolean flag1,boolean flag2) {
		if(flag1) {
			if(flag2) {
				for(int i=value;i>=0;i--) {
					if(flag) {
						return;
					}
					if(!check[i]) {
						check[i]=true;
						arr[start]=i;
						if(start==N) {
							print();
							flag=true;
							check[i]=false;
							return;
						}
						if(toks[start].equals(">"))
							TS(start+1,i-1,true,true);
						else
							TS(start+1,i+1,true,false);
						check[i]=false;
					}
				}
			}
			else {
				for(int i=value;i<10;i++) {
					if(flag) {
						return;
					}
					if(!check[i]) {
						check[i]=true;
						arr[start]=i;
						if(start==N) {
							print();
							flag=true;
							check[i]=false;
							return;
						}
						if(toks[start].equals(">"))
							TS(start+1,i-1,true,true);
						else
							TS(start+1,i+1,true,false);
						check[i]=false;
					}
				}
			}
		}
		else {
			if(flag2) {
				for(int i=value;i<10;i++) {
					if(flag) {
						return;
					}
					if(!check[i]) {
						check[i]=true;
						arr[start]=i;
						if(start==N) {
							print();
							flag=true;
							check[i]=false;
							return;
						}
						if(toks[start].equals("<"))
							TS(start+1,i+1,false,true);
						else
							TS(start+1,i,false,false);
						check[i]=false;
					}
				}
			}
			else {
				for(int i=0;i<value;i++) {
					if(flag) {
						return;
					}
					if(!check[i]) {
						check[i]=true;
						arr[start]=i;
						if(start==N) {
							print();
							flag=true;
							check[i]=false;
							return;
						}
						if(toks[start].equals("<"))
							TS(start+1,i+1,false,true);
						else
							TS(start+1,i,false,false);
						check[i]=false;
					}
				}
			}
		}
	}
	
	static void print() {
		for(int i=0;i<=N;i++) {
			sb.append(arr[i]);
		}
		sb.append("\n");
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		toks=bf.readLine().split(" ");
		arr=new int[N+1];
		check=new boolean[10];
		TS(0,9,true,true);
		flag=false;
		TS(0,0,false,true);
		System.out.print(sb);
	}
}
