n = int(input()) # 크기
k = int(input()) # 사과 위치

##### input() 을 가지고 graph 그리기 #####################
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

#######################################################

# 동 남 서 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

answer = 0
next_move = 0
x, y = 1, 1
index = 0
q = [(x, y)]

while True:

    # 다음 위치로 이동 변수 저장
    nx = x + dx[next_move] 
    ny = y + dy[next_move]

    # 그래프를 나가지 않고, 가보지 않은 땅이라면 이동
    if 1<=nx and nx<=n and ny<=n and ny>=1 and graph[nx][ny] != 2:
        # 가볼 땅이 먹이가 없으면 이동한 후 이전에 있던 땅 미방문 처리
        if graph[nx][ny] == 0:
            graph[nx][ny] = 2
            q.append((nx, ny))
            px, py = q.pop(0)
            graph[px][py] = 0
        # 먹이가 있으면 그냥 이동
        if graph[nx][ny] == 1:
            graph[nx][ny] = 2
            q.append((nx, ny))
    else:
        # 가볼 수 없는 땅이라면 시간 추가 후 나오기
        answer += 1
        break

    # 이동한 후 시간 추가
    x,y = nx,ny
    answer += 1

    # 다른 땅으로 가기위해 방향 전환
    if index < l and answer == move_dir[index][0]:
        if answer == move_dir[index][0]:
            if move_dir[index][1] == "L":
                next_move = (next_move - 1) % 4
            elif move_dir[index][1] == "D":
                next_move = (next_move + 1) % 4
            index += 1

print(answer)