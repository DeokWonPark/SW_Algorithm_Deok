문제
-----

+ Baekjoon OJ 1701 Cubeditor
+ https://www.acmicpc.net/problem/1701

풀이 
------

+ 알고리즘 - 문자열, KMP

  - KMP의 원리인 접두사와 접미사가 동일한 길이인 부분을 활용한다(접두사, 접미사가 동일하기 때문에 문자열에 2번 등장한다.)
  - 접두사 == 접미사의 길이가 최대인 값을 반환



+ 시간복잡도 O(N^2)



+ 코드

  ``` java
  import java.io.*;
  import java.util.ArrayList;
  public class Main {
  
  	private static int len = 0;
  	public static int find(ArrayList<Character> strArr) {
  		int pi[]=new int[strArr.size()];
  		
  		for(int i=1,j=0;i<strArr.size();i++) {
  			if(j>0 && strArr.get(i) != strArr.get(j)) {
  				j=pi[j-1];
  				i--;
  				continue;
  			}
  			if(strArr.get(i) == strArr.get(j)) {
  				len = Math.max(len, ++j);
  				pi[i]=j;
  				continue;
  			}
  		}
  		return len;
  	}
  	public static void main(String[] args)throws IOException{
  		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  		
  		char strArr[]=bf.readLine().toCharArray();
  		ArrayList<Character>str = new ArrayList<Character>();
  		
  		for(int i=0;i<strArr.length;i++) {
  			str.add(strArr[i]);
  		}
  		
  		for(int i=0;i<strArr.length-1;i++) {
  			find(str);
  			str.remove(0);
  		}
  		
  		System.out.print(len);
  	}
  }
  
  ```
