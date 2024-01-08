# Breadth-first search

> Given a graph G = (V, E) and a distinguished source vertex `s`, breadth-first search systematically explores the edges of `G` to `dicover` every vertex that is reachable from `s`.

- BFS: 
  - Compute distance (smallest number of edges) from `s` to each reachable vertex.
  - Produce a `breadth-first tree` with root `s` that contains all reachable vertices.

- BFS algorithm works on both directed and undirected graphs.
- Breadth-first search is so named because the algorithm discovers all vertices at distance `k` from `s` before discovering any vertices at distance `k+1`.
- The result of breadth-first search may depend upon the order in which the neighbors of a given vertex are visited; the breadth-first tree may vary, but the distance `d` computed by the algorithm will not.

## Analysis:
O (V + E)

  