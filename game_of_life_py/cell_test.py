from cell import Cell

def print_regen(cell):
    print
    print cell.state,
    print cell.neighbours
    cell.regenerate()
    print cell.state 
 
dead_nbs = [0,0,0,0,0,0,0,0]
live_nbs = [1,1,1,1,1,1,1,1]

overpop_nbs = [1,1,1,1,0,0,0,0]
liveon_three_nbs =  [1,1,1,0,0,0,0,0]
liveon_two_nbs =  [0,1,1,0,0,0,0,0]

reprod_nbs = [1,0,0,1,0,1,0,0]

c1 = Cell('live', dead_nbs)
print_regen(c1)
c2 = Cell('live', live_nbs)
print_regen(c2)

print

array_of_arrays = [dead_nbs, 
live_nbs, overpop_nbs, liveon_three_nbs, liveon_two_nbs, reprod_nbs]

print array_of_arrays

for arr in array_of_arrays:
    new_cell = Cell('live', arr)
    print_regen(new_cell)

for arr in array_of_arrays:
    new_cell = Cell('dead', arr)
    print_regen(new_cell)
    
