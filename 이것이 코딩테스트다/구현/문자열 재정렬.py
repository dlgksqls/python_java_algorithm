s = input()
alpha = []
number = 0
answer = ""

for i in range(len(s)):
    if s[i].isalpha():
        alpha.append(s[i])
    else:
        number += int(s[i])

alpha.sort()
alpha.append(str(number))
answer = "".join(alpha)
print(answer)
