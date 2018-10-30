
def translate_to_decimal(base_numb, base_radix):
    result = 0
    digit_index = 0
    while base_numb > 0:
        result += (base_numb % 10) * (base_radix ** digit_index)
        digit_index += 1
        base_numb = base_numb // 10

    return result


# def get_nearest_fib_number(number, fib_number=1, last_fib_number=1, fib_numb_position = 0):
#
#     if number > fib_number:
#         temp = fib_number
#         fib_number = fib_number + last_fib_number
#         last_fib_number = temp
#
#         fib_numb_position += 1
#         return get_nearest_fib_number(number, fib_number, last_fib_number, fib_numb_position)
#
#     elif number == fib_number:
#         return [fib_number, fib_numb_position]
#
#     elif number < fib_number:
#         return [last_fib_number, fib_numb_position - 1]


# def translate_to_fib(base_numb, base_radix=10):
#
#     number = translate_to_decimal(base_numb, base_radix)
#     result = ""
#     unit_not_added = True
#     last_fib_numb_position = None
#
#     while number > 0:
#         fib_numb, new_fib_numb_position = get_nearest_fib_number(number)
#         if unit_not_added:
#             if last_fib_numb_position is None:
#                 pass
#             else:
#                 for i in range(last_fib_numb_position - new_fib_numb_position - 1):
#                     result += "0"
#
#             last_fib_numb_position = new_fib_numb_position
#             result += "1"
#             number -= fib_numb
#
#     for i in range(last_fib_numb_position):
#         result += "0"
#
#     return result

def translate_to_bin(number):
    result = ""     # переменная, в которую записываем результат
    while number > 0:
        result += str(number % 2)   # остаток от деления на двойку
        number = number // 2    # целочисленное деление на двойку

    return result[::-1]     # переворачиваем результат


def translate_to_fac(number, base_radix=10):
    number = translate_to_decimal(number, base_radix)
    temp = 2
    result = ""
    last = False
    while True:
        result += str(number % temp)
        number = number//temp
        temp += 1

        if last:
            break
        if number // temp == 0:
            last = True

    return result[::-1]


FILE_WITH_BIN_DECIMAL = "input1.txt"
FILE_WITH_DECIMAL_FACTORIAL = "input2.txt"

print("============== " + FILE_WITH_BIN_DECIMAL + " ==============")

f = open(FILE_WITH_BIN_DECIMAL, "r")
array1 = f.read().split("\n")
for i in array1:
    i = i.split()
    print(i[0] + "->" + i[1] + ": ", end='')
    for j in range(2, len(i)):
        if j == len(i) - 1:
            print(i[j], "->", translate_to_decimal(int(i[j]), 2), end='\n')
        else:
            print(i[j], "->", translate_to_decimal(int(i[j]), 2), end=' | ')
f.close()

print("============== " + FILE_WITH_DECIMAL_FACTORIAL + " ==============")

f = open(FILE_WITH_DECIMAL_FACTORIAL, "r")
array2 = f.read().split("\n")
for i in array2:
    i = i.split()
    print(i[0] + "->" + i[1] + ": ", end='')
    for j in range(2, len(i)):
        if j == len(i) - 1:
            print(i[j], "->", translate_to_fac(int(i[j]), 10), end='\n')
        else:
            print(i[j], "->", translate_to_fac(int(i[j]), 10), end=' | ')
f.close()



print(translate_to_bin(9))