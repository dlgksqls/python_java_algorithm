n,m = map(int,input().split())

result_list = []
for i in range(0,n):
    line = []
    for j in range(0,m):
        number = input()
        line.append(number)
    result_list.append(line)

min_ = min(result_list[0])

for i in range(0,n):
    if min_ < min(result_list[i]):
        min_ = min(result_list[i])
print("카드게임 결과 : ",min_)