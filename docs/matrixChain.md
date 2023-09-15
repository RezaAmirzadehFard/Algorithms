# Matrix Chain Multiplication
## Problem :
 >Given a chain `<A1, A2,...,An>` of `n` matrices, where `for i = 1, 2,...,n`, matrix `Ai` has dimension `pi-1 * pi`, fully parenthesize the product `A1A2...An` in way that **minimize** the number of scalar multiplications.

> The goal of the problem is that to find a way to parenthesize the sequence of matrices that yields the lowest cost. 
## Recursive Formula :

- `p[]` is an array that store dimension of the matrix chain
- `m[][]` is an array that saves minimum cost of the scalar multiplication of sequence `<Ai,Ai+1,...,Aj>`

### Formula :

`m[i,j] = min(m[i,k] + m[k+1,j] + p[i-1] * p[k] * p[j])` & `i <= k < j`

## Top-Down :
<!--
```java
public class TopDown {
    public static int memoizedRodCut(int[] p, int n) {
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedRodCutAux(p, n, r);
    }

    public static int memoizedRodCutAux(int[] p, int n, int[] r) {
        if (n == 0) {
            return p[n];
        }
        if (r[n] > 0) {
            return r[n];
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = max(q, p[i] + memoizedRodCutAux(p, n - i, r));
        }
        r[n] = q;
        return q;
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](dynamicProgarmming/rodcut/TopDownRodCut.java).


-->
## Bottom-Up :
<!--
```java
public class BottomUp {
  public static int bottomUpROdCut(int[] p, int n){
    int[] r = new int[n+1];
    r[0]=0;
    for (int j = 1; j <= n; j++){
      int q = Integer.MIN_VALUE;
      for(int i = 1; i <= j; i++){
        q = max(q, p[i]+r[j-i]);
      }
      r[j] = q;
    }
    return r[n];
  }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](dynamicProgarmming/rodcut/BottomUpRodCut.java).
-->
### Example:
<!--
#### Given Price Table
| length `i` | 0 | 1 | 2 | 3 | 4 | 5  | 6  | 7  | 8  | 9  | 10 |
|------------|---|---|---|---|---|----|----|----|----|----|----|
| price `i`  | 0 | 1 | 5 | 8 | 9 | 10 | 17 | 17 | 20 | 24 | 30 |
  
- If we have a rod of length, 5 and want to cut up the rod and selling with maximum revenue or cost, we can obtain the cost with recursive formula:

rod with length of 5:



- `r[5]= max(p[i] + r[5-i])` & `1 <= i <= 5`

    - [ ] `i = 1` ==> p[1] + r[4] = 11
    - [x] `i = 2` ==> p[2] + r[3] = 13
    - [x] `i = 3` ==> p[3] + r[2] = 13
    - [ ] `i = 4` ==> p[4] + r[1] = 10
    - [ ] `i = 5` ==> p[5] + r[0] = 10


- `r[4]= max(p[i] + r[4-i])` & `1 <= i <= 4`

  - [ ] `i = 1` ==> p[1] + r[3] = 9
  - [x] `i = 2` ==> p[2] + r[2] = 10
  - [ ] `i = 3` ==> p[3] + r[1] = 9
  - [ ] `i = 4` ==> p[4] + r[0] = 9


- `r[3]= max(p[i] + r[3-i])` & `1 <= i <= 3`

  - [ ] `i = 1` ==> p[1] + r[2] = 6
  - [ ] `i = 2` ==> p[2] + r[1] = 6
  - [x] `i = 3` ==> p[3] + r[0] = 8


- `r[2]= max(p[i] + r[2-i])` & `1 <= i <= 2`

  - [ ] `i = 1` ==> p[1] + r[1] = 2 
  - [x] `i = 2` ==> p[2] + r[0] = 5


- `r[1]= max(p[i] + r[1-i])` & `1 <= i <= 1`

  - [x] `i = 1` ==> p[1] + r[0] = 1


- `r[0] = 0` ==> base condition

---

-->

## Recursion Tree

## Recursion Tree of Formula


## Bottom-Up Tabulation
