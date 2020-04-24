import java.io.*;
import java.util.*;
public class b_2309 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		ArrayList<Integer> ar=new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			ar.add(Integer.parseInt(bf.readLine()));
		}
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				int sum=0;
				for(int s=0;s<9;s++) {
					if(s!=j && s!=i) {
						sum+=ar.get(s);
					}
				}
				if(sum==100) {
					ar.remove(j);
					ar.remove(i);
					Collections.sort(ar);
					for(int k=0;k<ar.size();k++) {
						sb.append(ar.get(k)+"\n");
					}
					System.out.print(sb);
					return;
				}
			}
		}
	}
}
