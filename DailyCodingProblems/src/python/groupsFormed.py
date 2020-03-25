#Given n friends and their friendship relations, find the total number of groups that exist. 
#And the number of ways of new groups that can be formed consisting of people from every existing group.
#If no relation is given for any person then that person has no group and singularly forms a group. 
#If a is a friend of b and b is a friend of c, then a b and c form a group.


#Python3 program to count number of
#existing groups and number of new
#groups that can be formed
class Graph:
		def __init__(self, V):
			self.V = V
			self.adj = [[] for i in range(V)]

		#adds a relation as a two way
		#edge of undirected graph
		def addRelation(self, v, w):

			#since indexing is 0 based,
			#reducing edge numbers by 1.
			v -= 1
			w -= 1
			self.adj[v].append(w)
			self.adj[w].append(v)

		#Returns count of not visited
		#nodes reachable from v using DFS
		def countUtil(self, v, visited):
			count = 1
			visited[v] = True
			i = 0
			while i != len(self.adj[v]):
				if (not visited[self.adj[v][i]]):
					count = count + self.countUtil(self.adj[v][i], visited)

				i += 1
			return count

		#A DFS based function to count number 
		# of existing groups and number of new
		# groups that can be formed using a 
		# member of every group
		def countGroups(self):

			#Mark all the vertices as not visited
			visited = [0] * self.V

			existing_groups = 0
			new_groups = 1

			for i in range(self.V):

				# if not in any group
				if (visited[i] == False):
					existing_groups += 1

					#Number of new groups that
					#can be formed
					new_groups = (new_groups *
									self.countUtil(i,visited))

			if (existing_groups == 1):
				new_groups = 0

			print("No. of existing groups are ", existing_groups)
			print("No. of new groups that can be formed are ", new_groups)

#Driver code
if __name__ == '__main__':
	n = 6

	#Create a graph given in the above diagram
	g = Graph(n) #total 6 people
	g.addRelation(1,2) #1 and 2 are friends
	g.addRelation(3,4)
	g.addRelation(5,6)

	g.countGroups()
