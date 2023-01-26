# Map Inferface 의 유용한 메서드 (JAVA 8 기준)
* Map Interface 의 메서드 중 JAVA8 에 등장한 유용한 메서드들
* JAVA8 하면 뺴놓을 수 없는게 람다식인데 대부분 람다식을 전달 인자로 받음

## Contents
1. forEach()
2. compute()
3. computeIfAbsent()
4. computeIfPresent()
5. getOrDefault()
6. putIfAbsent()
7. iterator
8. entrySet()
9. keySet()
10. Lamda
</br>

## 1. forEach()
forEach() 는 Map 에서 가지고 있는 key와 value 의 값을 하나씩 차례대로 꺼낼 때 사용하면 유용한 메서드입니다.   
사용방법은 아래와 같습니다.   
```
Map<String, String> map = new HashMap<>();
map.put("coding", "01");
map.put("Java", "NoJam");
map.put("Coding", "CodingNoJamHello");
map.put("nojam", "Codingnojam");
 
// 내부에서 key와 value를 쌍으로 하나씩 꺼내서 출력
map.forEach((k, v) -> System.out.println(k + " : " + v));
/* 출력 예시
 * coding : 01
 * Java : NoJam
 * Coding : CodingNoJamHello
 * nojam : Codingnojam 
 */
```
</br>

## 2.compute()
compute() 메서드는 람다식을 통해서 기존의 값에 어떻게 연산을 할지 지정할 수 있습니다.   
사용방법은 다음과 같습니다.
```
Map<String, Integer> map = new HashMap<>();
 
map.compute("coding", (key, oldValue) -> oldValue == null ? 0 : oldValue + 1);
System.out.println(map.get("coding"));	
// 실행결과 0
 
// key의 값이 있는게 확실 한 경우에는 아래처럼도 가능
map.compute("coding", (key, oldValue) -> oldValue + 1);
System.out.println(map.get("coding"));	
// 실행결과 1
```
메서드에 넘겨주는 전달 인자의 첫 번째는 키값이고, 두 번째 인자에 람다식을 전달하면 됩니다.   
한 가지 유의할 점은 해당 키의 값이 존재하지 않으면 NullPointerException이 발생하므로, 키의 값이 null일 때 리턴해줄 값도 지정해야 합니다.    
위의 예제에서는 삼항 연산자를 이용하였으며 간단하게 설명하면 "coding"이라는 키에 매핑된 value값이 oldValue일 때 oldValue가 null이면 0을 반환하고, 아니라면 oldValue의 값에 +1을 하게 됩니다.   
Map을 처음 생성할 때는 아무런 값도 없으므로 "coding"이라는 키의 값이 null일 테니 0을 반환합니다.   
그다음에 동일한 람다식을 전달하면 "coding"이라는 키의 값이 0으로 존재하므로 람다식에서의 연산을 통해 0+1이 되고 1을 리턴해줍니다.   
</br>

## 3. computeIfAbsent()
이번에 소개할 메서드는 computeIfAbsent()입니다.   
메서드 이름에서부터 어떻게 동작할지 느낌이 오는데, 말 그대로 없으면 compute()를 해준다는 의미입니다.   
사용방법은 아래와 같습니다.   
```
Map<String, String> map = new HashMap<>();
 
// 값이 없으면 람다식의 결과 값을 put하고 값 리턴
String value = map.computeIfAbsent("nojam", key -> "Coding" + key );
System.out.println(value);
// 실행결과 : Codingnojam
 
// 값이 존재하면 해당 key의 값 리턴
value = map.computeIfAbsent("nojam", key -> "Hi" + key );
System.out.println(value);
// 실행결과 : Codingnojam
```
computeIfAbsent()에 첫 번째 전달 인자는 key이고, 두 번째 전달 인자는 연산을 수행할 람다식을 전달하면 됩니다.   
기본적으로 리턴 값은 key의 값이 존재하면 해당 key의 값을 반환해주고, 해당 key의 값이 없으면 람다식을 수행하고 나온 결과 값을 반환해줍니다.   
그래서 실제로 위의 로직을 실행해보면 처음에는 "nojam"이라는 key의 값이 없으므로 람다식이 실행되고 Codingnojam이라는 문자열이 결괏값으로 반환되었지만, 두 번째 실행에서는 "nojam"이라는 key의 값이 존재하므로 Hi가 붙은 문자열이 반환되는 게 아니라 해당 key의 값인 Condingnojam이 반환된 걸 알 수 있습니다.   
실제로 이 메서드는 trie자료구조를 만들 때 제가 주로 쓰는데 아주 유용합니다.    
</br>

