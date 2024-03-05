from collections import deque
import sys
from itertools import combinations
from copy import deepcopy

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = False

n = int(sys.stdin.readline())

graph = [list(sys.stdin.readline().split()) for _ in range(n)]
empty = []
teachers = []

## bfs보단 탐색으로....? 하면 쉬울듯
def bfs():
    for x, y in teachers: # 선생님이 있는 좌표 담은 리스트 하나씩...
        for i in range(4):
            nx, ny = x, y 
            while True: # 그래프 끝까지 가지 않거나, 벽을 만나지 않는다면 계속 한 뱡향 앞으로 
                nx += dx[i]
                ny += dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= n or temp[nx][ny] == 'O':
                    break
                if temp[nx][ny] == 'S': # 학생을 만난다면 false 반환
                    return False
    return True

for i in range(n):
    for j in range(n):
        if graph[i][j] == 'X': # 비어있는 곳 좌표 추가
            empty.append((i, j))
        elif graph[i][j] == 'T':  # 선생님이 있는 곳 좌표 추가
            teachers.append((i, j))

for data in combinations(empty, 3): # 조합으로 장애물 3개 세우기
    temp = deepcopy(graph)

    for i in data:
        temp[i[0]][i[1]] = 'O'
    
    if bfs():
        print("YES")
        break
else:
    print("NO")