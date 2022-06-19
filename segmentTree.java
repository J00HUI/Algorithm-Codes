import java.io.*;
import java.util.*;

public class Main{
	static int NUMBER = 12;
	static int[] a = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
	static int[] tree = new int[4*NUMBER];
	
	static int init(int start, int end, int node) {
		if(start==end) return tree[node] = a[start];
		int mid = (start+end) / 2;
		// 재귀적으로 두 부분으로 나눈 뒤에 그 합을 자기 자신으로 합니다.
		return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node*2+1);
	}
	
	// left, right : 구간 합을 구하고자 하는 범위
	static int sum(int start, int end, int node, int left, int right) {
		// 범위 밖에 있는 경우
		if(left > end || right < start) return 0;
		
		// 범위 안에 있는 경우
		if(left <= start && end <= right) return tree[node];
		
		// 그렇지 않다면 두 부분으로 나누어 합을 구하기
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid+1, end, node * 2+1, left, right);
	}
	
	
	public static void main(String[] args) {
		// 구간 합 트리 생성하기
		init(0, NUMBER-1, 1);
		
		// 구간 합 구하기
		System.out.println("0부터 12까지의 구간 합 : "+ sum(0, NUMBER-1, 1, 0, 12));
		
		System.out.println("4부터 8까지의 구간 합 : " + sum(0, NUMBER-1, 1, 4, 8));
	}
}

