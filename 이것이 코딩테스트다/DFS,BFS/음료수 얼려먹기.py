import sys
sys.setrecursionlimit(10**9)

def dfs(x, y):
    # 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    graph[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0<=nx<n) and (0<=ny<m):
            if graph[nx][ny] == 0:
                dfs(nx, ny)

n, m = map(int, sys.stdin.readline().split())

count = 0

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            dfs(i, j)
            count += 1

print(count)