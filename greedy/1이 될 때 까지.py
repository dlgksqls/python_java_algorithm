# n,k를 입력받음
# n을 k로 나누었을때 나누어 떨어지면 n/k 연산
# 그렇지 않다면 n을 -1 함
# 그렇게 해서 n의 값이 1이 될때까지.... 출력 결과는 연산 횟수
# 입력 n = 25, k = 5 // 출력 2

n,k = map(int,input().split())

count = 0

while n != 1: 
    if n % k == 0 and k != 1:
        n = n/k
        count = count+1
        print(f'{count} : 나누기 연산 n = {n}')
    else:
        n = n-1
        count = count+1
        print(f'{count} : 빼기 연산 n = {n}')
print("총 결과: ",count)