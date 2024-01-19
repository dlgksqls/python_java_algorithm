def factorial_recursive(n):
    if n == 1:
        return n
    else:
        return n * factorial_recursive(n - 1)


def factorial_iterative(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result


print(f"재귀적인 팩토리얼 {factorial_recursive(5)}")
print(f"반복적인 팩토리얼 {factorial_iterative(5)}")
