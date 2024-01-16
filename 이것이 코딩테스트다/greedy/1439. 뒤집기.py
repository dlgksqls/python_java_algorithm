s = input()
count = 0
# count_0 = 0
# count_1 = 0

# for i in range(1, len(s)):
#     prev = s[i - 1]
#     if prev == s[i]:
#         continue
#     elif prev == "0":
#         count_0 += 1
#     else:
#         count_1 += 1

# if min(count_0, count_1) == 0:
#     answer = max(count_0, count_1)
# else:
#     answer = min(count_0, count_1)

# print(answer)

for i in range(1, len(s)):
    if s[i - 1] != s[i]:
        count += 1

print((count + 1) // 2)
