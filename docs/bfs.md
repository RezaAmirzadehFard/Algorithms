# Breadth-first search

> Given a graph G = (V, E) and a distinguished source vertex `s`, breadth-first search systematically explores the edges of `G` to `dicover` every vertex that is reachable from `s`.

- BFS: 
  - Compute distance (smallest number of edges) from `s` to each reachable vertex.
  - Produce a `breadth-first tree` with root `s` that contains all reachable vertices.

- BFS algorithm works on both directed and undirected graphs.
- Breadth-first search is so named because the algorithm discovers all vertices at distance `k` from `s` before discovering any vertices at distance `k+1`.

### Analysis:

  