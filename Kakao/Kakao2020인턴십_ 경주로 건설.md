문제
-----

+ 2020 KAKAO 인턴십 경주로 건설
+ https://programmers.co.kr/learn/courses/30/lessons/67259

풀이 
------

+ 알고리즘 - 그래프 탐색

  - DFS 탐색을 수행하고, 최소비용 배열을 계산해서 백트래킹하여 시간을 줄인다
  - 일반적인 DFS탐색을 하게되면 O(N^2)시간이 소요되어 시간초과가 발생하게 된다.

  1. 상,하,좌,우 4방향으로 탐색을 진행하는데, 탐색을 수행할 조건으로는 벽이 아니거나, 다음 탐색을 진행할 공간의 최소비용보다 현재의 비용 + 건설비용이 적은경우 탐색을 수행한다.

  

+ 코드

  ``` javaScript
  let min=Number.MAX_SAFE_INTEGER;
  let dist=[]
  function solution(board) {
      let answer = 0;
      const check=Array.from({length:board.length},(v,i)=>false);
      dist=Array.from({length:board.length},(v,i)=>min);
      let index=0;
      dist.map(()=>dist[index++]=Array.from({length:board.length},(v,i)=>min));
      index=0;
      check.map((c)=>check[index++]=Array.from({length:board.length},(v,i)=>false));
      dist[0][0]=0;
      DFS(board,check,0,0,-1,0);
      answer=min;
      return answer;
  }
  function DFS(board,check,x,y,see,money){
      const go=[[1,0],[0,1],[-1,0],[0,-1]];
      if(x===board.length-1 && y===board.length-1){
          min=Math.min(money,min);
          return;
      }
      for(let i=0;i<4;i++){
          let temp=see;
          if(temp===-1){
              temp=0;
          }
          let j=(temp+i)%4;
          let x_,y_;
          x_=x+go[j][0];
          y_=y+go[j][1];
          if(x_>=0 && x_<board.length && y_>=0 && y_<board.length){
              if(board[x_][y_]===0 && check[x_][y_]===false){
                  check[x_][y_]=true;
                  if(see===-1){
                      check[x][y]=true;
                      if(money+100<=dist[x_][y_]+500){
                          if(money+100<=dist[x_][y_]){
                              dist[x_][y_]=money+100;
                          }
                          DFS(board,check,x_,y_,j,money+100);
                      }
                  }
                  if(see===j){
                      if(money+100<=dist[x_][y_]+500){
                          if(money+100<=dist[x_][y_]){
                              dist[x_][y_]=money+100;
                          }
                          DFS(board,check,x_,y_,j,money+100);
                      }
                  }
                  else{
                      if(money+600<=dist[x_][y_]+500){
                          if(money+600<=dist[x_][y_]){
                              dist[x_][y_]=money+600;
                          }
                          DFS(board,check,x_,y_,j,money+600);
                      }
                  }
                  check[x_][y_]=false;
              }
          }
      }
  }
  ```
  
  