문제
-----

+ 2018 KAKAO BLIND 추석 트래픽
+ https://programmers.co.kr/learn/courses/30/lessons/17676

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 입력으로 들어오는 작업의 끝나는 시간을 초단위의 실수형태 값으로 변환한다.
  2. 실수형태의 끝나는 시간에 처리시간T를 빼고 0.001을 더해서 작업의 시작시간을 구한다.
  3. 모든 끝나는 시간에 대해서 끝나는 시간 ~ 끝나는 시간+1범위 내에 처리중인 작업이 있는지 검사한다.
     
     - 작업이 진행중인 조건
     - 1. 작업의 시작시간이 검사하는 범위내에 존재하는 경우
     - 2. 끝나는 시간이  검사하는 범위내에 존재하는 경우
     - 3. 작업의 시작시간이 검사하는 범위 이전에 있고, 끝나는 시간이 검사범위 밖에 존재하는 경우
     
     4.모든 작업 검사에 대한 max값 반환
  
+ 시간복잡도 O(N^2)  N-입력의 크기

+ 코드

  ``` javaScript
  class time{
      constructor(start,end){
          this.start=start;
          this.end=end;
      }
  }
  function solution(lines) {
      const time_arr=[];
      const end_arr=[]
  
      for(let i in lines){
          const cur_line=lines[i].split(" ");
          let sec=cur_line[2].substring(0,cur_line[2].length-1);
          let end=Number.parseFloat(trans_time(cur_line[1]));
          end_arr.push(end);
          let start=end-sec+0.001;
          start=Math.round(start*1000)/1000;
          let item=new time(start,end);
          time_arr.push(item);
      }
  
      let max=0;
      for(let i in end_arr){
          let tok=end_arr[i];
          let count=0;
          for(let j of time_arr){
              let flag=false;
              if(tok<=j.start && tok+1>j.start){
                  count++;
                  flag=true;
              }
              if(tok<=j.end && tok+1>j.end){
                  if(!flag){
                      flag=true;
                      count++;
                  }
              }
              if(j.start<=tok && j.end>tok+1){
                  if(!flag){
                      flag=true;
                      count++;
                  }
              }
          }
          if(max<count){
              max=count;
          }
      }
  
      return max;
  }
  function trans_time(time){
      const tok=time.split(":");
      let result=0;
      result+=(Number.parseInt(tok[0])*3600);
      result+=(Number.parseInt(tok[1])*60);
      result+=(Number.parseFloat(tok[2]));
      return result;
  }
  ```
  
  