import sys
sys.setrecursionlimit(10**9)
answer = "Hing"

def dfs(x, y):
    global answer
    if graph[x][y] == -1:
        answer = "HaruHaru"
        return
    cur = graph[x][y]
    graph[x][y] = False

    # 우, 하
    dx = [0, cur]
    dy = [cur, 0]

    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0<=nx<n) and (0<=ny<n):
            if graph[nx][ny]:
                dfs(nx, ny)

n = int(sys.stdin.readline())

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

dfs(0,0)

print(answer)