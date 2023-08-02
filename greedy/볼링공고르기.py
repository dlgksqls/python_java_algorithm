N, M = map(int,input().split())
weight = list(map(int,input().split()))
count = 0

# weight.sort()

for i in range(len(weight)-1): # 마지막 번째 공은 포함 안해도 됨
    for j in range(i+1,len(weight)):
        if weight[i] == weight[j]: # 무게가 같은 공 제외
            pass
        else:
            count=count+1
            
print(count)