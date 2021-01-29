문제
-----

+ 2019 KAKAO BLIND 후보키
+ https://programmers.co.kr/learn/courses/30/lessons/42890

풀이 
------

+ 알고리즘 - 시뮬레이션

  1. Input의 Column크기 만큼 bit를 구한다 ex) 0000 ~ 1111(4자리Column)
  2. 현재 확인하려는 비트가 이미 이전에 구해진 후보키들과 bit OR연산을 수행했을 때 자기자신이 나오지 않는다면 유일성 조건을 만족
  3. 현재 확인하려는 비트의 1인 요소들에 해당하는 Input요소들을 set에 넣어 중복된 원소의 판단을 통해서 최소성을 판단
  
  
  
+ 시간복잡도 O(MN) row*column

  

+ 코드

  ``` javaScript
  const sk=[];
  const check=[];
  function solution(relation) {
      let answer = 0;
  
      makeString(relation[0].length,"");
  
      for(let i=1;i<sk.length;i++){
          let value=small(sk[i],relation);
          if(value===true){
              answer++;
          }
      }
      return answer;
  }
  function check_small(str){
     let num=makingBit(str);
     for(let i in check){
         let result=check[i] | num;
         if(result===num){
             return false;
         }
         if(result===check[i]){
             check.splice(i,1,num);
             return false;
         }
     }
     return true;
  }
  function small(str,relation){
  
      if(!check_small(str)){
          return;
      }
      const set=new Set();
      for(let j in relation){
           let line=""; 
           for(let i=0;i<str.length;i++){
              if(str[i]==="0"){
                  continue;
              }
              line+=("."+relation[j][i]);
          }
          if(set.has(line)){
              return false;
          }  
          set.add(line);
      }
      check.push(makingBit(str));
      return true;
  }
  function makingBit(str){
      let n=1;
      let result=0
      for(let i=str.length-1;i>=0;i--){
          result+=(str[i]*n);
          n*=2;
      }
      return result;
  }
  function makeString(len,str){
      if(str.length>=len){
          sk.push(str);
          return;
      }
      else{
          makeString(len,str+"0");
          makeString(len,str+"1");
      }
  }
  ```
  
  