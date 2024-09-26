# Optimal Binary Search Tree
## Problem :

## Recursive Formula :

### Formula :



## Top-Down :
```java
public class TopDown {
    public static double topDownOptimalBinarySearchTree(double[] p, int i, int j, double[][] r){
        if (i == j){
            return p[i];
        } else if (i > j){
            return 0;
        }

        if (r[i][j] > 0){
            return r[i][j];
        }

        double min = Double.MAX_VALUE;
        for (int t = i; t <= j; t++){
            double q = topDownOptimalBinarySearchTree(p, i, t - 1, r) + topDownOptimalBinarySearchTree(p, t + 1, j, r) + sumProbabilities(p,i,j);

            if (q < min){
                min = q;
            }
        }
        r[i][j] = min;
        return min;
    }

    public static double sumProbabilities(double[] p, int s, int e){
        double sum = 0;
        for (int i = s; i <= e; i++){
            sum += p[i];
        }
        return sum;
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/optimalbinarysearchtree/TopDownOBST.java).



## Bottom-Up :
```java
public class BottomUp {
    public static double[][] bottomUpOptimalBinarySearchTree(double[] p){
        int n = p.length - 1;
        double[][] r = new double[n + 2][n + 1];

        for (int i = 0; i <= n; i++) {
            r[i][i] = p[i];
        }

        for (int l = 2; l <= n; l++){
            double min = Double.MAX_VALUE;
            for (int i = 1; i <= n - l + 1; i ++){
                int j = i + l - 1;
                for (int t = i; t <= j; t++){
                    double q = r[i][t - 1] + r[t + 1][j] + sumProbabilities(p, i, j);
                    if (q < min){
                        min = q;
                    }
                }
                r[i][j] = min;
            }
        }
        return r;
    }

    public static double sumProbabilities(double[] p, int s, int e){
        double sum = 0;
        for (int i = s; i <= e; i++){
            sum += p[i];
        }
        return sum;
    }
}
```
> You need a find maximum method to above code works well. For complete code, details and other forms [click](src/dynamicProgarmming/optimalbinarysearchtree/BottomUpOBST.java).

---

### Time Complexity:

#### Bruteforce

#### Dynamic Programming

##### Top-Down

##### Bottom-Up

---

### Time Complexity:

---
### Example:


---
## Recursion Tree

## Recursion Tree of Formula


## Bottom-Up Tabulation
