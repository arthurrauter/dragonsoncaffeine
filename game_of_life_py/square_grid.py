from cell import Cell
import time

grid_size = 5

dead_nbs=[0,0,0,0,0,0,0,0]

#creates the matrix with dead cells and dead neighbours. Gloomy.
cells =[]
for n in range(grid_size):
    row = []
    for n in range(grid_size):
        row.append(Cell('dead', dead_nbs))
    cells.append(row)


##make two cells alive so we know the print below works
#cells[0][0].state = 'live'
#cells[0][1].state = 'live'
#cells[-1][-1].state = 'live'
#

#checks if the ranges work as I wanted them to
#for x in range(grid):
#   for y in range(grid):
#       print x,
#       print y,
#   print





#return a list with the adjacent cells from cell[x][y]
#0 means dead cell, 1 means living cell
#the order of the list is:
#first 3 elements are the first column from bottom to top
#next 3 elements are the second column from bot to top
#last 3 elements are the third column from bot to top
#(the order doesn't really matters)
def adjacent_cells(x,y,grid,cells):
    x_range = [x-1, x, x+1]
    y_range = [y-1, y, y+1]
    adjacent_cells = []
    for dx in x_range:
        for dy in y_range:
            #print dx,
            #print dy,
            #print
            if dx != x or dy != y:
                if dx < 0 or dx >= grid or dy < 0 or dy >= grid:
                    adjacent_cells.append(0)
                else:
                    if cells[dx][dy].state == 'live':
                        adjacent_cells.append(1)
                    else:
                        adjacent_cells.append(0)

    return adjacent_cells

#iterates over the matrix and updates the neighbours of each cell
def update_neighbours(cell_matrix, grid_size):
    for x in range(grid_size):
        for y in range(grid_size):
            #print x,
            #print y,
            #print adjacent_cells(x,y,grid_size,cells)
            cell_matrix[x][y].neighbours = adjacent_cells(x,y,grid_size,cells)

#iterates over the matrix and tell all the cells to regenerate
def regenerate_all(cell_matrix, grid_size):
    for x in range(grid_size):
        for y in range(grid_size):
            cell_matrix[x][y].regenerate()
            #print cell_matrix[x][y].state,
            #print x,
            #print y,
            #print cell_matrix[x][y].state


def print_cells(cells):
    for x in range(len(cells)):
        for y in range(len(cells)):
            if cells[x][y].state == 'live':
                print '[#]',
            else:
                print '[ ]',
        print

#oscilator
#cells[2][2].state = 'live'
#cells[2][3].state = 'live'
#cells[2][1].state = 'live'

#R pentomino
cells[1][2].state = 'live'
cells[1][3].state = 'live'
cells[2][1].state = 'live'
cells[2][2].state = 'live'
cells[3][2].state = 'live'

for i in range(3000):
    print 'round ',
    print i
    print_cells(cells)
    update_neighbours(cells, grid_size)
    regenerate_all(cells, grid_size)
    time.sleep(1)




