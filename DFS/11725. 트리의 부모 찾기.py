import sys

sys.setrecursionlimit(1000000)

def dfs(start):
    visited[start] = 1

    for i in graph[start]:
        if not visited[i]:
            answer[i] = start
            dfs(i)

n = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]

for i in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (n+1)
answer = [0] * (n+1)

dfs(1)

for i in range(2, len(answer)):
    print(answer[i])