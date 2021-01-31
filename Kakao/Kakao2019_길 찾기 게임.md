문제
-----

+ 2019 KAKAO BLIND 길 찾기 게임
+ https://programmers.co.kr/learn/courses/30/lessons/42892

풀이 
------

+ 알고리즘 - 트리의 탐색

  1. Input의 y값이 가장 큰 노드를 root값으로 선정
  2. root보다 x값이 큰노도들을 right[]에 넣고, 작은노드들을 left[]에 넣어서 right값의 첫 노드를 root의 right노드로 하고, left도 동일하게 하여 이것을 반복해서 모든노드들의 right,left값을 구해 트리를 구성한다.
  3. 구성된 트리를 전위순회, 후위순회하여 결과값을 반환 
  
  
  
+ 시간복잡도 O(N)

  

+ 코드

  ``` javaScript
  class map{
      constructor(x,y,n){
          this.x=x;
          this.y=y;
          this.n=n;
      }
  }
  class node{
      constructor(left,right,n){
          this.left=left;
          this.right=right;
          this.n=n;
      }
  }
  const tree=[];
  function solution(nodeinfo) {
      const answer = [];
  
      const nodes=[];
      let index=1;
      for(let i of nodeinfo){
          nodes.push(new map(Number.parseInt(i[0]),Number.parseInt(i[1]),index));
          index++;
      }
      nodes.sort((a,b)=>{
          if(a.y>b.y){
              return -1;
          }
          else if(a.y<b.y){
              return 1;
          }
      })
      const root=nodes.splice(0,1);
      makeTree(nodes,root);
  
      let post=[];
      let pre=new Array();
  
      preorder(root[0].n,pre);
      postorder(root[0].n,post);
      answer.push(pre);
      answer.push(post);
      return answer;
  }
  
  function postorder(root,post){
      const left=tree[root].left;
      const right=tree[root].right;
      if(left!==null){
          postorder(tree[left].n,post);
      }
      if(right!==null){
          postorder(tree[right].n,post);
      }
      post.push(root);
      return;
  }
  
  function preorder(root,pre){
      pre.push(root);
      const left=tree[root].left;
      const right=tree[root].right;
      if(left!==null){
          preorder(tree[left].n,pre);
      }
      if(right!==null){
          preorder(tree[right].n,pre);
      }
      return;
  }
  
  function makeTree(arr,parent){
      if(arr.length===0){
          const root_node=new node(null,null,parent[0].n);
          tree[root_node.n]=root_node;
          return;
      }
      const left=[];
      const right=[];
  
      const len=arr.length;
      for(let i=0;i<len;i++){
          const tok=arr.splice(0,1);
          if(Number.parseInt(parent[0].x)<Number.parseInt(tok[0].x)){
              right.push(tok[0]);
          }
          else{
              left.push(tok[0]);
          }
      }
  
      let right_node=null;
      let left_node=null;
      let right_n=null;
      let left_n=null;
      if(right.length!==0){
          right_node=right.splice(0,1);
          right_n=right_node[0].n;
      }
      if(left.length!==0){
          left_node=left.splice(0,1);
          left_n=left_node[0].n;
      }
  
      const root_node=new node(left_n,right_n,parent[0].n);
      tree[root_node.n]=root_node;
      if(right_node!=null){
          makeTree(right,right_node);
      }
      if(left_node!=null){
          makeTree(left,left_node);
      }
  }
  ```
  
  