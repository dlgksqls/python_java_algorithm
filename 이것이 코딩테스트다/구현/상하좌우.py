n = int(input())
moves = input()

answer = [1,1]

dx = [0,-1,0,1]
dy = [1,0,-1,0]

for move in moves:
  if move == 'L' and answer[1] != 1:
    answer[0] += dx[2]
    answer[1] += dy[2]
  elif move == 'R' and answer[1] != n:
    answer[0] += dx[0]
    answer[1] += dy[0]
  elif move == 'U' and answer[0] != 1:
    answer[0] += dx[1]
    answer[1] += dy[1]
  elif move == 'D' and answer[0] != n:
    answer[0] += dx[3]
    answer[1] += dy[3]

print(answer[0], answer[1])
  