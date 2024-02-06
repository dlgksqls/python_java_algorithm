import sys
from collections import deque

def bfs(start):
    queue = deque([start])

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if visited[i] == 0:
                if i == b:
                    visited[i] = visited[v] + 1
                    break
                queue.append(i)
                visited[i] = visited[v] + 1


n = int(sys.stdin.readline())

a, b = map(int, sys.stdin.readline().split())

m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

bfs(a)

if visited[b] == 0:
    print(-1)
else:
    print(visited[b])