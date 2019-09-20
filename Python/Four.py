
# Write a method to decide if two strings are anagrams or not.

def isAnagrams(str1 , str2):
    if str1 is None or str2 is None or str1 == "" or str2 == "":
        return False
    if len(str1) != len(str2):
        return False
    return set(str1) == set(str2)


if isAnagrams("abcdd", "dbac"):
    print("TRUE")
else:
    print("FLASE")
