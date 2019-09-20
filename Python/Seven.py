# Write an algorithm such that if an element in an MxN matrix is 0,
# its entire row and column is set to 0.

def setZero(matrix):
    row  = [0 for x in range(len(matrix))]
    column = [0 for x in range(len(matrix[0]))]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == 0:
                row[i] = 1
                column[j] = 1
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if row[i] == 1 or column[j] == 1:
                matrix[i][j] = 0
    return matrix

matrix = [[1,2,3],[4,0,6],[7,8,9]]
print(matrix)
print(setZero(matrix))