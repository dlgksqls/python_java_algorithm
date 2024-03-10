n = int(input())
fibo = [0] * (100)

## 백준 제출시 순환호출로 하면 메모리 초과가 뜸... 왜 그런지 모르겠다..... vscode에서는 잘 돌아가는데.......
fibo[1] = 1
fibo[2] = 2

## 배열에 피보나치 수열 저장
for i in range(3, 100):
    fibo[i] = fibo[i-1] + fibo[i-2]

print(fibo[n])