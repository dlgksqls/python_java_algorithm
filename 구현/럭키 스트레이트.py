N = input()
first = 0
second = 0

for i in range(len(N)//2): # 처음부터 중간까지
    first = first + int(N[i])
for j in range(len(N)//2,len(N)): # 중간부터 끝까지
    second = second + int(N[j])

if first == second:
    print('LUCKY')
else:
    print('READY')