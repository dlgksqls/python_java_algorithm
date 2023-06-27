n,m,k = map(int,input().split())

number = []
sum = 0

for i in range(0,n):
    num = int(input())
    number.append(num)

number.sort(reverse=True)

i = 0

while i < m:
    for j in range(0,k):
        i = i + 1
        if i < m:
            sum = sum + number[0]
    i = i + 1
    sum = sum + number[1]
    
print(sum)

