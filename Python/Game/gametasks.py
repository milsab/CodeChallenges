
import os

fileName = "userScores.txt"

def printInstructions(instruction):
    print(instruction)

def getUserScore(userName):
    try:
        records = open(fileName, 'r')
        scoresList = {}
        for r in records:
            r = r.strip('\n')
            s = r.split(', ')
            if s[0] == userName:
                return s[1]
            else:
                return -1
            scoresList[s[0]] = s[1]
        print(scoresList)
        records.close()
    except IOError:
        print("The file does not exist!")
        newFile = open(FileName, 'w')
        return -1


def updateScores(newUser, userName, score):
    if newUser == True:
        file = open(fileName, 'a')
        file.write(userName + ', ' + score)
        file.close()
    else:
        tempFile = open('userScores.tmp', 'w')
        file = open(fileName, 'r')
        for r in file:
            r_temp = r.strip('\n')
            s = r_temp.split(', ')
            if s[0] == userName:
                tempFile.write(userName + ', ' + str(score) + '\n')
            else:
                tempFile.write(r)
        file.close()
        tempFile.close()
        os.remove(fileName)
        os.rename('userScores.tmp', fileName)




print(getUserScore("Ann"))
updateScores(False, 'Ann', 200)
print(getUserScore("Ann"))
