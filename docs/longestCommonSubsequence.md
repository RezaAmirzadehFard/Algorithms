# Longest Common Subsequence
## Problem :
>Given two sequences  `X = <x1, x2,...,xm>` and `Y = <y1, y2,...,yn>` and we wish to find a `Z` that maximum length common subsequence of `X` and `Y` .
## Recursive Formula :
- `i` is an index that shows feasible location for cutting
- `j` is an array that shows price of rod without cutting
- `c[][]` is an array that store maximum revenue obtains by cutting up the rod of length n

### Formula :

```
c[i,j] = if xi = yj and i > j > 0:
            c[i-1, j-1] + 1
            
         if xi != yj and i > j > 0:
            max(c[i,j-1], c[i-1,j])
            
         if i = 0 or j = 0:
            0
```

## Top-Down :
```java
public class TopDown {
    public static int topDownLongestCommonSubsequence(char[] x, char[] y, int m, int n, int[][] r){
        if (m == 0 || n == 0){
            return 0;
        }
        if (r[m][n] > 0){
            return r[m][n];
        }
        if (x[m-1] == y[n -1]){
            int p = topDownLongestCommonSubsequence(x,y,m-1,n-1,r) + 1;
            r[m][n] = p;
            return p;
        }else{
            int p = topDownLongestCommonSubsequence(x,y,m,n-1,r);
            int q = topDownLongestCommonSubsequence(x,y,m -1,n,r);
            int max = Math.max(p,q);
            r[m][n] = max;
            return max;
        }
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/rodcut/TopDownRodCut.java).

## Bottom-Up :
```java
public class BottomUp {
    public static int bottomUpLongestCommonSubsequence(char[] x, char[] y, int m, int n){
        int[][] c = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            c[i][0] = 0;
        }

