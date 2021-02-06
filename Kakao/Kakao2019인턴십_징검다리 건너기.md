문제
-----

+ 2019 KAKAO 인턴십 징검다리 건너기
+ https://programmers.co.kr/learn/courses/30/lessons/64062

풀이 
------

+ 알고리즘 - 이분탐색

  디딤돌의 크기를 기준으로 이분탐색을 진행한다.

  1. 디딤돌 배열에서 max값을 구한다.
  2. start=1, end=max로 하여 이분탐색을 진행해서 stone-mid값이 0이하인 부분이 연속적으로 K개가 나타난다면 반환한다.

  

+ 시간복잡도 O(nlogn)



+ 코드

  ``` javaScript
  function solution(stones, k) {
      let answer = 0;
  
      let max=0;
      for(let i of stones){
          if(i>max){
              max=i;
          }
      }
      answer=binarySearch(1,max,k,stones);
      return answer;
  }
  function binarySearch(start,end,k,stones){
      if(start>end){
          return start;
      }
      let mid=Math.floor((start+end)/2);
      let result=check(stones,k,mid);
      if(result){
          return binarySearch(start,mid-1,k,stones);
      }
      else{
          return binarySearch(mid+1,end,k,stones);
      }
  }
  function check(stones,k,mid){
      let count=0;
      for(let i in stones){
          if(stones[i]-mid<=0){
              count++;
          }
          else{
              count=0;
          }
          if(count>=k){
              return true;
          }
      }
      return false;
  }
  ```
  
  