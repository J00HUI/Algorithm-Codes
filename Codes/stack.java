public class Node {
	public String data;	// data 필드
	public Node link; 	//link 필드
	
	
	public Node(String data, Node link) {
		this.data = data;
		this.link = link;
	}


	public Node(String data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}

=================================================================================================================
public class Stack {
	
	private Node top;
	
	public void push(String data) {
		// 첫번째 노드로 삽입
		top = new Node(data, top);
	}
	public String pop() {
		if(isEmpty()) return null;
			
		// 첫번째 노드(top) 삭제
		Node popNode = top;
		top = popNode.link;
		
		popNode.link = null;
		return popNode.data;
	}
	public boolean isEmpty() {
		return top == null;
	}
	@Override
	public String toString() {
		//top부터 마지막 노드까지 쭉 돌며 data를 문자열로 합치기
		StringBuilder sb = new StringBuilder();
		sb.append("Stack[");
		for(Node currNode=top; currNode != null; currNode = currNode.link) {
			sb.append(currNode.data).append(",");
		}
		if(!isEmpty()) sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
}