        for(int j = 0; j <= n; j++){
            c[0][j] = 0;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    c[i][j] = 0;
                else if (x[i - 1] == y[j - 1])
                    c[i][j] = c[i - 1][j - 1] + 1;
                else
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
        return c[m][n];
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](dynamicProgarmming/rodcut/BottomUpRodCut.java).

### Example:

#### Given Sequence Element Table
| length `i`, `j` | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|-----------------|---|---|---|---|---|---|---|---|
| Sequence `X`    | 0 | A | B | C | B | D | A | B |
| Sequence `Y`    | 0 | B | D | C | A | B | A | - |

- If we have two sequences X = <A, B, C, B, D, A, B> and Y = < B, D, C, A, B, A> and we want to find the longest common subsequence of them, we can obtain the LCS with recursive formula:


- Notice: Xi = <x1,x2,...,xi> and Yj = < y1,y2,...,yj>

LCS of X = <A, B, C, B, D, A, B> and Y = < B, D, C, A, B, A>:

- `c[7][6] = max(c[6,6], c[7,5])` & `x7 != y6`
- c[7][6] = max(3,4) = 4
- 
- `c[6][6] = c[5,5] + 1` & `x6 == y6`
- c[6][6] = 2 + 1 = 3
- 
- `c[5][5] = max(c[4,5], c[5,4])` & `x5 != y5`
- C[5][5] = max(2,2) = 2
- 
- `c[5][4] = max(c[4,4], c[5,3])` & `x5 != y4`
- c[5][4] = max(1,2) = 2
-
- `c[4][5] = c[3,4] + 1` & `x4 == y5`
- C[4][5] = 1 + 1 = 2
- 
- `c[5][3] = max(c[4,3], c[5,2]` & `x5 != y3`
- c[5][3] = max(1,2) = 2
-
- `c[5][2] = c[4,1] + 1` & `x5 == y2`
- c[5][2] = 1 + 1 = 2
- 
- `c[4][4] = max(c[4,3], c[3,4])` & `x4 != y4`
- c[4][4] = max(1,1) = 1
- 
- `c[4][3] = max(c[3,3], c[4,2])` & `x4 != y3`
- c[4][3] = max(1,1) = 1
- 
- `c[4][2] = max(c[4,1], c[3,2])` & `x4 != y2`
- c[4][2] max(1,1) = 1
- 
- `c[4][1] = c[3,0] + 1` & `x4 == y1`
- c[4][1] = 0 + 1 = 1
- 
- `c[4][5] = c[3,4] + 1` & `x4 == y5`
- c[4][5] = 1 + 1 = 2
- 
- `c[3][4] = max(c[2,4], c[3,3])` & `x3 != y4`
- c[2][4] = max(1, 1) = 1
- 
- `c[3][3] = max(c[2,3], c[3,2])` & `x3 != y3`
- c[3][3] = max(1,1) = 1
- 
- `c[3][2] = max(c[2,2], c[3,1])` & `x3 != y2`
- c[3][2] = max(1,1) = 1
- 
- `c[3][1] = max(c[2,1], c[3,0])` & `x3 != y1`
- c[3][1] = max(1,0) = 1
- 
- `c[3][0] = 0` & `y0 => i = 0 => c[3,0] = 0`
- c[3][0] = 0
- 
- `c[2][4] = max(c[1,4], c[2,3])` & `x2 != y4`
- c[1][4] = max(1, 1) = 1
- 
- `c[2][3] = max(c[1,3], c[2,2])` & `x2 != y3`
- c[2][3] = max(0,1) = 1
- 
- `c[2][2] = max(c[1,2], c[2,1])` & `x2 != y2`
- c[2][2] = max(0,1) = 1
- 
- `c[2][1] = c[1,2] + 1` & `x2 == y1`
- c[2][1] = 0 + 1 = 1
- 
- `c[1][2] = max(c[0,2], c[1,1])` & `x1 != y2`
- c[1][2] = max(0,0) = 0
- 
- `c[1][1] = max(c[0,1], c[1,0])` & `x1 != y1`
- c[1][1] = 0
- 
- `c[0][1] = 0` & `x0 => i = 0 => c[0,1] = 0`
- c[0][1] = 0
- 
- `c[1][0] = 0` & `y0 => j = 0 => c[1,0] = 0`
- c[1][0] = 0
- 
- `c[0][2] = 0` & `x0 => i = 0 => c[0,2] = 0`
- c[0][2] = 0
- 
- `c[1][3] = max(c[0,3], c[1,2])` & `x1 != y3`
- c[1][3] = max(0,0) = 0
- 
- `c[0][3] = 0` & `x0 => i = 0 => c[0,3] = 0`
- c[0][3] = 0
- 
- `c[1][4] = c[0,4] + 1` & `x1 == y4`
- c[1][4] = c[0,4] + 1 = 0 + 1 = 1
- 1
- `c[0][4] = 0` & `x0 => i = 0 => c[0,4] = 0`
- c[0][4] = 0
- 
- `c[7][5] = c[6,4] + 1` & `x7 == y5`
- c[7][5] = 3 + 1 = 4
- 
- `c[6,4] = c[5,3] + 1` & `x7 == y5`
- c[6][4] = 2 + 1 = 3

    - [ ] `i = 1` ==> p[1] + r[4] = 11
    - [x] `i = 2` ==> p[2] + r[3] = 13
    - [x] `i = 3` ==> p[3] + r[2] = 13
    - [ ] `i = 4` ==> p[4] + r[1] = 10
    - [ ] `i = 5` ==> p[5] + r[0] = 10

---
## Bottom-Up Tabulation

| `i\j` | j  | 0  | 1 | 2 | 3 | 4 | 5 | 6 |
|:-----:|----|----|---|---|---|:-:|---|---|
|   i   |    | yj | B | D | C | A | B | A |
|   0   | xi | 0  | 0 | 0 | 0 | 0 | 0 | 0 |
|   1   | A  | 0  | 0 | 0 | 0 | 1 | 1 | 1 |
|   2   | B  | 0  | 1 | 1 | 1 | 1 | 2 | 2 |
|   3   | C  | 0  | 1 | 1 | 2 | 2 | 2 | 2 |
|   4   | B  | 0  | 1 | 1 | 2 | 2 | 3 | 3 |
|   5   | D  | 0  | 1 | 2 | 2 | 2 | 3 | 3 |
|   6   | A  | 0  | 1 | 2 | 2 | 3 | 3 | 4 |
|   7   | B  | 0  | 1 | 2 | 2 | 3 | 4 | 4 |