n = int(input())
fibo = [0] * (21)

fibo[0] = 0
fibo[1] = 1
fibo[2] = 1

for i in range(2, 21):
    fibo[i] = fibo[i-1] + fibo[i-2]

print(fibo[n])