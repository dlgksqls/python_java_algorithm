import sys

sys.setrecursionlimit(1000000)

count = 1
def dfs(v):
    global count
    visited[v] = 1
    answer[v] = count
    count += 1
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
answer = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

dfs(r)

for i in range(1, len(visited)):
    if visited[i] != 0:
        print(answer[i])
    else:
        print(0)