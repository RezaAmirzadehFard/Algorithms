# Matrix Chain Multiplication
## Problem :
 >Given a chain `<A1, A2,...,An>` of `n` matrices, where `for i = 1, 2,...,n`, matrix `Ai` has dimension `pi-1 * pi`, fully parenthesize the product `A1A2...An` in way that **minimize** the number of scalar multiplications.

> The goal of the problem is that to find a way to parenthesize the sequence of matrices that yields the lowest cost. 
## Recursive Formula :

- `p[]` is an array that store dimension of the matrix chain
- `m[][]` is an array that saves minimum cost of the scalar multiplication of sequence `<Ai,Ai+1,...,Aj>`
- if `i == j`, then `m[i,j] = 0`

### Formula :

`m[i,j] = min(m[i,k] + m[k+1,j] + p[i-1] * p[k] * p[j])` & `i <= k < j`


## Top-Down :

```java
public class TopDown {
    public int topDownMatrixProduct(int[] p, int i, int j, int[][] m) {
        if (i >= j) {
            return 0;
        }
        if (m[i][j] > 0) {
            return m[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int q = topDownMatrixProduct(p, i, k, m) + topDownMatrixProduct(p, k + 1, j, m) + (p[i - 1] * p[k] * p[j]);
            if (q < min) {
                min = q;
            }
        }
        m[i][j] = min;
        return min;
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](dynamicProgarmming/rodcut/TopDownRodCut.java).

## Bottom-Up :

```java
public class BottomUp {
  public static int[][] matrixChainOrder(int[] p) {
    int n = p.length - 1;       // because p have indices of 0,1,...,n-1,n => length of p is n+1
    int[][] m = new int[n + 1][n + 1];
    int[][] s = new int[n + 1][n + 1];

    for (int i = 0; i < n; i++) { // the minimum cost for sequences with size of one
      m[i][i] = 0;
    }

    for (int l = 2; l <= n; l++) { // is the chain length
      for (int i = 1; i <= n - l + 1; i++) { // [1]*
        int j = l + i - 1;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) { // find best k for range between i, j (k: is the last position that multiply occurs between two matrices
          int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (q < min) {
            min = q;
            s[i][j] = k;
          }
        }
        m[i][j] = min;
      }
    }
    return m;
  }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](dynamicProgarmming/rodcut/BottomUpRodCut.java).


## Time Complexity:
- O(n^3)

### Example:

#### Given Matrix Table
| Matrix    | A1      | A2      | A3     | A4     | A5      | A6      |
|-----------|---------|---------|--------|--------|---------|---------|
| dimension | 30 * 35 | 35 * 15 | 15 * 5 | 5 * 10 | 10 * 20 | 20 * 25 |
 
- We store Dimension of matrices in a `p[]` array.
- Denote dimension of matrix `Ai` with `p[i-1]` and `p[i]`. `p[i-1]` and `p[i]` store inorder row and column of matrix `Ai`.
- #### Matrix Dimension Array:
| pi     | 0  | 1  | 2  | 3 | 4  | 5   | 6  |
|--------|----|----|----|---|----|-----|----|
| values | 30 | 35 | 15 | 5 | 10 | 20  | 25 |

- If we have a chain of matrices <A1, A2, A3, A4, A5, A6>  with dimensions that are shown in the Matrix Table, we want to fully parenthesize the product A1A2...A6 in a way that minimizes the number of scalar multiplications, we can obtain the cost with recursive formula:

- chain <A1, A2, A3, A4, A5, A6> with length of 6:


- `m[1,6] = min(m[1,k] + m[k+1,6] + p[0] * p[k] * p[6])` & `1 <= k < 6`

    - [ ] `k = 1` ==> m[1,1] + m[2,6] + p[0] * p[1] * p[6] = 0     + 10500 + 30 * 35 * 25 = 36750 
    - [ ] `k = 2` ==> m[1,2] + m[3,6] + p[0] * p[2] * p[6] = 15750 + 5375  + 30 * 15 * 25 = 32375
    - [x] `k = 3` ==> m[1,3] + m[4,6] + p[0] * p[3] * p[6] = 7875  + 3500  + 30 * 5  * 25 = 15125
    - [ ] `k = 4` ==> m[1,4] + m[5,6] + p[0] * p[4] * p[6] = 9375  + 5000  + 30 * 10 * 25 = 21875
    - [ ] `k = 5` ==> m[1,5] + m[6,6] + p[0] * p[5] * p[6] = 11875 + 0     + 30 * 20 * 25 = 26875


