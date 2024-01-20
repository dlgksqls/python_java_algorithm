## 인접 행렬은 값이 너무 많아질 경우 시간초과 뜸

# import sys
# sys.setrecursionlimit(100000)

# def dfs(graph, start, visited):

#   visited[start] = True
#   for i in range(1, n+1):
#     if graph[start][i] == True and visited[i] == False:
#       dfs(graph, i, visited)

# n,m = map(int,input().split())
# answer = 0

# graph = [[False] * (n+1) for _ in range(n+1)]

# for i in range(1, m+1):
#   a, b = map(int,input().split())
#   graph[a][b] = True
#   graph[b][a] = True

# visited = [False] * (n+1)

# for i in range(1, n+1):
#   if visited[i] == False:
#     dfs(graph, i, visited)
#     answer += 1

# print(answer)

# 인접 리스트로 풀기

import sys

sys.setrecursionlimit(10000)

def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
count = 0

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    if not visited[i]:
        dfs(i)
        count += 1

print(count)
