# Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
# NOTE: One or two additional variables are fine. An extra copy of the array is not.
# FOLLOW UP: Write the test cases for this method.

def removeDuplicates(str):
    if str == None:
        return
    newStr = "";
    char_set = [False] * 256
    for s in str:
        val = ord(s)
        if not char_set[val]:
            char_set[val] = True
            newStr = newStr + s
    return newStr


print(removeDuplicates(None))
