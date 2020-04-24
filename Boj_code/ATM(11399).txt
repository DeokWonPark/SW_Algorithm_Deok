import java.io.*;
import java.util.*;
public class b_11399 {

	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		ArrayList<Integer> ar=new ArrayList<Integer>();
		String arr[]=bf.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			ar.add(Integer.parseInt(arr[i]));
		}
		Collections.sort(ar);
		int sum=ar.get(0);
		int result=ar.get(0);
		for(int i=1;i<N;i++) {
			sum+=ar.get(i);
			result+=sum;
		}
		System.out.print(result);
	}
}
