# n행 m열로 카드를 놓음
# 뽑고자 하는 카드가 포함되어있는 행 선택
# 선택된 행에 포함된 카드 중 가장 숫자가 낮은 카드 뽑아야함
# 결론 = > 각 행의 카드 중 가장 작은 것 중 가장 큰 것을 골라야함
# ex) [[3,1,2],[4,1,4],[2,2,2]]/ 출력 : 2

n,m = map(int,input().split()) 

result_list = [] # 2차원 배열을 위해 배열 하나 만듬
for i in range(0,n): # n행 ,m열 만큼 값을 집어넣음
    line = []
    for j in range(0,m):
        number = input()
        line.append(number)
    result_list.append(line) # 큰 행렬안에 작은 행렬 넣음으로써 2차원 배열 완성 result_list[line[]]

min_ = min(result_list[0]) # 0행에 있는 행렬 중 최솟값을 변수에 넣음

for i in range(0,n): # 행의 수대로 반복문을 돌려서 각 행의 최솟값을 비교해서 최종 결론 도출
    if min_ < min(result_list[i]): 
        min_ = min(result_list[i])
print("카드게임 결과 : ",min_)