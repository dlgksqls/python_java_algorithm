# 02984 -> (((0+2)*9)*8)
# 1이나 0은 곱하지말고 더하기

a = input()

sum = 0

for i in range(len(a)):
    key = int(a[i]) # 원소 하나씩 불러오기
    
    if (sum == 1 or sum == 0) or (key == 0 or key == 1): # 첫 key가 1이나 0이면 더해주기
        sum = sum + key
    else:
        if i == 0: # 첫번째 원소라면 sum = key로
            sum = key
        else: # 아니면 곱해주기
            sum = sum*key
print(sum)