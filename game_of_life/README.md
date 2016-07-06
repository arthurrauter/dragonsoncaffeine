#Conway's game of life in Python3:
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

TL;DR:
1. cell with fewer than 2 live neighbours dies
1. cell with 2 or 3 live neighbours lives on to the next generation.
1. cell with more than 3 live neighbours dies
1. dead cell with exactly 3 live neighbours becomes a live cell

obs: grid is finite, border cell will probably always die or never live.

