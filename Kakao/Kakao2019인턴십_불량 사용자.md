문제
-----

+ 2019 KAKAO 인턴십 불량 사용자
+ https://programmers.co.kr/learn/courses/30/lessons/64064

풀이 
------

+ 알고리즘 - 완전탐색

  1. user_id에 대해서 banned_id의 개수만큼 선택 할 수있는 모든 경우의 수를 계산한다.
2. 찾아낸 모든 경우의 수를 가지고 하나씩 banned_id와 문자를 하나씩 비교하여 올바른 경우의 수인지를 판단한다.
  3. 올바른 경우라면 (banned_id와 일치하는 경우) 해당 배열을 정렬하여 문자열 형태로 변환하여 중복된 경우를 제거하기 위해 Set에 넣는다.
  4. Set의 길이를 반환한다.




+ 코드

  ``` javaScript
  let N,M,set;
  function solution(user_id, banned_id) {
      let answer = 0;
      N=user_id.length;
      M=banned_id.length;
      if(N===0 || M===0){
          return 0;
      }
      set=new Set();
      for(let i in user_id){
          N=Number.parseInt(i);
          lucky(N,0,"",user_id,banned_id,true);
      }
      answer=set.size;
      return answer;
  }
  
  function lucky(index,start,str,user_id,banned_id,flag){
      if(start===M){
          const cur_user=str.split(" ");
          cur_user.pop();
          if(verification(cur_user,banned_id)){
              let tp="";
              cur_user.sort();
              for(let i in cur_user){
                  tp+=(cur_user[i]+" ");
              }
              set.add(tp);
          }
          return;
      }
      else{
          if(index===N && flag===false){
              return;
          }
          lucky((index+1)%user_id.length,start,str,user_id,banned_id,false);
          lucky((index+1)%user_id.length,start+1,str+user_id[index]+" ",user_id,banned_id,false);
      }
  }
  
  function verification(cur_user,banned_id){
      const temp=[...banned_id];
          for(let i=0; i<cur_user.length;i++){
              let c=0;
              for(let j in temp){
                  const result=check(cur_user[i],temp[j]);
                  if(result){
                      temp.splice(j,1);
                      c++;
                      break;
                  }
              }
              if(c===0){
                  return false;
              }
          }
      return true;
  }
  
  function check(user,ban){
      if(user.length!==ban.length){
          return false;
      }
      for(let i=0;i<user.length;i++){
          if(ban[i]==='*'){
              continue;
          }
          if(user[i]!==ban[i]){
              return false;
          }
      }
      return true;
  }
  ```
  
  