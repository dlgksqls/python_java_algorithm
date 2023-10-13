n = str(input())
f = str(input())
result = int(n[:-2]+'00')

while True:
  if result % int(f) == 0:
    break
  result += 1

result = str(result)
print(result[-2:])