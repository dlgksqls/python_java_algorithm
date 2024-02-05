import sys
from collections import deque
count = 0 

def bfs(start):
    global count

    queue = deque([start])
    visited[start] = 1

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] != 1:
                count += 1
                queue.append(i)
                visited[i] = 1

n = int(sys.stdin.readline())

m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]
visited = [0]* (n + 1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)

print(count)