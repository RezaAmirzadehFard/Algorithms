# Activity Selection
Scheduling several activities that require exclusive use of a common resource, with a goal of selecting a `maximum-size`
set of mutually compatible activities.

> Suppose we have a set `S = {a1, a2,...,an}`
of n proposed activities that wish to use a resource, such as a lecture hall, which
can serve only one activity at a time. Each activity `ai` has a *start time* `si` and a *finish
time* `fi`. we wish to select a maximum-size subset of mutually compatible activities

---
### Solution

- Greedy choice(local choice): select activity based on finish time.

- Algorithm:
  - *Step 1*: Sort all activity based on finish time in increasing order.
  - *Step 2*: Take activity that has the lowest finish time.
  - *Step 3*: Apply compatible rule and remove activities that have conflict with activity selected in *Step 2*.
  - *Step 4*: Iterate *Step 2* and *Step 3* until no activity remain.

---
### Example
Consider the following set `S` of activities:

| index `i`        | 1 | 2 | 3 | 4 | 5 | 6 | 7  | 8  | 9  | 10 | 11 |
|------------------|---|---|---|---|---|---|----|----|----|----|----|
| Start time `Si`  | 1 | 3 | 0 | 5 | 3 | 5 | 6  | 8  | 8  | 2  | 12 |
| Finish time `Fi` | 4 | 5 | 6 | 7 | 9 | 9 | 10 | 11 | 12 | 14 | 16 |

In Above table activities sorted based on finish time, and now we apply rest of algorithm:

- Iterate 1:
  - Select activity that have the lowest finish time : `a1`
  - Remove conflict from set: `a2`, `a3`, `a5`, `a10`


- Iterate 2:
    - Select activity that have the lowest finish time : `a4`
    - Remove conflict from set: `a6`, `a7`
  

- Iterate `3`:
    - Select activity that have the lowest finish time : `a8`
    - Remove conflict from set: `a9`


- Iterate `4`:
    - Select activity that have the lowest finish time : `a11`
    - Remove conflict from set: `no conflict`


- Set is *empty*. So result is `{a1, a4, a8, a11}`

