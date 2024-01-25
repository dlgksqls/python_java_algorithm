import sys
from collections import deque
sys.setrecursionlimit(1000000)

def dfs(start):
    visited_dfs[start] = 1
    print(start, end = ' ')

    for j in graph[start]:
        if not visited_dfs[j]:
            dfs(j)

def bfs(start):
    queue = deque([start])
    visited_bfs[start] = 1

    while queue:
        v = queue.popleft()
        print(v, end=' ')

        for i in graph[v]:
            if not visited_bfs[i]:
                queue.append(i)
                visited_bfs[i] = 1

n, m, v = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]
visited_dfs = [0] * (n+1)
visited_bfs = [0] * (n+1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

dfs(v)
print()
bfs(v)
