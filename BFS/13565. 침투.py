import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = False

def bfs(x, y):
    global answer
    queue = deque([(x, y)])
    graph[x][y] = -1

    while queue:
        v, w = queue.popleft()        
        
        for i in range(4):
            nx = dx[i] + v
            ny = dy[i] + w

            if (0<=nx<m) and (0<=ny<n):
                if graph[nx][ny] == 0:
                    queue.append((nx, ny))
                    graph[nx][ny] = -1
                    if nx == (m-1):
                        answer = True

graph = []
m, n = map(int, sys.stdin.readline().split())

for _ in range(m):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

for i in range(n):
    if graph[0][i] == 0:
        bfs(0, i)

if answer:
    print("YES")
else:
    print("NO")
