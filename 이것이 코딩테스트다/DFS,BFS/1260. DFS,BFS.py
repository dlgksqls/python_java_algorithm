import sys
from collections import deque

def dfs(graph, start, visited):
  visited[start] = True
  print(start, end=' ')
  for i in range(1, n+1):
    if graph[start][i] == True and visited[i] == False:
      dfs(graph, i, visited)

def bfs(graph, start, visited):
  queue = deque([start])
  visited[start] = True

  while queue:
    v = queue.popleft()
    print(v, end=' ')

    for i in range(1, n+1):
      if graph[v][i] == True and visited[i] == False:
        queue.append(i)
        visited[i] = True
        
### main ###
n,m,v = map(int,input().split())
graph = [[False]*(n+1) for _ in range(n+1)]

for i in range(m):
  a,b = map(int, sys.stdin.readline().split())
  graph[a][b] = True
  graph[b][a] = True

visit_dfs = [False] * (n+1)
visit_bfs = [False] * (n+1)

dfs(graph, v, visit_bfs)
print()
bfs(graph, v, visit_dfs)
