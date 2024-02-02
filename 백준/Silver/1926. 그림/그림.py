import sys
from collections import deque

sys.setrecursionlimit(10**9)
count = 0

def dfs(x, y):
    global count
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    graph[x][y] = 0

    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]

        if (0<=nx<n) and (0<=ny<m):
            if graph[nx][ny] != 0:
                count += 1
                dfs(nx, ny)

def bfs(x, y):
    global count
    queue = deque([(x, y)])
    graph[x][y] = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        v, w = queue.popleft()

        for k in range(4):
            nx = v + dx[k]
            ny = w + dy[k]

            if (0<=nx<n) and (0<=ny<m):
                if graph[nx][ny] != 0:
                    count += 1
                    queue.append((nx, ny))
                    graph[nx][ny] = 0

n, m = map(int, sys.stdin.readline().split())

answer = []
graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

for i in range(n):
    for j in range(m):
        count = 0
        if graph[i][j] == 1:
            count += 1
            bfs(i, j)
            answer.append(count)

# for i in range(n):
#     for j in range(m):
#         count = 0
#         if graph[i][j] == 1:
#             count += 1
#             dfs(i, j)
#             answer.append(count)

if len(answer) == 0:
    print(len(answer))
    print(0)
else:
    print(len(answer))
    print(max(answer))