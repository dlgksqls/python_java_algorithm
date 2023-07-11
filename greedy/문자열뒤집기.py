s = input()
result = list(s)

count_0 = 0
count_1 = 0

if result[0] == '1':
  count_1 = count_1 + 1
else:
  count_0 = count_0 + 1

for i in range(0,len(result)-1):
  if result[i] != result[i+1]:
    if result[i+1] == '1':
      count_1 = count_1 + 1
      result[i+1] = '0'
    else:
      count_0 = count_0 + 1
      result[i+1] = '1'

print(result)
print(count_0,count_1)

  