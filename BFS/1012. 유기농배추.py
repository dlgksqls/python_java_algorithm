import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque([(x, y)])
    graph[x][y] = False

    while queue:
        v, w = queue.popleft()

        for i in range(4):
            nx = v + dx[i]
            ny = w + dy[i]

            if (0<=nx<n) and (0<=ny<m):
                if graph[nx][ny]:
                    graph[nx][ny] = False
                    queue.append([nx, ny]) 

t = int(sys.stdin.readline())
answers = []

for _ in range(t):
    count = 0
    m, n, k = map(int, sys.stdin.readline().split())
    graph = [[False for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        a, b = map(int, sys.stdin.readline().split())
        graph[b][a] = True

    for i in range(n):
        for j in range(m):
            if graph[i][j] == True:
                count += 1
                bfs(i, j)
    answers.append(count)

for answer in answers:
    print(answer)