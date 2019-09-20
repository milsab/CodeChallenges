
def replaceSpaces(str):
    if str is None or str == "":
        return "Invalid Input"
    newStr = ""
    for s in str:
        if s == " ":
            newStr = newStr + "%20"
            continue
        newStr = newStr + s
    return newStr

print(replaceSpaces("Milad  Sabouri"))