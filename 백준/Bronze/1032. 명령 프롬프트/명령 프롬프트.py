n = int(input())
data_list = []
result = ""
count = 0

for _ in range(n):
    data = list(map(str, input().split()))
    data_list.extend(data)

if n == 1:
  result = data_list[0]

for i in data_list:
  if count == 0:
    before = i
    count += 1
  
  else:
    for j in range(len(before)):
      if len(result) != len(i):
        if before[j] == i[j]:
          result += before[j]
        else:
          result += "?"    
      else:
        if result[j] == i[j]:
          pass
        else:
          result = list(result)
          result[j] = "?"
          result = ''.join(result)

print(result)