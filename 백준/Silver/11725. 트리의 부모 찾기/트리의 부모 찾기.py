import sys
from collections import deque

def bfs(start):
    queue = deque([start])
    visited[start] = 1

    while queue:
        v = queue.popleft()
        
        for i in graph[v]:
            if visited[i] == 0:
                answer[i] = v
                queue.append(i)
                visited[i] = 1

n = int(sys.stdin.readline())

answer = [0] * (n+1)
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)

for i in range(2, len(answer)):
    print(answer[i])