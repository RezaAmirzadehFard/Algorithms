# Rod Cutting

## Recursive Formula:
- `n` is length of rod
- `i` is an index that shows feasible location for cutting
- `p[]` is an array that shows price of rod without cutting
- `r[]` is an array that store maximum revenue obtains by cutting up the rod of length n

### Formula :

`r[n]= max(p[i] + r[n-i])` & `1 <= i <= n`


### Example:

#### Table of Price
| length `i` | 0 | 1 | 2 | 3 | 4 | 5  | 6  | 7  | 8  | 9  | 10 |
|------------|---|---|---|---|---|----|----|----|----|----|----|
| price `i`  | 0 | 1 | 5 | 8 | 9 | 10 | 17 | 17 | 20 | 24 | 30 |
  
- If we have a rod of length, 4 and want to cut up the rod and selling with maximum revenue or cost, we can obtain the cost with recursive formula:

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
  B1((3)) --> C1((2))
  B1 --> C2((1))
  B1 --> C3((0))
  B2 --> C4((1))
  B2 --> C5((0))
  B3 --> C6((0))
  C1((2)) --> D1((1))
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
