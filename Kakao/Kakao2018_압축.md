문제
-----

+ 2018 KAKAO BLIND 압축
+ https://programmers.co.kr/learn/courses/30/lessons/17684

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. msg의 현재 단어와 다음단어를 msg i번째 인덱스, i+1번째 인덱스로 각각 구한다.

  2. 현재단어+다음단어가 현재 사전에 등록되어 있다면 사전에 존재하지 않을때 까지

     현재단어=현재단어+다음단어로 초기화시킨다. 

  3. 최종적인 현재단어와 다음단어를 구하면 사전에서 현재단어의 Index를 출력

  4. 사전에 새로운 원소로 현재단어와 다음단어를 추가시킨다.

  

+ 코드

  ``` javaScript
  function solution(msg) {
      var answer = [];
  
      const word=[null];
      let w=65;
      for(let i=1;i<=26;i++){
          word.push(String.fromCharCode(w));
          w++;
      }
  
      for(let i=0;i<msg.length;i++){
          let cur=msg[i];
          let next=msg[i+1];
          while(word.includes(cur+next)){
              cur=cur+next;
              i++;
              next=msg[i+1];
          }
          answer.push(word.indexOf(cur));
          word.push(cur+next);
      }
      return answer;
  }
  ```
  
  