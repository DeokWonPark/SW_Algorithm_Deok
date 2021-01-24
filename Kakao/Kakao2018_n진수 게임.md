문제
-----

+ 2018 KAKAO BLIND n진수 게임
+ https://programmers.co.kr/learn/courses/30/lessons/17687

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 0부터 (t*m)까지의 숫자들을 n으로 나눈 나머지를 배열로 구성해서 말해야하는 숫자들이 담긴 배열을 만든다.
  2. 앞에서 만든 말해야 하는 숫자들이 담긴 배열에서 p번째 원소부터 m씩 더해가며 원소를 찾아 하나의 문자열로 구성하여 값을 반환한다.
  
+ 시간복잡도 O(NM) - N- 미리 구할 숫자의 개수 , M- 참가 인원

  

+ 코드

  ``` java
  import java.util.ArrayList;
  import java.util.Stack;
  class Solution {
      public static void create(ArrayList<String>arr,int n,int end) {
  		for(int i=0;i<=end;i++) {
  			int value=i;
  			Stack<Integer>sk=new Stack<Integer>();
  			while(value>=n) {
  				int mod=value%n;
  				if(mod>=10) {
  					sk.push(mod*-1);
  				}
  				else
  					sk.push(mod);
  				value/=n;
  			}
  			if(value>=10) {
  				sk.push(value*-1);
  			}
  			else
  				sk.push(value);
  			
  			while(!sk.isEmpty()) {
  				int num=sk.pop();
  				if(num<0) {
  					switch(num) {
  					case -10:
  						arr.add("A");
  						break;
  						
  					case -11:
  						arr.add("B");
  						break;
  						
  					case -12:
  						arr.add("C");
  						break;
  						
  					case -13:
  						arr.add("D");
  						break;
  						
  					case -14:
  						arr.add("E");
  						break;
  						
  					case -15:
  						arr.add("F");
  						break;
  					}
  				}
  				else
  					arr.add(Integer.toString(num));
  			}
  		}
  	}
  
  	public String solution(int n, int t, int m, int p) {
          String answer = "";
          
          ArrayList<String>arr=new ArrayList<String>();
          create(arr,n,m*t);
          p-=1;
          for(int i=0;i<t;i++) {
          	answer+=arr.get(p);
          	p+=m;
          }
          return answer;
      }
  }
  ```
  
  