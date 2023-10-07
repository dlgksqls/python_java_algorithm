num = int(input())
answer_list = []
answer = []

for i in range(num):
  n,p = map(int,input().split())
  answer_list.append((n,p))

for j in range(len(answer_list)):
  max = 1
  min = 1
  max_min = 1

  if answer_list[j][0] == answer_list[j][1]:
    answer.append(1)
  elif answer_list[j][0] == 1:
    answer.append(answer_list[j][1])
  else:
    for i in range(1, answer_list[j][1]+1):
      max *= i
    for i in range(1, answer_list[j][0]+1):
      min *= i
    for i in range(1, (answer_list[j][1]-answer_list[j][0])+1):
      max_min *= i
      
    answer.append(max // (min * max_min))

for i in answer:
  print(i)