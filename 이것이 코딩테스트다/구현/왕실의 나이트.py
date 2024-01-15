now = input()

col = ord(now[0])
row = int(now[1])
answer = 0


steps = [(1,2), (-1,2), (-2,1), (-2,-1), (1,-2), (-1,-2), (2,1), (2,-1)]

for step in steps:
  move_col = col + step[0]
  move_row = row + step[1]

  if move_col < 97 or move_col > 104 or move_row < 1 or move_row > 8:
    continue
  else:
    answer += 1

print(answer)