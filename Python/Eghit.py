# Assume you have a method isSubstring which checks if one word is a substring of another.
# Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
# (i.e., "waterbottle" is a rotation of "erbottlewat").

def isRotate(str1, str2):
    con = str1 + str1
    if str2 in con:
        print("TRUE")
    else:
        print("FALE")

str1 = input("Enter first string: ")
str2 = input("Enter second string: ")
isRotate(str1, str2)

