food_time = list(map(int,input().split()))
food_time_len = len(food_time)
k = int(input())
result = 0
food_number=0

for i in range(k):
    if food_time[i%food_time_len] == 0:
        food_number=i%food_time_len+1
        food_time[food_number] = food_time[food_number] - 1
        print(f'{i}~{i+1}초 동안에 ({food_number}번음식은 다 먹었으므로) {food_number+1}번음식을 섭취합니다. 남은 시간은 {food_time}입니다.')
        food_number = i%food_time_len
    else:
        food_time[i%food_time_len] = food_time[i%food_time_len] - 1
        food_number=i%food_time_len+1
        print(f'{i}~{i+1}초 동안에 {food_number}번음식을 섭취합니다. 남은 시간은 {food_time}입니다.')

print(f'{k}초에서 네트워크 장애가 발생했습니다. {food_number}번 음식을 섭취해야 할 때 중단되었으므로, 장애 복구 후에 {food_number}번 음식부터 다시 먹기 시작하면 됩니다.')