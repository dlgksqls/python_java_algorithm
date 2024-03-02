import sys
from collections import deque

# 입력
n, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
s, x, y = map(int, sys.stdin.readline().split())

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 모든 바이러스 정보를 담는 리스트
viruses = []
for i in range(n):
    for j in range(n):
        if graph[i][j] != 0:
            # 바이러스 종류, 시간, 위치 X, 위치 Y를 추가
            viruses.append((graph[i][j], 0, i, j))

# 낮은 번호의 바이러스가 먼저 증식되도록 정렬
viruses.sort()
queue = deque(viruses)

while queue:
    virus, time, vx, vy = queue.popleft()
    if time == s:
        break
    for i in range(4):
        nx = vx + dx[i]
        ny = vy + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                queue.append((virus, time + 1, nx, ny))

print(graph[x-1][y-1])