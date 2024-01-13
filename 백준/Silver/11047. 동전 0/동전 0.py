n, k = map(int, input().split())
coins = []
answer = 0

for i in range(n):
    coin = int(input())
    coins.append(coin)

coins.sort(reverse=True)

for coin in coins:
    if k == 0:
        break
    else:
        while True:
            if k >= coin:
                k -= coin
                answer += 1
            else:
                break

print(answer)
