def reverseString(str):
    l = list(str)
    endIndex = len(l) -1;
    if len(l) % 2 == 0:
        for i in range(len(l) / 2):
            temp = l[i]
            l[i] = l[endIndex]
            l[endIndex] = temp
            endIndex -= 1
    else:
        for j in range((len(l) -1) / 2):
            temp = l[j]
            l[j] = l[endIndex]
            l[endIndex] = temp
            endIndex -= 1
    print(l)

reverseString("NASTARAN")

print((len("Milad") -1) / 2 - 1)