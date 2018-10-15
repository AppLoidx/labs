def translate_to_decimal(base_numb, base_radix):
    result = 0
    digit_index = 0
    while base_numb > 0:
        result += (base_numb % 10) * (base_radix ** digit_index)
        digit_index += 1
        base_numb = base_numb // 10

    return result


def get_nearest_fib_number(number, fib_number=1, last_fib_number=1, fib_numb_position = 0):

    if number > fib_number:
        temp = fib_number
        fib_number = fib_number + last_fib_number
        last_fib_number = temp

        fib_numb_position += 1
        return get_nearest_fib_number(number, fib_number, last_fib_number, fib_numb_position)

    elif number == fib_number:
        return [fib_number, fib_numb_position]

    elif number < fib_number:
        return [last_fib_number, fib_numb_position - 1]


def translate_to_fib(base_numb, base_radix=10):

    number = translate_to_decimal(base_numb, base_radix)
    result = ""
    unit_not_added = True
    last_fib_numb_position = None

    while number > 0:
        fib_numb, new_fib_numb_position = get_nearest_fib_number(number)
        if unit_not_added:
            print(last_fib_numb_position, new_fib_numb_position)
            if last_fib_numb_position is None:
                pass
            else:
                for i in range(last_fib_numb_position - new_fib_numb_position - 1):
                    result += "0"

            last_fib_numb_position = new_fib_numb_position
            result += "1"
            print(fib_numb)
            number -= fib_numb

    for i in range(last_fib_numb_position):
        result += "0"

    return result



numb = 192
print(translate_to_fib(numb))
