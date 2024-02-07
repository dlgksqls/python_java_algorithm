import sys
from collections import deque

def bfs(start):
    visited[start] = 1
    queue = deque([start])

    while queue:
        v = queue.popleft()

        for j in graph[v]:
            if visited[j] == 0:
                queue.append(j)
                visited[j] = 1

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

count = 0

for i in range(1, n+1):
    if visited[i] == 0:
        count += 1
        bfs(i)
print(count)