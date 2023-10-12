n, m = map(int, input().split())

result = 0
brand = []

for _ in range(m):
    price = list(map(int, input().split()))
    brand.append(price)

min_pkg = sorted(brand, key=lambda x : x[0])
min = sorted(brand, key=lambda x : x[1])

if min_pkg[0][0] <= min[0][1] * 6:
    result = min_pkg[0][0] * (n // 6) + min[0][1] * (n % 6)
    if min_pkg[0][0] < min[0][1] * (n % 6):
        result = min_pkg[0][0] * (n//6 + 1)
else:
    result = min[0][1] * n

print(result)