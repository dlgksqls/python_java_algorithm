N = 1260
answer = 0

coin_list = [500,100,50,10]

for coin in coin_list:
  answer += N // coin
  N = N % coin

print(answer)