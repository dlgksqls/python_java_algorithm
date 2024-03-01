import sys
from collections import deque

def bfs(graph, start, distance, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                distance[i] = distance[v] + 1
                queue.append(i)
                visited[i] = True

n, m, k, x = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
distance = [-1 for _ in range(n+1)]
visited = [False for _ in range(n+1)]
distance[x] = 0

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

bfs(graph, x, distance, visited)

if k in distance:
    for i in range(1, n+1):
        if distance[i] == k:
            print(i)
else:
    print(-1)
