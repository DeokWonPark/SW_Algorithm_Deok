문제
-----

+ 2019 KAKAO 인턴십 튜플
+ https://programmers.co.kr/learn/courses/30/lessons/67259

풀이 
------

+ 알고리즘 - 구현

  1.  입력 문자열을 배열 형태로 변환한다.
  2. 변환된 2차원 배열을 원소의 개수를 기준으로 정렬한다.
  3. 원소의 개수가 작은 배열부터 집합에 넣는다.
     - 이때 집합에 포함되지 않았던 원소를 정답배열인 answer에 넣는다.

  

+ 코드

  ``` javaScript
  class idx{
      constructor(index,length){
          this.index=index;
          this.length=length;
      }
  }
  function solution(s) {
      const answer = [];
  
      const temp=s.split("}");
  
      const arr=[];
      for(let i=0;i<temp.length-2;i++){
          arr[i]=[];
      }
  
      for(let i in arr){
          const toks=temp[i].split(",");
          for(let j in toks){
              const tok=toks[j];
              let R="";
              for(let s=0;s<tok.length;s++){
                  if(tok[s]==='{'){
                      continue;
                  }
                  R+=tok[s];
              }
              if(R===''){
                  continue;
              }
              arr[i].push(R);
          }
      }
  
      const idxs=[];
      for(let i in arr){
          let len= arr[i].length;
          idxs.push(new idx(Number.parseInt(i),len));
      }
  
      idxs.sort((a,b)=>{
          if(a.length<b.length){
              return -1;
          }
          else if(a.length===b.length){
              return 0;
          }
          else{
              return 1;
          }
      });
  
      const set=new Set();
      for(let i in idxs){
          let j=idxs[i].index;
          while(arr[j].length!==0){
              let result=arr[j].pop();
              if(!set.has(result)){
                  set.add(result);
                  answer.push(Number.parseInt(result));
                  break;
              }
          }
      }
  
      return answer;
  }
  ```
  
  