## 4. computeIfPresent()
computIfPresent()는 위에서 살펴본 computIfAbsent()와 반대로 동작한다고 이해하시면 될 것 같습니다.   
key에 매핑된 value가 있을 때만 전달받은 람다식을 수행해서 새로운 value를 얻어 매핑 후에 값을 리턴해줍니다.   
사용방법은 아래와 같습니다.   
```
Map<String, String> map = new HashMap<>();
map.put("Coding", "NoJam");
 
// Coding이라는 키에 매핑된 value값 있으므로 람다식을 수행하고 새로운 값을 키에 매핑 후 리턴
String str = map.computeIfPresent("Coding", (key, oldValue) -> key + oldValue + "Hello");
System.out.println(str);	// CodingNoJamHello 출력
 
// none이라는 키에 매핑된 value값이 없으므로 null 리턴
String str_null = map.computeIfPresent("none", (key, oldValue) -> key + oldValue + "Hello");
System.out.println(str_null); 	// null 출력
```
첫 번째 인자에는 키를 넘기고, 두 번째 인자에는 실행할 람다식을 전달하면 됩니다.   
얼핏 보면 compute()와 비슷해 보이기도 하는데 compute()는 값이 존재하지 않을 경우도 고려해서 람다식을 작성해야 하고, computeIfPresent()는 키에 매핑된 value값이 존재할 때만 수행됩니다.   
추가적으로 comput()는 키에 매핑된 value가 없으면 람다식에서 얻은 값으로 매핑을 해주지만, computeIfPresent()는 키에 매핑된 value값이 없으면 null을 리턴합니다.   
</br>

## 5. getOrDefault()
getOrDefault() 메서드는 명칭 그대로 key에 매핑된 value값이 존재하면 가져오고, 존재하지 않으면 default값을 가져옵니다.   
사용방법은 아래와 같습니다.   
```
Map<String, String> map = new HashMap<>();
map.put("Java", "NoJam");
		
// Java 키에 매핑 된 값이 존재하므로 NoJam 반환       
String str = map.getOrDefault("Java", "Hi");
System.out.println(str); // NoJam 출력
		
// Map이라는 키에 매핑 된 값이 없으므로 default값인 Interface 반환
str = map.getOrDefault("Map", "Interface");
System.out.println(str); //Interface 출력
```
첫 번째 인자에 key를 주고, 두 번째 인자에 default로 사용할 값을 주면 됩니다.
</br>

## 6. putIfAbsent()
마지막으로 살펴볼 메서드는 putIfAbsent()입니다.   
이름부터가 명확하죠? key에 매핑된 value값이 없으면(null이면) 값을 put해라   
사용방법은 다음과 같습니다.   
```
Map<String, String> map = new HashMap<>();
 
// kakao라는 키에 매핑된 value값이 없으므로 very good을 값으로 매핑
map.putIfAbsent("kakao", "very good");
// naver라는 키에 매핑된 value값이 없으므로 good good을 값으로 매핑
map.putIfAbsent("naver", "good good");
 
// kakao 키가 존재하므로 매핑 된 value 값 리턴
String str = map.putIfAbsent("kakao", "bad");
System.out.println(str);  //very good 출력
// naver 키가 존재하므로 매핑 된 value 값 리턴
str = map.putIfAbsent("naver", "not bad");
System.out.println(str);  //good good 출력
```
첫 번째 인자에 key값을 주고, 두 번째 인자에 매핑하고 싶은 value값을 전달하시면 됩니다.    
사용하실 때 유의하실 점은 리턴 값이 put을 했는지 안 했는지에 대한 boolean값이라고 생각하시면 안 됩니다.   
실제 리턴 값은 해당 key에 현재 매핑된 value값을 리턴해줍니다.    
만약 key에 매핑된 value값이 존재하면 그대로 값을 리턴해주고, 존재하지 않으면 null을 리턴합니다.   
</br>

## 7. iterator
```Java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
public class MapIterationSample {
    public static void main(String[] agrs) {
        Map<String, String> map = new HashMap<String, String>();
         
        map.put("키1", "값1");
        map.put("키2", "값2");
        map.put("키3", "값3");
        map.put("키4", "값4");
        map.put("키5", "값5");
        map.put("키6", "값6");
         
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
        }
         
    }
}
```
</br>

## 8. entrySet()
```Java
Map<String, String> map = new HashMap<>();
map.put("key01", "value01");
map.put("key02", "value02");
map.put("key03", "value03");
map.put("key04", "value04");
map.put("key05", "value05");

// 방법 01 : entrySet()
for (Map.Entry<String, String> entry : map.entrySet()) {
	System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
}
```
</br>

## 9. keySet()
```Java
Map<String, String> map = new HashMap<>();
map.put("key01", "value01");
map.put("key02", "value02");
map.put("key03", "value03");
map.put("key04", "value04");
map.put("key05", "value05");
        
// 방법 02 : keySet()
for (String key : map.keySet()) {
	String value = map.get(key);
	System.out.println("[key]:" + key + ", [value]:" + value);
}
```
</br>

## 10. Lamda
```Java
Map<String, String> map = new HashMap<>();
map.put("key01", "value01");
map.put("key02", "value02");
map.put("key03", "value03");
map.put("key04", "value04");
map.put("key05", "value05");

// 방법 05 : Lambda 사용
map.forEach((key, value) -> {
	System.out.println("[key]:" + key + ", [value]:" + value);
});
```
</br>

---
### Reference
* https://codingnojam.tistory.com/39 [알면 know jam! 모르면 no jam!:티스토리]
* https://stove99.tistory.com/96 (iterator)
* https://tychejin.tistory.com/31
