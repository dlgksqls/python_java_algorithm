import sys

answer = 0

def dfs(graph, start, visited):

  global answer
  
  visited[start] = True

  for i in range(1, coms+1):
    if graph[start][i] == True and visited[i] == False:
      answer += 1
      dfs(graph, i, visited)
      

coms = int(input())
ssang = int(input())

graph = [[False]*(coms+1) for _ in range(coms+1)]

for i in range(ssang):
  a,b = map(int, sys.stdin.readline().split())
  graph[a][b] = True
  graph[b][a] = True

visited = [False] * (coms+1)

dfs(graph, 1, visited)

print(answer)

