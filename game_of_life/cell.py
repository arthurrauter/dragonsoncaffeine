class Cell:
	def __init__(self, state, neighbours):
		self.state = state
		self.neighbours = neighbours

	def regenerate(self):
		#count alive neighbours
		alive_neighbours = 0
		for cell in self.neighbours:
			if cell == 1:
				alive_neighbours += 1
		
		if self.state == 'alive':
			if alive_neighbours < 2:
				self.state = 'dead'
				print "so lonely..."
			if alive_neighbours > 3:
				self.state = 'dead'
				print "overcrowded!"
		else:
			if alive_neighbours == 3:
				self.state = 'alive'
				print "the miracle of life"

