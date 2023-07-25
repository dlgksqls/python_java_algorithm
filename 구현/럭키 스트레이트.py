N = input()
first = 0
second = 0

for i in range(len(N)//2):
    first = first + int(N[i])
for j in range(len(N)//2,len(N)):
    second = second + int(N[j])

if first == second:
    print('LUCKY')
else:
    print('READY')