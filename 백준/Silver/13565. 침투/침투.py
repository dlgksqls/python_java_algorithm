import sys

sys.setrecursionlimit(100000000)

# 상하좌우
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dfs(x, y):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0 and not visited[nx][ny]:
            dfs(nx, ny)


n, m = map(int, sys.stdin.readline().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

visited = [[False] * m for i in range(n)]

for y in range(m):
    if graph[0][y] == 0 and not visited[0][y]:
        dfs(0, y)

if True in visited[n - 1]:
    print("YES")
else:
    print("NO")
