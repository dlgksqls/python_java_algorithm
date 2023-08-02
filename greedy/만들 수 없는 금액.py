N = int(input())
coin = list(map(int,input().split()))
result = 0
coin.sort()

for i in coin:
  if result < i:
    break
  result = result + i

print(result)