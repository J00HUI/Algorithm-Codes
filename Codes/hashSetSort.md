## HashSet 내림차순 정렬
</br>

1. List로 변환 후 정렬
```Java
public class Main {
  public static void main(String args[]) {
    HashSet<String> hSet = new HashSet<String>();

    hSet.add("Hello");
    hSet.add("Java");
    hSet.add("Programming");

    // 정렬 전
    System.out.println("hSet: " + hSet);

    // List로 변환 후 정렬(내림차순)
    List<String> li = new ArrayList<String>(hSet);
    Collections.sort(li, Collections.reverseOrder());

    // 정렬 후
    System.out.println("li: " + li);
  }
}

```
</br>

2. Comparator 사용
```Java
public class Main {
  public static void main(String args[]) {
    HashSet<String> hSet = new HashSet<String>();

    hSet.add("Hello");
    hSet.add("Java");
    hSet.add("Programming");

    // 정렬 전
    System.out.println("hSet: " + hSet);
    
    // TreeSet으로 변환(내림차순)
    TreeSet<String> ts = new TreeSet<String>(
            new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s2.compareTo(s1);
                }
            }
    );

    // 정렬 후
    System.out.println("ts: " + ts);
  }
}
```
</br>

3. Comparator + lamda 사용
```Java
public class Main {
  public static void main(String args[]) {
    HashSet<String> hSet = new TreeSet<String>((o1, o2) -> (o2.compareTo(o1)));

    hSet.add("Hello");
    hSet.add("Java");
    hSet.add("Programming");
  }
}
```
