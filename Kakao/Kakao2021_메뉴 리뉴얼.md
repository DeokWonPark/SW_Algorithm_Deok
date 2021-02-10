문제
-----

+ 2022 KAKAO BLIND 메뉴리뉴얼
+ https://programmers.co.kr/learn/courses/30/lessons/72411

풀이 
------

+ 알고리즘 - 완전탐색

  

+ 코드

  ``` javaScript
  const check=new Set();
  function solution(orders, course) {
      const result=[];
      const answer =[];
  
      for(let i of course){
          answer[i]=[];
      }
  
      const order=[];
      for(let i in orders){
          order[i]=[];
          for(let j=0;j<orders[i].length;j++){
              order[i].push(orders[i][j]);
          }
          order[i].sort();
      }
  
      for(let i of course){
          for(let j in order){
              search(order[j],"",0,0,i,answer);
          }
      }
  
      for(let i of course){
          answer[i].sort();
          let max=0;
          let max_str=[];
          let s="";
          let cur=1;
          for(let j of answer[i]){
              if(s===""){
                  s=j;
                  if(max<cur){
                      max=cur;
                  }
                  continue;
              }
              if(s===j){
                  cur++;
              }
              else{
                  if(max<cur){
                      max=cur;
                  }
                  s=j;
                  cur=1;
              }
          }
          if(cur!=1){
              if(max<cur){
                  max=cur;
              }
          }
          cur=1;
          s="";
          for(let j of answer[i]){
              if(s===""){
                  s=j;
                  continue
              }
              if(s===j){
                  cur++;
              }
              else{
                  if(max===cur){
                      max_str.push(s);
                  }
                  s=j;
                  cur=1;
              }
          }
          if(max===cur){
              max_str.push(s);
          }
          for(let j of max_str){
              result.push(j);
          }
      }
  
      result.sort();
      return result;
  }
  
  function search(arr,str,start,index,num,answer){
      if(start===num){
          if(check.has(str)){
              answer[num].push(str);
          }
          else{
              check.add(str);
          }
          return;
      }
  
      if(index>=arr.length){
          return;
      }
      search(arr,str,start,index+1,num,answer);
      search(arr,str+arr[index],start+1,index+1,num,answer);
  }
  ```
  
  