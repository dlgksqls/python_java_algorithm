import sys
sys.setrecursionlimit(10**9)
answer = []

def dfs(x, y):
    graph[x][y] = 0

    ## 대각선도 확인
    dx = [-1, 1, 0, 0, -1, 1, 1, -1]
    dy = [0, 0, -1, 1, 1, 1, -1, -1]

    for k in range(8):
        nx = x + dx[k]
        ny = y + dy[k]

        if (0<=nx<h) and (0<=ny<w):
            if graph[nx][ny] == 1:
                dfs(nx, ny)


while True:
    graph = []
    count = 0
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break
    else:
        for _ in range(h):
            graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

        for i in range(h):
            for j in range(w):
                if graph[i][j] == 1:

                    ## 땅이 연결되면 +1
                    count += 1
                    dfs(i, j)
    answer.append(count)

for i in answer:
    print(i)