s = input()
answer = 0

for i in s:
  number = int(i)
  if number <= 1:
    answer += number
  else: 
    if answer == 0:
      answer += 1
    answer *= number

print(answer)