n = int(input())
k = list(map(int,input().split()))

array = [0] * 100
array[0] = k[0]
array[1] = max(k[0], k[1])

for i in range(2, n):
    array[i] = max(array[i-1], array[i-2] + k[i])

print(array[n-1])