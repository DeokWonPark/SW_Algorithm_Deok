import java.io.*;
public class b_1476 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int e=15,s=28,m=19;
		String arr[]=bf.readLine().split(" ");
		int i=1;
		int E=Integer.parseInt(arr[0]);
		int S=Integer.parseInt(arr[1]);
		int M=Integer.parseInt(arr[2]);
		if(E==15)
			E=0;
		if(S==28)
			S=0;
		if(M==19)
			M=0;
		while(true) {
			if((i%e==E) && (i%s==S) && (i%m==M)) {
				System.out.print(i);
				return;
			}
			i++;
		}
	}
}
