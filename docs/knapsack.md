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
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/rodcut/TopDownRodCut.java).



## Bottom-Up :
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

### Example:

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
## Recursion Tree

- Recursion tree of rod with length of 4.
- parent label `s`
- child label `t`
- an edge from parent to child corresponds to cutting of an initial piece of size `s-t` and remainder of size `t`.
```mermaid
graph TD
  A((4)) --> B1((3))
  A --> B2((2))
  A --> B3((1))
  A --> B4((0))
  B1 --> C1((2))
  B1 --> C2((1))
  B1 --> C3((0))
  B2 --> C4((1))
  B2 --> C5((0))
  B3 --> C6((0))
  C1 --> D1((1))
  C1 --> D2((0))
  C2 --> D3((0))
  D1 --> E1((0))
```
## Recursion Tree of Formula

```mermaid
graph TD
  A["r[4]"] -- i = 1--> B1["p[1] + r[3]"]
  A -- i = 2 --> B2["p[2] + r[2]"]
  A -- i = 3 --> B3["p[3] + r[1]"]
  A -- i = 4 --> B4["p[4] + r[0]"]
  B1 -- i = 1 --> C1["p[1] + r[2]"]
  B1 -- i = 2 --> C2["p[2] + r[1]"]
  B1 -- i = 3 --> C3["p[3] + r[0]"]
  B2 -- i = 1 --> C4["p[1] + r[1]"]
  B2 -- i = 2 --> C5["p[2] + r[0]"]
  B3 -- i = 1 --> C6["p[1] + r[0]"]
  C1 -- i = 1 --> D1["p[1] + r[1]"]
  C1 -- i = 2 --> D2["p[2] + r[0]"]
  C2 -- i = 1 --> D3["p[1] + r[0]"]
  D1 -- i = 1 --> E1["p[1] + r[0]"]
```

## Bottom-Up Tabulation
- Each home that has non-negative value shows values of revenue.
- In each column the biggest value is maximum revenue that obtains from rod of length `j`.
- `-` this notion for infinity value or initialize value of arrays or shows that haven't valuable value.


| `i\j` | 0 | 1 | 2 | 3 |  4   |
|:-----:|---|---|---|---|:----:|
|   0   | 0 | - | - | - |  -   |
|   1   | - | 1 | 2 | 6 |  9   |
|   2   | - | - | 5 | 6 |  10  |
|   3   | - | - | - | 8 |  9   |
|   4   | - | - | - | - |  9   |