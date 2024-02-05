import sys
from collections import deque

count = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    global count
    queue = deque([(x, y)])
    graph[x][y] = 0

    while queue:
        w, h = queue.popleft()
        for i in range(4):
            nx = dx[i] + w
            ny = dy[i] + h

            if (0<=nx<n) and (0<=ny<m):
                if graph[nx][ny] == 1:
                    count += 1
                    graph[nx][ny] = 0
                    queue.append((nx,ny))

n, m = map(int, sys.stdin.readline().split())

graph = []
answer = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    for j in range(m):
        count = 0
        if graph[i][j] == 1:
            count += 1
            bfs(i, j)
            answer.append(count)

if len(answer) == 0:
    print(len(answer))
    print(0)
else:
    print(len(answer))
    print(max(answer))