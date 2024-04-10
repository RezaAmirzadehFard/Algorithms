# Knapsack 0-1
## Problem :
>Given a 
## Recursive Formula :

### Formula :

`r[n,W] = if wn > W : r[n-1 , W]
else max(r[n-1 , W], r[n-1 , W - wn] + vn)`
        

## Top-Down :
```java
public class TopDown {

  public int topDownKnapsack(int[] v, int[] w, int kpw, int n, int[][] r) {
    if (kpw == 0 || n == 0) {
      return 0;
    }
    if (r[n][kpw] > 0) {
      return r[n][kpw];
    }
    if (w[n] > kpw) {
      int p = topDownKnapsack(v, w, kpw, n - 1, r);
      r[n][kpw] = p;
      return p;
    } else {
      int p = topDownKnapsack(v, w, kpw, n - 1, r);
      int q = topDownKnapsack(v, w, kpw - w[n], n - 1, r) + v[n];
      if (q > p) {
        r[n][kpw] = q;
        return q;
      } else {
        r[n][kpw] = p;
        return p;
      }
    }
  }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/knapsack/TopDownKnapsack.java).



## Bottom-Up :
```java
public class BottomUp {
    public static int bottomUpKnapsack(int[] w, int[] v, int kpw, int n) {
        int r[][] = new int[n + 1][kpw + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= kpw; ++j) {
                //r[i,j] => r[n,kpw]
                if (w[i] > j) {
                    r[i][j] = r[i - 1][j];
                } else {
                    int q = r[i - 1][j];
                    int p = r[i - 1][j - w[i]] + v[i];
                    if (q > p) {
                        r[i][j] = q;
                    } else {
                        r[i][j] = p;
                    }
                }
            }
        }
        return r[n][kpw];
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/knapsack/BottomUpKnapsack.java).
