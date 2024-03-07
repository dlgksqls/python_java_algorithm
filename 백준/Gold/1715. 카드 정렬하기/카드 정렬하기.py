import heapq
import sys

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