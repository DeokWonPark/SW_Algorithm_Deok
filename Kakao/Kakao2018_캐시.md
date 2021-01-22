문제
-----

+ 2018 KAKAO BLIND 캐시
+ https://programmers.co.kr/learn/courses/30/lessons/17680

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 단어별로 반복한다.
  2. 캐시 배열안에 현재 단어가 존재한다면 해당단어를 우선순위를 올려주고 answer값을 +1
  3. 캐시 배열안에 현재 단어가 존재하지 않는다면 현재 단어를 추가
     - 만약 캐시가 가득 찬 경우 캐시 배열의 우선순위가 가장 낮은 원소를 빼고 새로운 원소를 추가
  
+ 시간복잡도 O(NM) - N- 캐시사이즈, M- 도시의 수

  

+ 코드

  ``` javaScript
  function solution(cacheSize, cities) {
      var answer = 0;
      
      const cache=[];
      for(let i of cities){
          i=i.toUpperCase();
          if(cacheSize==0){
              answer+=5;
              continue;
          }
          if(hit(cache,i)===false){
              if(cache.length>=cacheSize){
                  cache.splice(0,1);
                  cache.push(i);
              }
              else{
                  cache.push(i);
              }
              answer+=5;
          }
          else{
              answer++;
          }
      }
      return answer;
  }
  function hit(cache,city){
      for(let i in cache){
          if(cache[i]===city){
              cache.splice(i,1);
              cache.push(city);
              return true;
          }
      }
      return false;
  }
  ```
  
  