N = input()
sum = 0
list_result = []

for i in range(len(N)):
  if ord(N[i]) >= 65 and ord(N[i]) <= 90: # A의 아스키 코드 65 Z의 아스키 코드 90
    list_result.append(N[i]) # 영어라면 리스트에 넣고
  else:
    sum = sum + int(N[i]) # 숫자라면 그냥 더해주기

list_result.sort() # 알파벳 내림차순으로 정렬
list_result.append(str(sum)) # 숫자를 문자형태로 배열에 넣어주기
 
list_fin = ''.join(list_result) # 배열을 문자열로 변환 

print(list_fin)