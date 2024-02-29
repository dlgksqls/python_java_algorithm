n = int(input()) # 크기
k = int(input()) # 사과 위치

apple_dir = []
for _ in range(k):
    x, y = map(int, input().split())
    apple_dir.append([x, y])

l = int(input())

move_dir = []
for _ in range(l):
    x, y = input().split()
    move_dir.append([x, y])

for i in range(len(move_dir)):
    move_dir[i][0] = int(move_dir[i][0])

graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
graph[1][1] = 2

for i in range(len(apple_dir)):
    graph[apple_dir[i][0]][apple_dir[i][1]] = 1

# 동 남 서 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

answer = 0
next_move = 0
x, y = 1, 1
index = 0
q = [(x, y)]

while True:

    nx = x + dx[next_move]
    ny = y + dy[next_move]

    if 1<=nx and nx<=n and ny<=n and ny>=1 and graph[nx][ny] != 2:
        if graph[nx][ny] == 0:
            graph[nx][ny] = 2
            q.append((nx, ny))
            px, py = q.pop(0)
            graph[px][py] = 0
        if graph[nx][ny] == 1:
            graph[nx][ny] = 2
            q.append((nx, ny))
    else:
        answer += 1
        break
    
    x,y = nx,ny
    answer += 1
    if index < l and answer == move_dir[index][0]:
        if answer == move_dir[index][0]:
            if move_dir[index][1] == "L":
                next_move = (next_move - 1) % 4
            elif move_dir[index][1] == "D":
                next_move = (next_move + 1) % 4
            index += 1

print(answer)