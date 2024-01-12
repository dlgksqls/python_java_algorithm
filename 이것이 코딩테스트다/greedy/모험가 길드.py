N = map(int,input())
fears = list(map(int,input().split()))
fears.sort()
answer = 0
count = 1

for fear in fears:
  if fear <= count:
    answer += 1
    count = 1
  else:
    count += 1

print(answer)