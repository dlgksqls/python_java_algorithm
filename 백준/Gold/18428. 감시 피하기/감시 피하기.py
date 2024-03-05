from collections import deque
import sys
from itertools import combinations
from copy import deepcopy

# 상 하 좌 우
dx = [-1, 1, 0, 0, -1, 1, 1, -1]
dy = [0, 0, -1, 1, 1, 1, -1, -1]

answer = False

n = int(sys.stdin.readline())

graph = [list(sys.stdin.readline().split()) for _ in range(n)]
empty = []
teachers = []

def bfs():
    for x, y in teachers:
        for i in range(4):
            nx, ny = x, y
            while True:
                nx += dx[i]
                ny += dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= n or temp[nx][ny] == 'O':
                    break
                if temp[nx][ny] == 'S':
                    return False
    return True

for i in range(n):
    for j in range(n):
        if graph[i][j] == 'X':
            empty.append((i, j))
        elif graph[i][j] == 'T':
            teachers.append((i, j))

for data in combinations(empty, 3):
    temp = deepcopy(graph)

    for i in data:
        temp[i[0]][i[1]] = 'O'
    
    if bfs():
        print("YES")
        break
else:
    print("NO")