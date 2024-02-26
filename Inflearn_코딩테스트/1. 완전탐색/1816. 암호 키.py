n = int(input())

for i in range(n):
    flag = False
    s = int(input())

    for j in range(2, 1000001):
        if s % j == 0: # 100만 이하의 약수가 존재
            print("NO")
            break
        if j == 1000000: 
            print("YES")