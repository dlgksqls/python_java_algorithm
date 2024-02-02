import sys
from collections import deque

def bfs(x, y):
    dx_ = [0, 0]
    dy_ = [-1, 1]

    dx = [-1, 1]
    dy = [0, 0]

    queue = deque([(x, y)])

    while queue:
        w, h = queue.popleft()

        if graph[w][h] == '-':
            graph[w][h] = 0
            for i in range(2):
                nx = w + dx_[i]
                ny = h + dy_[i]

                if (0<=nx<n) and (0<=ny<m):
                    if graph[nx][ny] != 0 and graph[nx][ny] == '-':
                        queue.append((nx, ny))
        elif graph[w][h] == '|':
            graph[w][h] = 0
            for i in range(2):
                nx = w + dx[i]
                ny = h + dy[i]

                if (0<=nx<n) and (0<=ny<m):
                    if graph[nx][ny] != 0 and graph[nx][ny] == '|':
                        queue.append((nx, ny))

n, m = map(int, sys.stdin.readline().split())
graph = []
count = 0

for _ in range(n):
    graph.append(list(sys.stdin.readline().rstrip()))

for i in range(n):
    for j in range(m):
        if graph[i][j] != 0:
            count += 1
            bfs(i, j)

print(count)