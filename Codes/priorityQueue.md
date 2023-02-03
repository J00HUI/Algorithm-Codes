## 1. Collections.reverseOrder()

```Java
import java.util.PriorityQueue;
import java.util.Collections;

//낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

//높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
```
</br>

## 2. 객체 정렬 - Comparable
```Java
public class ClassName implements Comparable<Type> { 
 
/*
  ...
  code
  ...
 */
 
	// 필수 구현 부분
	@Override
	public int compareTo(Type o) {
		/*
		 비교 구현
		 */
	}
}
```
</br>

## 3. 객체 정렬 - Comparator
```Java
import java.util.Comparator;	// import 필요
public class ClassName implements Comparator<Type> { 
 
/*
  ...
  code
  ...
 */
 
	// 필수 구현 부분
	@Override
	public int compare(Type o1, Type o2) {
		/*
		 비교 구현
		 */
	}
}
```
