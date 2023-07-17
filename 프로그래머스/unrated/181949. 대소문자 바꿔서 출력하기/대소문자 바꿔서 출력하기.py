str = input()
result = ""

for i in str:
    if i.islower():
        i = i.upper()
        result = result+i
    else:
        i = i.lower()
        result = result+i
print(result)