## Flood Fill (Seed Fill)

Flood Fill 알고리즘에 대한 정의를 찾아보면 보통 아래와 같이 나온다.

> 주어진 시작점으로부터 연결된 영역들을 찾는 알고리즘  

해당 알고리즘을 사용하는 케이스는 보통 아래와 같다    
   
* 그림판 프로그램의 "채우기" 기능 - 해당 영역의 주변에 모든 셀을 같은 색으로 색칠
* 지뢰 찾기 프로그램 - 특정 셀을 클릭 시 주변에 지뢰가 없는 모든 셀을 찾아 줌
   
Flood Fill 알고리즘은 보통 DFS 알고리즘을 이용하여 재귀 함수를 통해 구현하거나   
BFS 알고리즘을 이용하여 Queue를 이용하여 구현한다.   

이번에는 2차원 배열에서 DFS를 사용하여 Flood Fill 관련 알고리즘 문제를 푸는 예제를 하나 보도록 하겠다. 

DFS는 2차원 배열의 경우에서 인접한 배열을 ( 위 - 오른쪽 - 아래 - 왼쪽 )의 순서로 방문한다고 가정하자.

그러면 해당 내용을 간단하게 의사 코드로 표현하면 아래와 같다.

```
void DFS_array( int x, int y) {

	visit(x,y);
    
    if (isValid(x, y +1)) { // 위의 배열 방문 
    	DFS_array ( x, y+1);
    }
    if (isValid(x+1, y)) { // 오른쪽 배열 방문 
    	DFS_array ( x+1, y);
    }
    if (isValid(x, y -1)) { // 아래 배열 방문 
    	DFS_array ( x, y-1);
    }
    if (isValid(x-1, y)) { // 왼쪽 배열 방문 
    	DFS_array ( x-1, y);
    }
}    
```

출처 : https://youtu.be/By77aC9Oe3Q
 
![image](https://user-images.githubusercontent.com/83942393/174524875-30ce1696-b19e-4d68-97c0-f4e07561b350.png)

이동 순서 ( 위 - 오른쪽 - 아래 - 왼쪽 ) 

이러한 방식으로 기본적으로 2차원 배열에서 DFS가 어떻게 동작하는지 파악하였으니    
이러한 내용을 응용하여 Flood Fill 알고리즘에 적용해 보도록 하자    

![1](https://user-images.githubusercontent.com/83942393/174525835-0967d893-ea08-48e6-935a-90959af1f830.gif)


해당 그림에서 검은색은 벽이고 하얀 부분을 방문 가능한 영역이라고 했을 때, 
최종적으로 방문 할 수 있는 영역의 개수를 구하는 문제를 푼다고 해보자 

```
int floodFill(int[][] metrics) {
    int cnt = 0;
    for (int i = 0; i < metrics.length; i++) {

        for (int j = 0; j < metrics[0].length; j++) {

            if (isValid(metrics[i][j])) { // 벽이 아닌 영역인지 판단, 이미 방문했는지 판단
                cnt++;
                DFS_array(i, j);
            }
        }
    }

    return cnt;
}
```
출처 : https://joomn11.tistory.com/29
  
