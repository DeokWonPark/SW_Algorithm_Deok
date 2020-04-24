import java.io.*;
public class b_14391 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String lines[]=bf.readLine().split(" ");
		
		int r=Integer.parseInt(lines[0]);
		int c=Integer.parseInt(lines[1]);
		int toks[]=new int[r*c];
		
		for(int i=0;i<r;i++) {
			String line=bf.readLine();
			for(int j=0;j<c;j++) {
				toks[i*c+j]=line.charAt(j)-48;
			}
		}
		int max=0;
		for(int i=0;i<(1<<(r*c));i++) {
			boolean check[]=new boolean[r*c];
			int sum=0;
			for(int j=0;j<r*c;j++) {
				String ck="";
				if(check[j]==true)
					continue;
				check[j]=true;
				ck+=toks[j];
				if((i & (1<<j))!=0) {
					for(int k=j+c;k<r*c;k+=c) {
						if(check[k]==true)
							break;
						if((i & (1<<k))!=0) {
							ck+=toks[k];
							check[k]=true;
						}
						else
							break;
					}
				}
				else {
					for(int k=j+1;k<((j/c)+1)*c;k++) {
						if(check[k]==true)
							break;
						if((i & (1<<k))==0) {
							ck+=toks[k];
							check[k]=true;
						}
						else
							break;
					}
				}
				sum+=Integer.parseInt(ck);
			}
			if(max<sum)
				max=sum;
		}
		System.out.print(max);
	}
}
