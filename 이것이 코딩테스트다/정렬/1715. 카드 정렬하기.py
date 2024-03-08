import sys

#### 잘못된 풀이

# n = int(sys.stdin.readline())

# card = [int(sys.stdin.readline()) for _ in range(n)]

# card.sort()

# for i in range(len(card)-1):
#     if i == 0: 
#         temp = card[i] + card[i+1]
#     else:
#         temp += temp + card[i+1]
# print(temp)

import heapq

n = int(sys.stdin.readline())

heap = []
result = 0

for i in range(n):
    data = int(sys.stdin.readline())
    heapq.heappush(heap, data)

while len(heap) != 1:
    first = heapq.heappop(heap)
    second = heapq.heappop(heap)

    sum = first + second

    result += sum
    heapq.heappush(heap, sum)

print(result)
