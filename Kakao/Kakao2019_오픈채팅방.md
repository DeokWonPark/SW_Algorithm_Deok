문제
-----

+ 2019 KAKAO BLIND 오픈채팅방
+ https://programmers.co.kr/learn/courses/30/lessons/42888

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 모든 Input에 대해서 뒤에서부터 반복하여 id 값이 중복되지 않는 조건을 충족시키면 Id를 Key, name를 Value로 하는 Map을 생성한다.
     - 이렇게 하면 제일 마지막에 수정된 id에 해당하는 name을 가지게 된다.
  2. 다시 모든 Input요소를 앞에서 반복하여 Key값인 Id로  Map에 접근하여 name을 가져와서 출력 형식에 맞게 출력한다.
  
+ 시간복잡도 O(N)

  

+ 코드

  ``` javaScript
  function solution(record) {
      const answer = [];
  
      const id_name=new Map();
      for(let i=record.length-1;i>=0;i--){
          let cur=record[i].split(" ");
          if(cur[0]==="Leave"){
              continue;
          }
          if(!id_name.has(cur[1])){
              id_name.set(cur[1],cur[2]);
          }
      }
  
      for(let i in record){
          let cur=record[i].split(" ");
          if(cur[0]==="Change"){
              continue;
          }
          let cur_name=id_name.get(cur[1]);
  
          if(cur[0]==="Enter"){
              answer.push(`${cur_name}님이 들어왔습니다.`);
          }
          else if(cur[0]==="Leave"){
              answer.push(`${cur_name}님이 나갔습니다.`);
          }
      }
      return answer;
  }
  ```
  
  