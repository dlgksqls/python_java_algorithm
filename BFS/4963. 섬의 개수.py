import sys
from collections import deque

dx = [-1, 1, 0, 0, -1, 1, 1, -1]
dy = [0, 0, -1, 1, 1, 1, -1, -1]

def bfs(x, y):
    queue = deque([(x, y)])
    graph[x][y] = 0

    while queue:
        v, z = queue.popleft()

        for i in range(8):
            nx = v + dx[i]
            ny = z + dy[i]

            if (0<=nx<h) and (0<=ny<w):
                if graph[nx][ny] == 1:
                    queue.append((nx, ny))
                    graph[nx][ny] = 0

answer = []
while True:
    w, h = map(int, sys.stdin.readline().split())
    count = 0
    if w == 0 and h == 0:
        break
    graph = []
    for _ in range(h):
        graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                count += 1
                bfs(i, j)
    answer.append(count)

for i in answer:
    print(i)