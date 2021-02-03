문제
-----

+ 2020 KAKAO 인턴십 보석쇼핑
+ https://programmers.co.kr/learn/courses/30/lessons/67258

풀이 
------

+ 알고리즘 - 완전탐색

  1. 진열대에 있는 모든 보석에 대해서 중복이 없는 보석의 종류의 수를 구하기 위해서 집합에 넣어 길이를 얻는다.
  2. 진열대를 순차적으로 반복하며 보석의 이름을 key로하고 빈도수를 value로 하는 map을 만든다.
     - 이때 map의 크기와 보석의 종류의 크기가 같다면 시작 진열대의 번호를 map의 value--가 0이될 때 까지 1씩 늘려가며 진열대 구간의 길이를 최소화한다.
     - vaule가 0이 된다면 기존에 찾은 가장 짧은 길이의 구간과 비교해 현재 찾은 구간의 길이가 짧다면 갱신한다.

  

+ 코드

  ``` javaScript
  function solution(gems) {
      const answer = [];
      let max_len=gems.length;
      const set_len=new Set(gems).size;
      let r_s=0,r_e=0;
  
      let map=new Map();
      let start=0,end=0;
      for(let i=0;i<gems.length;i++){
          if(!map.has(gems[i])){
              map.set(gems[i],1);
          }
          else{
              const vaule=map.get(gems[i]);
              map.set(gems[i],vaule+1);
          }
  
          if(map.size===set_len){
              while(true){
                  const cur=gems[start];
                  let value=map.get(cur);
                  value--;
                  if(value<1){
                      break;
                  }
                  map.set(cur,value);
                  start++;
              }
              if(max_len>end-start){
                  max_len=end-start;
                  r_s=start+1;
                  r_e=end+1;
              }
              map=new Map();
              start++;
              end=start;
              i=start-1;
          }
          else{
              end++;
          }
      }
      answer.push(r_s);
      answer.push(r_e);
      return answer;
  }
  ```
  
  