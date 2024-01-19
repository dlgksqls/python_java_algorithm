import sys
from collections import deque

# 동, 북, 서, 남
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

def bfs(graph, a, b):
  length = len(graph)
  queue = deque()
  queue.append((a,b))
  graph[a][b] = 0
  count = 1

  while queue:
      x,y = queue.popleft()
      for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx < 0 or nx >= length or ny < 0 or ny >= length:
           continue
        if graph[nx][ny] == 1:
           graph[nx][ny] = 0
           queue.append((nx, ny))
           count += 1
  return count

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

cnt = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            cnt.append(bfs(graph, i, j))

cnt.sort()
print(len(cnt))
for i in cnt:
   print(i)