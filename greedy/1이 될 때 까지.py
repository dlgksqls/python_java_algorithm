n,k = map(int,input().split())

count = 0

while n != 1:
    if n % k == 0 and k != 1:
        n = n/k
        count = count+1
        print(f'{count} : 나누기 연산',n)
    else:
        n = n-1
        count = count+1
        print(f'{count} : 빼기 연산',n)
print("총 결과: ",count)