- `m[2,6] = min(m[2,k] + m[k+1,6] + p[1] * p[k] * p[6])` & `2 <= k < 6`

  - [ ] `k = 2` ==> m[2,2] + m[3,6] + p[1] * p[2] * p[6] = 0    + 5375 + 35 * 15 * 25 = 18500
  - [x] `k = 3` ==> m[2,3] + m[4,6] + p[1] * p[3] * p[6] = 2625 + 3500 + 35 * 5  * 25 = 10500
  - [ ] `k = 4` ==> m[2,4] + m[5,6] + p[1] * p[4] * p[6] = 4375 + 5000 + 35 * 10 * 25 = 18125
  - [ ] `k = 5` ==> m[2,5] + m[6,6] + p[1] * p[5] * p[6] = 7125 + 0  + 35 * 20 * 25 = 24625


- `m[3,6] = min(m[3,k] + m[k+1,6] + p[2] * p[k] * p[6])` & `3 <= k < 6`

    - [x] `k = 3` ==> m[3,3] + m[4,6] + p[2] * p[3] * p[6] = 0    + 3500 + 15 * 5  * 25 = 5375
    - [ ] `k = 4` ==> m[3,4] + m[5,6] + p[2] * p[4] * p[6] = 750  + 5000 + 15 * 10 * 25 = 9500
    - [ ] `k = 5` ==> m[3,5] + m[6,6] + p[2] * p[5] * p[6] = 2500 + 0    + 15 * 20 * 25 = 10000


- `m[4,6] = min(m[4,k] + m[k+1,6] + p[3] * p[k] * p[6])` & `4 <= k < 6`

    - [ ] `k = 4` ==> m[4,4] + m[5,6] + p[3] * p[4] * p[6] = 0    + 5000 + 5 * 10 * 25 = 6250
    - [x] `k = 5` ==> m[4,5] + m[6,6] + p[3] * p[5] * p[6] = 1000 + 0    + 5 * 20 * 25 = 3500


- `m[5,6] = min(m[5,k] + m[k+1,6] + p[1] * p[k] * p[6])` & `5 <= k < 6`

    - [x] `k = 5` ==> m[5,5] + m[6,6] + p[4] * p[5] * p[6] = 0 + 0 + 10 * 20 * 25 = 5000


- `m[4,5] = min(m[4,k] + m[k+1,5] + p[3] * p[k] * p[5])` & `4 <= k < 5`

  - [x] `k = 4` ==> m[4,4] + m[5,5] + p[3] * p[4] * p[5] = 0 + 0 + 5 * 10 * 20 = 1000


- `m[3,4] = min(m[3,k] + m[k+1,4] + p[2] * p[k] * p[4])` & `3 <= k < 4`

  - [x] `k = 3` ==> m[3,3] + m[4,4] + p[2] * p[3] * p[4] = 0 + 0 + 15 * 5 * 10 = 750


- `m[3,5] = min(m[3,k] + m[k+1,5] + p[2] * p[k] * p[5])` & `3 <= k < 5`

    - [x] `k = 3` ==> m[3,3] + m[4,5] + p[2] * p[3] * p[5] = 0 + 1000 + 15 * 5 * 20 = 2500
    - [ ] `k = 4` ==> m[3,4] + m[5,5] + p[2] * p[4] * p[5] = 750 + 0 + 15 * 10 * 20 = 3750


- `m[2,3] = min(m[2,k] + m[k+1,3] + p[1] * p[k] * p[3])` & `2 <= k < 3`

    - [x] `k = 2` ==> m[2,2] + m[3,3] + p[1] * p[2] * p[3] = 0 + 0 + 35 * 15 * 5 = 2625


- `m[2,4] = min(m[2,k] + m[k+1,4] + p[1] * p[k] * p[4])` & `2 <= k < 4`

    - [ ] `k = 2` ==> m[2,2] + m[3,4] + p[1] * p[2] * p[4] = 0 + 750 + 35 * 15 * 10 = 6000
    - [x] `k = 3` ==> m[2,3] + m[4,4] + p[1] * p[3] * p[4] = 2625 + 0 + 35 * 5 * 10 = 4375


