N = int(input()) # 모험가의 수

n=list(map(int,input().split())) # 각 모험가의 공포도
n.sort(reverse=True) # 공포도가 가장 높은 순대로 정렬
a = []
count = 0

for i in range(len(n)):
    a.append(n[i])
    if len(a) == max(a): # 배열의 크기가 공포도가 가장 높은 사람의 공포도와 같다면 팀 생성 종료
        a.clear() # 배열을 비우고 이후 팀 생성
        count = count+1 
        
print(count)
        