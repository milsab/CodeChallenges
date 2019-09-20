# Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
# write a method to rotate the image by 90 degrees. Can you do this in place?

# -------------------------------------------------------

# Creates a list containing 5 lists, each of 8 items, all set to 0
# w, h = 8, 5;
# Matrix = [[0 for x in range(w)] for y in range(h)]


# https://docs.python.org/3/tutorial/datastructures.html#list-comprehensions
matrix = [[x**2 for x in range(3)] for y in range(3)]

print( matrix)

# print("matrix: " + len(matrix))
# print("rotated matrix: " + rotate(matrix))

def rotate(matrix):
    row = len(matrix)
    column = len(matrix[0])
    if row != column:
        return None
    m2 = [[0 for x in range(row)] for y in range(column)]
    print(m2)
    for i in range(row):
        for j in range(column):
            m2[i][j] = matrix[(row-1) - j][i]
    return m2

print(rotate(matrix))