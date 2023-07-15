N = int(input())
coin = list(map(int,input().split()))
#coin_sum = []
#sum = 0
#result=0
#
#coin.sort()
#
#for i in range(len(coin)):
#  if i == 0 and coin[0] < 2:
#    coin_sum.append(coin[i])
#  elif coin[0] > 1:
#    result = 1
#  else:
#    for j in range(i):
#      sum = coin_sum[j] + coin[i]
#      coin_sum.append(sum)
#print(coin_sum)

result = 1

for i in coin:
  if result < i:
    break
  result = result + i

print(result)