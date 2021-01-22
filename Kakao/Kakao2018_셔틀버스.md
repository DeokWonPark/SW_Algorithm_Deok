문제
-----

+ 2018 KAKAO BLIND 셔틀버스
+ https://programmers.co.kr/learn/courses/30/lessons/17678

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 버스 배차시간에 따라 배열을 생성한다.
  2. 배차시간을 차례대로 반복하여 현재의 배차시간보다 작고 이전 배차시간보다 큰 크루를 큐에 넣는다.
  3. 마지막 배차시간 m번째 인원의 -1분이 정답이 된다.
     - 이때 큐가 비어있다면(줄을 선 크루원이 없다면) 해당 배차시간이 정답

  

+ 코드

  ``` java
  import java.util.Collections;
  import java.util.LinkedList;
  class Solution {
      public String solution(int n, int t, int m, String[] timetable) {
          String answer = "09:00";
          LinkedList<Integer>arr=new LinkedList<Integer>();
          LinkedList<Integer>bus=new LinkedList<Integer>();
          
          for(int i=0;i<timetable.length;i++) {
          	String toks[]=timetable[i].split(":");
          	String link=toks[0]+toks[1];
          	arr.add(Integer.parseInt(link));
          }
          
          bus.add(900);
          int value=900;
          int cur=0;
          for(int i=1;i<n;i++) {
          	cur+=t;
          	if(cur>=60) {
          		value+=100;
          		cur%=60;
          		bus.add(value+cur);
          	}
          	else {
          		bus.add(value+cur);
          	}
          }
          
          Collections.sort(arr);
          
          int bus_len=bus.size();
          boolean flag=false;
          
          int time=0;
          for(int i=0;i<bus_len;i++) {
          	time=bus.poll();
          	if(arr.isEmpty()) {
          		flag=true;
          		break;
          	}
          	for(int j=0;j<m;j++) {
          		if(arr.isEmpty()) {
              		flag=true;
              		break;
              	}
          		if(arr.get(0)>time) {
                      flag=true;
          			break;
          		}
          		if(i==bus_len-1 && j==m-1) {
          			int result=arr.poll();
          			int N,M;
                  	N=result/100;
                  	M=(result%100)-1;
                  	if(M<0) {
                  		M=59;
                  		N-=1;
                  	}
                  	if(N<10) {
                  		if(M<10) {
                  			answer="0"+N+":0"+M;
                  		}
                  		else {
                  			answer="0"+N+":"+M;
                  		}
                  	}
           
                  	else {
                  		if(M<10) {
                  			answer=N+":0"+M;
                  		}
                  		else {
                  			answer=N+":"+M;
                  		}
                  	}
                      flag=false;
                  	break;
          		}
          		arr.remove(0);
          	}
          }
          
          if(flag==true) {
          	while(!bus.isEmpty()) {
          		time=bus.poll();
          	}
          	int N,M;
          	N=time/100;
          	M=time%100;
          	if(N<10) {
          		if(M<10) {
          			answer="0"+N+":0"+M;
          		}
          		else {
          			answer="0"+N+":"+M;
          		}
          	}
   
          	else {
          		if(M<10) {
          			answer=N+":0"+M;
          		}
          		else {
          			answer=N+":"+M;
          		}
          	}
          }
          
          
          return answer;
      }
  }
  ```
  
  