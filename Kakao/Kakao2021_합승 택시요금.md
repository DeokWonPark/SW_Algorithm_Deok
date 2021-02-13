문제
-----

+ 2021 KAKAO BLIND 합승 택시요금
+ https://programmers.co.kr/learn/courses/30/lessons/72413

풀이 
------

+ 알고리즘 - 최단경로[플로이드-워셜]
1. 플로이드 워셜 알고리즘을 사용해서 모든 경로에 대한 최단경로를 구해준다.
  2. 모든 노드들 i 에 대해서 s부터 i, i 부터 a, i부터 b의 합의 최소경로를 구한다.
   - min(map [s] [i] +map[i] [a] + map[i] [b])

+ 시간복잡도 O(N^3)

+ 코드

  ``` javaScript
  function solution(n, s, a, b, fares) {
      let answer = Number.MAX_SAFE_INTEGER;
  
      const map=[];
      for(let i=1;i<=n;i++){
          map[i]=[0];
          for(let j=1;j<=n;j++){
              if(i===j){
                  map[i].push(0);
                  continue;
              }
              map[i].push(1000001);
          }
      }
  
      for(let i in fares){
          const cur=fares[i];
          map[cur[0]][cur[1]]=cur[2];
          map[cur[1]][cur[0]]=cur[2];
      }
  
      for(let k=1;k<=n;k++){
          for(let i=1;i<=n;i++){
              for(let j=1;j<=n;j++){
                  map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
              }
          }
      }
  
      for(let i=1;i<=n;i++){
          answer=Math.min(answer,map[s][i]+map[i][a]+map[i][b]);
      }
      return answer;
  }
  ```
  
  