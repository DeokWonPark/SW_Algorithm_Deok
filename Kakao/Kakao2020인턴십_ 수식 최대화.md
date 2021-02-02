문제
-----

+ 2019 KAKAO BLIND 수식 최대화
+ https://programmers.co.kr/learn/courses/30/lessons/67257

풀이 
------

+ 알고리즘 - 완전탐색

  1. +,  - , *로 조합가능한 모든 우선순위의 경우에 대해서 모두 계산해보고 절대값이 가장 큰 수를 반환한다.

  

+ 코드

  ``` javaScript
  function solution(expression) {
      let answer = 0;
      const oper=[["*","+","-"],
      ["*","-","+"],
      ["+","*","-"],
      ["+","-","*"],
      ["-","*","+"],
      ["-","+","*"],
  ];
      const arr=[];
      let num="";
      for(let i in expression){
          if(expression[i]==="-" || expression[i]==="+" || expression[i]==="*"){
              arr.push(num);
              arr.push(expression[i]);
              num="";
              continue;
          }
          num+=expression[i];
      }
      arr.push(num);
  
      for(let i in oper){
          const temp=[...arr];
          const cur=oper[i];
          for(let j in cur){
              for(let s=0;s<temp.length;s++){
                  if(cur[j]===temp[s]){
                      let x,y,op;
                      x=temp.splice(s-1,1);
                      op=temp.splice(s-1,1);
                      y=temp.splice(s-1,1);
                      let ret=operator(Number.parseInt(x[0]),Number.parseInt(y[0]),op[0]);
                      temp.splice(s-1,0,ret);
                      s-=2;
                  }
              }
          }
          const result=Math.abs(Number.parseInt(temp[0]));
          if(answer<result){
              answer=result;
          }
      }
      return answer;
  }
  
  function operator(x,y,op){
      switch(op){
          case '+':
              return x+y;
           case '-':
               return x-y;
          case '*':
              return x*y;
      }
  }
  ```
  
  