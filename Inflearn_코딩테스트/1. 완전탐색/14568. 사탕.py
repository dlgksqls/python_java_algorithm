n = int(input())

answer = 0

for A in range(1, n+1):
    for B in range(1, n+1):
        for C in range(1, n+1):
            if n == A+B+C:
                if A >= B+2:
                    if C % 2 == 0:
                        answer+=1

print(answer)