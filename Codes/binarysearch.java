package ssafy;

import java.io.*;
import java.util.*;

//* 이진 탐색 문제는 탐색 범위가 큰 상황에서 탐색을 가정하는 문제가 많으므로, 탐색 범위가 2,000만을 넘어가면 이진탐색으로 접근 (c++ 기준)
//* 이진 탐색 O(logn)

public class Prac2{
	//재귀함수를 이용한 이진 탐색
	static int binarySearch1(int[] arr, int target, int start, int end) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		
		// 찾은 경우 중간점 인덱스 반환
		if (arr[mid] == target) return mid;
		
		// 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
		else if (arr[mid] > target) return binarySearch1(arr, target, start, mid - 1);
		
		// 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
		else return binarySearch1(arr, target, mid + 1, end);
	}
	
	//반복문을 이용한 이진 탐색
	static int binarySearch2(int[] arr, int target, int start, int end) {
	  while (start <= end) {
	      int mid = (start + end) / 2;
	      
	      // 찾은 경우 중간점 인덱스 반환
	      if (arr[mid] == target) return mid;
	      
	      // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
	      else if (arr[mid] > target) end = mid - 1;
	      
	      // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
	      else start = mid + 1;
	  }
	  return -1;
	}
	
	public static void main(String[] args) {
		//n(원소의 개수)와 target(찾고자 하는 값)을 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr = new int[n];
	    // 전체 원소 입력받기
	    for (int i = 0; i < n; i++) {
	        int x = sc.nextInt();
	        arr[i] = x;
	    }
	    // 이진 탐색 수행 결과 출력
	    int result = binarySearch1(arr, target, 0, n - 1);
	    if (result == -1) {
	    	System.out.println("원소가 존재하지 않습니다.");
	    }
	    else {
	    	System.out.println(result);
	    }
	    
	    result = binarySearch2(arr, target, 0, n - 1);
	    if (result == -1) {
	    	System.out.println("원소가 존재하지 않습니다.");
	    }
	    else {
	    	System.out.println(result);
	    }
	}
}

//<입력>
//10 7
//1 3 5 7 9 11 13 15 17 19
//
//<출력>    
//3

