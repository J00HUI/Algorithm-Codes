# Trie

## 1. Trie 란?
Trie 는 일반적인 Tree 자료구조와 같은 모양이지만 저장하는 값이 다른 형태입니다.   
정수형을 저장하는 Tree 가 아래와 같은 모양으로 있다고 가정하겠습니다.   

![image](https://user-images.githubusercontent.com/83942393/174538577-e5ad5b57-badf-4b06-b225-46b1a83e7ad6.png)

위와 같은 정수형 자료의 이진트리에서 검색을 수행할 때 O(logN) 의 시간 복잡도를 가지게 됩니다.   
그러나 같은 이진트리 형태여도 문자열을 저장하고 있다면 문자열의 길이가 M 일 때, O(M\*logN)의 시간 복잡도를 가지게 됩니다. (문자 한개를 탐색하는 시간 복잡도 : O(logN), M 개의 문자를 탐색 -> O(M\*logN)  
**하지만 Trie 를 사용하면 시간 복잡도를 O(logM) 으로 단축시킬 수 있습니다.**

Trie 는 문자열 전체를 하나의 노드에 저장하는 것이 아니라, 한 문자씩 노드에 저장하는 트리입니다.   
![image](https://user-images.githubusercontent.com/83942393/174539074-66834810-5b90-473f-bff2-0ac464ae871a.png)   

Trie는 루트 노드는 비어있고 첫 번째 자식 노드부터 문자열의 첫 단어가 저장됩니다.   
현재 위 그림의 Trie에 저장된 문자는 cap, code, kakao, kai입니다.   
Trie 자료구조는 문자열의 한 단어씩 자식 노드와 비교해가면서 검색을 진행할 수 있습니다.   
예를 들어 cap을 검색한다면 c자식노드 -> a자식노드 -> p자식노드 순으로 검색을 진행할 수 있습니다.   
kakao를 검색한다면 k자식노드 -> a자식노드 -> k자식노드 -> a자식노드 -> o자식노드   
만약에 없는 단어를 검색한다면 어떻게 진행될까요??   
coding을 검색한다면 c자식노드 -> o자식노드 -> d자식노드 -> i값을 가지는 자식노드는 없으므로 검색 불가   
이러한 식으로 찾고자 하는 문자를 탐색하므로 문자열의 길이가 M일 때, **탐색 시간 복잡도는 O(M)** 을 가지게 되므로 매우 효율적이라고 할 수 있습니다.   

## 코드
```
import java.io.*;
import java.util.*;


public class Main{
	static class Node {
		Map<Character, Node> childNode = new HashMap<Character, Node>();
		
		boolean endOfWord;
	}
	
	static class Trie {
		
		// Trie 자료 구조를 생성할 때 rootNode 는 기본적으로 생성
		Node rootNode = new Node();
		
		// Trie 문자열 저장
		void insert(String str) {
			
			// Trie 자료구조는 항상 rootNode부터 시작
			Node root = this.rootNode;
			
			// 문자열의 각 문자가 root 자식노드들 중에 있는지 체크
			// 없다면 자식노드 생성 후 그 값 리턴
			// 있다면 key 의 value 값을 리턴
			// computeIfAbsent() 의 설명은 코드 하단의 링크 참고
			for(int i=0; i<str.length(); i++) {
				root = root.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			
			// 저장할 마지막 문자의 node 에는 단어의 끝임을 명시
			root.endOfWord = true;
		}
		// Trie에서 문자열 검색
		boolean search(String str) {
			// Trie 자료구조는 항상 rootNode부터 시작
			Node root = this.rootNode;
			
			// 문자열의 각 문자마다 노드가 존재하는지 체크
			for(int i=0; i<str.length(); i++) {
				// 문자가 있으면 키에 해당하는 값을 가져오고 아니면 null
				// getOrDefault() 의 설명은 코드 하단의 링크 참고
				root = root.childNode.getOrDefault(str.charAt(i), null);
				//root = root.childNode.get(str.charAt(i)); 위 코드와 동일한 코드
				if(root == null) {
					// root 가 null 이면 현재 Trie 에 해당하는 문자열은 없음
					return false;
				}
			}
			
			// 문자열의 마지막 문자까지 노드가 존재해도 해당 문자열이 존재하는 것이 아님
			// busy 로 예를 들어보면 bus 까지 매핑된 노드가 존재해도 y 까지 존재하는지 검사해야 함
			// 그러므로 현재 노드가 문자열의 끝까지 돌았는지 체크하는 변수를 리턴
			return root.endOfWord;
			
		}
		
		// Trie 에서 문자열 삭제
		void delete(String str) {
			delete(this.rootNode, str, 0);
		}
		private void delete(Node root, String str, int idx) {
			char c = str.charAt(idx);
			
			if(!root.childNode.containsKey(c))
				throw new Error("not exits");
			
			Node child = root.childNode.get(c);
			idx++;
			if(idx == str.length()) {
				if(!child.endOfWord)
					throw new Error("not exist");
				
				// 문자열 삭제를 위한 마지막 글자 여부 false
				child.endOfWord = false;
				// 마지막 문자인데 자식노드가 없으면 노드 삭제
				if(child.childNode.isEmpty())
					root.childNode.remove(c);
			} else {
				delete(child, str, idx); 	// 정상적인 삭제를 위해 선 호출
				
				// 정상적으로 호출이 진행되어 자식 노드가 없고, 해당 노드로 이어지는 문자가 없으면 삭제
				if(!child.endOfWord && child.childNode.isEmpty())
					root.childNode.remove(c);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		// Trie 에 문자열 저장
		trie.insert("kakao");
		trie.insert("busy");
		trie.insert("card");
		trie.insert("cap");
		
		// Trie 에 저장된 문자열 확인
		System.out.println(trie.search("bus"));		// false
		System.out.println(trie.search("busy"));	// true
		System.out.println(trie.search("kakao"));	// true
		System.out.println(trie.search("cap"));		// true
		
		System.out.println("삭제 후");
		trie.delete("cap");
		System.out.println(trie.search("cap"));		// false
	}
}


```
* [Map.computeIfAbsent(), Map.getOrDefault() 의 설명 링크](map.md)



---
출처: https://codingnojam.tistory.com/40 [알면 know jam! 모르면 no jam!:티스토리]   
