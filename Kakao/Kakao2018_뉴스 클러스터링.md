문제
-----

+ 2018 KAKAO BLIND 뉴스 클러스터링
+ https://programmers.co.kr/learn/courses/30/lessons/17677

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. 두 문자열에 대해서 2문자씩 대문자로 변환하여 쌍의 집합을 구성한다.
  2. 각각의 교집합, 합집합의 개수를 구한다.
  3. 구해진 교집합, 합집합을 가지고 자카드 유사도를 구해서 *65536을 곱해 소수점을 버리고 정수 값을 반환한다.
  
+ 시간복잡도 O(NM) - 두 문자열의 길이

  

+ 코드

  ``` javaScript
  function solution(str1, str2) {
      var answer = 0;
      str1=str1.toUpperCase();
      str2=str2.toUpperCase();
  
      let A=[];
      let B=[];
  
      A=makeSet(str1);
      B=makeSet(str2);
  
      let G=GS(A,B);
      let S=SS(A,B);
  
      if(G===0 && S===0){
          return 65536;
      }
      
      answer=Math.floor(G/S*65536);
  
      return answer;
  }
  function GS(A,B){
      let result=0;
  
      let temp_A=[...A];
      let temp_B=[...B];
  
      while(temp_A.length!==0){
          if(temp_B.length===0){
              break;
          }
          let idx=temp_B.indexOf(temp_A[0]);
          if(idx===-1){
              temp_A.splice(0,1);
          }
          else{
              result++;
              temp_A.splice(0,1);
              temp_B.splice(idx,1);
          }
      }
      return result;
  }
  
  function SS(A,B){
      let result=0;
  
      let temp_A=[...A];
      let temp_B=[...B];
  
      while(temp_A.length!==0){
          if(temp_B.length===0){
              return result+temp_A.length;;
          }
          let idx=temp_B.indexOf(temp_A[0]);
          if(idx===-1){
              result++;
              temp_A.splice(0,1);
          }
          else{
              result++;
              temp_A.splice(0,1);
              temp_B.splice(idx,1);
          }
      }
      return result+temp_B.length;
  }
  
  function makeSet(str){
      const result=[];
      for(let i=0;i<str.length-1;i++){
          let code1=str.charCodeAt(i);
          let code2=str.charCodeAt(i+1);
          if(code1<65 || code1>90 || code2<65 || code2>90){
              continue;
          }
  
          let tok=str[i]+str[i+1];
          result.push(tok);
      }
      return result;
  }
  ```

  