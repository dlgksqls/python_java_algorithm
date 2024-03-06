import sys

n = int(input())

data = [int(house) for house in sys.stdin.readline().split()]
# data.append((int(sys.stdin.readline().split())))

data.sort()

print(data[((n-1)//2)])