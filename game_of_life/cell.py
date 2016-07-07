class Cell:
	def __init__(self, state, neighbours):
		self.state = state
		self.neighbours = neighbours

	def regenerate(self):
		#count live neighbours
		live_neighbours = 0
		for cell in self.neighbours:
			if cell == 1:
				live_neighbours += 1
		
		if self.state == 'live':
			if live_neighbours < 2:
				self.state = 'dead'
				#print "so lonely..."
			if live_neighbours > 3:
				self.state = 'dead'
				#print "overcrowded!"
		else:
			if live_neighbours == 3:
				self.state = 'live'
				#print "the miracle of life"

