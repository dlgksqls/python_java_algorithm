# n,m,k 입력받음
# n은 받을 수 있는 숫자 갯수, m은 총 더하는 횟수, k는 같은 배열의 수를 최대로 더할 수 있는 횟수
# n=5,m=8,k=3 [2,4,5,4,6] => 6+6+6+5+6+6+6+5 = 46

n,m,k = map(int,input().split())

number = [] 
sum = 0

for i in range(0,n): # n만큼 숫자 받아서 배열 생성
    num = int(input())
    number.append(num)

number.sort(reverse=True) # 내림차순으로 정렬

i = 0 # i는 더하기 연산 횟수

while i < m: # 최대 연산횟수보다 작으면 반복문
    for j in range(0,k): # k번 가장 큰 수 덧셈 연산 시작
        i = i + 1 # 연산 횟수 증가
        if i < m:
            sum = sum + number[0]
    i = i + 1 # 반복문 나와서 그 다음 큰 수 덧셈
    sum = sum + number[1]
    
print(sum)

