## 최대 공약수

```Java
public static int gcd(int p, int q)
 {
	if (q == 0) return p;
	return gcd(q, p%q);
 }
```

## 최소 공배수

```Java
public static int lcm(int p, int q)
 {
	return p * q / gcd(q, p%q);
 }
```