- `m[2,5] = min(m[2,k] + m[k+1,5] + p[1] * p[k] * p[5])` & `2 <= k < 5`

    - [ ] `k = 2` ==> m[2,2] + m[3,5] + p[1] * p[2] * p[5] = 0 + 2500 + 35 * 15 * 20 = 13000
    - [x] `k = 3` ==> m[2,3] + m[4,5] + p[1] * p[3] * p[5] = 2625 + 1000 + 35 * 5 * 20 = 7125
    - [ ] `k = 4` ==> m[2,4] + m[5,5] + p[1] * p[4] * p[5] = 4375 + 0 + 35 * 10 * 20 = 11375


- `m[1,2] = min(m[1,k] + m[k+1,2] + p[0] * p[k] * p[2])` & `1 <= k < 2`

    - [x] `k = 1` ==> m[1,1] + m[2,2] + p[0] * p[1] * p[2] = 0 + 0 + 30 * 35 * 15 = 15750 


- `m[1,3] = min(m[1,k] + m[k+1,3] + p[0] * p[k] * p[3])` & `1 <= k < 3`

    - [x] `k = 1` ==> m[1,1] + m[2,3] + p[0] * p[1] * p[3] = 0 + 2625 + 30 * 35 * 5 = 7875
    - [ ] `k = 2` ==> m[1,2] + m[3,3] + p[0] * p[2] * p[3] = 15750 + 0 + 30 * 15 * 5 = 18000


- `m[1,4] = min(m[1,k] + m[k+1,4] + p[0] * p[k] * p[4])` & `1 <= k < 4`

    - [ ] `k = 1` ==> m[1,1] + m[2,4] + p[0] * p[1] * p[4] = 0 + 4375 + 30 * 35 * 10 = 14875
    - [ ] `k = 2` ==> m[1,2] + m[3,4] + p[0] * p[2] * p[4] = 15750 + 750 + 30 * 15 * 10 = 21000
    - [x] `k = 3` ==> m[1,3] + m[4,4] + p[0] * p[3] * p[4] = 7875 + 0 + 30 * 5 * 10 = 9375


- `m[1,5] = min(m[1,k] + m[k+1,5] + p[0] * p[k] * p[5])` & `1 <= k < 5`

    - [ ] `k = 1` ==> m[1,1] + m[2,5] + p[0] * p[1] * p[5] = 0 + 7125 + 30 * 35 * 20 = 28125
    - [ ] `k = 2` ==> m[1,2] + m[3,5] + p[0] * p[2] * p[5] = 15750 + 2500 + 30 * 15 * 20 = 27250
    - [x] `k = 3` ==> m[1,3] + m[4,5] + p[0] * p[3] * p[5] = 7875 + 1000 + 30 * 5 * 20 = 11875
    - [ ] `k = 4` ==> m[1,4] + m[5,5] + p[0] * p[4] * p[5] = 9375 + 0 + 30 * 10 * 20 = 15375


> Result of fully parenthesize:  `((A1) * ( (A2) * (A3) ) ) * (( (A4) * (A5)) * A6)`
---

## Bottom-Up Tabulation

- Table of minimum number of scalar multiplications:
  - The minimum number of scalar multiplications to multiply the 6 matrices is `m[1,6] = 15125`

| `i\j` | j       | 1  | 2     | 3    |  4   | 5     | 6     |
|:-----:|---------|----|-------|------|:----:|-------|-------|
|   i   | `Ai\Aj` | A1 | A2    | A3   |  A4  | A5    | A6    |
|   1   | A1      | 0  | 15750 | 7875 | 9375 | 11875 | 15125 |
|   2   | A2      | -  | 0     | 2625 | 4375 | 7125  | 10500 |
|   3   | A3      | -  | -     | 0    | 750  | 2500  | 5375  |
|   4   | A4      | -  | -     | -    |  0   | 1000  | 3500  |
|   5   | A5      | -  | -     | -    |  -   | 0     | 5000  |
|   6   | A6      | -  | -     | -    |  -   | -     | 0     |

- Table of last multiply position between two subproblems:

| `i\j` | j       | 1  | 2  | 3  | 4  | 5  | 6  |
|:-----:|---------|----|----|----|:--:|----|----|
|   i   | `Ai\Aj` | A1 | A2 | A3 | A4 | A5 | A6 |
|   1   | A1      | 0  | 1  | 1  | 3  | 3  | 3  |
|   2   | A2      | -  | 0  | 2  | 3  | 3  | 3  |
|   3   | A3      | -  | -  | 0  | 3  | 3  | 3  |
|   4   | A4      | -  | -  | -  | 0  | 4  | 5  |
|   5   | A5      | -  | -  | -  | -  | 0  | 5  |
|   6   | A6      | -  | -  | -  | -  | -  | 0  |

