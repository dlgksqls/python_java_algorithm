N = input()
sum = 0
list_result = []

for i in range(len(N)):
  if ord(N[i]) >= 65 and ord(N[i]) <= 90:
    list_result.append(N[i])
  else:
    sum = sum + int(N[i])

list_result.sort()
list_result.append(str(sum))

list_fin = ''.join(list_result)

print(list_fin)