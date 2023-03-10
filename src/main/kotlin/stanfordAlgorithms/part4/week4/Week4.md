## Local Search

### The Maximum Cut Problem

- Input: an undirected graph G = (V, E)
- Goal: a cut (A, B) - a partition of V into two non-empty sets - that
  maximizes the number of crossing edges.
- Sad fact: NP-complete

- Computationally tractable special cases:
	- bipartite graphs (i.e., where there is a cut such that all edges are
	  crossing)
	- solve in linear time with BFS

- Notation: for a cut (A, B) and a vertex v, define:
	- c_v (A, B) = # of edges incident on v that cross (A, B)
	- d_v (A, B) = # of edges incident on v that don't cross (A, B)

- Local search algorithm
	1. Let (A, B)  be an arbitrary cut of G
	2. While there is a vertex v with d_v (A, B) > c_v (A, B)
		- more v to the other side of the cut [key point: increases number
		  of crossing edges by d_v (A, B) - c_v (A, B) > 0]
	3. return final cut (A, B)

- Note: terminates within ((n - 1) * n) / 2 iterations [+ hence in
  polynomial time]
- Performance guarantees:
	- Theorem: this local search algorithm always outputs a cut in which the
	  number of crossing edges is at least 50% of the maximum possible.
	- Even >= 50% of |E| (all of the edges of graph)

- Cautionary point: expected # of crossing edges of a random cut is already
  1/2 |E|
- Proof:
	- Consider a random cut (A, B) for edge e in E, define x_e = { 1 if e
	  crosses (A, B), 0 otherwise }
	- We have E[x_e] = Pr[x_e = 1] = 1/2
	- So E[# of crossing edges] = E[sum x_e] = sum E[x_e] = |E| / 2
		- Linearity of expectations

- Proof of performance guarantee
	- Let (A, B) be a locally optimal cut
	- Then, for every vertex v, d_v (A, B) <= c_v (A, B)
	- 2 * [# of non-crossing edges] <= 2 * [# of crossing edges]
	- 2 * |E| <= 4 * [# of crossing edges] (Add double crossing edges to
	  both sides)
	- # of crossing edges >= 1/2 |E|

### The Weighted Maximum Cut Problem

- Generalization: each edge e in E has a non-negative weight w_e, want
  to maximize total weight of crossing edges
- Notes:
	1. local search still well-defined
	2. performance guarantee of 50% still holds for locally optimal cuts
		- also for random cut
	3. no longer guaranteed to converge in polynomial time
		- non-trivial exercise

- Neighbourhoods:
	- let x = set of candidate solutions to a problem
	- Examples:
		- Cuts of a graph
		- TSP tours
		- CSP (constraint satisfaction) variable assignments
	- Key ingredient: neighbourhoods
	- for each x in X, specify which y in X are its "neighbours"
	- Examples:
		- x, y are neighbouring cuts <==> differ by moving one vertex
		- x, y are neighbouring variable assignments <==> differ in the value of
		  a single variable
		- x, y are neighbouring TSP tours <==> differ by 2 edges

- A General Local Search Algorithm
	1. Let x = some initial solution
	2. while the current solution x has a superior neighbouring solution y:
		- set x := y
	3. return the final (locally optimal) solution x

- Question #1: how to pick initial solution x?
	- Answer #1:
		- Use a random solution
		- Run many independent trials of local search, return teh best locally
		  optimal solution found.
	- Answer #2:
		- use your best heuristics
		- i.e., use local search as a post-processing step to make your
		  solution even better

- Question #2: if there are several superior neighbouring y, which to choose?
	- Possible Answers:
		1. choose y at random
		2. biggest improvement

- Question #3: how to define the neighbourhoods?
	- Note: bigger neighbourhoods slower to verify local optimality, but
	  fewer bad local optima
	- Answer: find "sweet spot" between solution quality and efficient
	  searchability

- Question: is local search guaranteed to terminate (eventually)?
	- Answer: if x is finite, and local step improves some objective function,
	  then yes.

- Question: is local search guaranteed to converge quickly?
	- Answer: usually not.
	- though it often does in practice (see "smoothed analysis")

- Question: are locally optimal solutions generally good approximations to
  globally optimal ones?
	- Answer: no.
	- to mitigate, run randomized local search many times, remember the best
	  locally optimal solution found

### The 2-SAT Problem

- Input:
	- n boolean variables x_1, x_2, ..., x_n
		- can be set to true or false
	- m clauses of 2 literals each ("literal" = x_i or not x_i)
- Output:
	- "yes" if there is an assignment that simultaneously satisfies every
	  clause, "no" otherwise

- Example:
	- x_1 OR x_2
	- not x_1 OR x_3 (x_1 has to be false or x_3 needs to be true)
	- x_3 OR x_4
	- not x_2 OR not x_4 (x_2 has to be false or x_4 needs to be false)
- Possible solution:
	- x_1 = x_3 = true
	- x_2 = x_4 = false

### (In)tractability of SAT

- 2-SAT: can be solved in polynomial time!
	- reduction to computing strongly connected components
		- linear time
	- "backtracking"
		- polynomial time
	- randomized local search

- 3-SAT: canonical NP-complete
	- brute-force search ~= 2^n time
	- can get time ~= (4/3)^n via randomized local search

### Papadimitriou's 2-SAT Algorithm

- Repeat log2n times:
	- chosen random initial assignment
	- repeat 2 * n^2 times: (n = # of variables)
		- if current assignment satisfies all clauses, halt + report this
		- else, pick arbitrary unsatisfied clause and flip the value of its
		  variables
			- choose between the two uniformly at random
- report "unsatisfiable"

- Obvious good points:
	1. runs in polynomial time
	2. always correct on unsatisfiable instances

- Key question: if there's a satisfying assignment, will the algorithm find one?

### Random Walks

- Key to analyzing Papadimitriou's algorithm:
	- T_n = # of steps until random walk reaches position n
	- E[T_n] = n^2

- Analysis of T_n
	- Let Z_i = number of random walks steps to get to n from i
		- note Z_0 = T_n (num of steps you need to reach n, starting from 0)
	- Edge cases:
		- E[Z_n] = 0
		- E[Z_0] = 1 + E[Z_1]

- For i in {1, 2, ..., n - 1}:
	- E[Z_i] = Pr[go left] * E[Z_i | go left] + Pr[go right] * E[Z_i | go right]
	- = 1/2 * (1 + E[Z_i-1]) + 1/2 * (1 + E[Z_i+1])
	- = 1 + 1/2 E[Z_i+1] + 1/2 E[Z_i-1]
	- E[Z_i] - E[Z_i+1] = E[Z_i-1] - E[Z_i] + 2

- So:
	- E[Z_0] - E[Z_1] = 1
	- E[Z_1] - E[Z_2] = 3
	- E[Z_2] - E[Z_3] = 5
	-
		+ E[Z_n-1] - E[Z_n] = 2n - 1
	- E[Z_0] = E[T_n] = n^2

- Corollary: Pr[T_n > 2n^2] <= 1/2
	- Special case of Markov's inequality

- Satisfiable Instances
	- Theorem: for a satisfiable 2-SAT instance with n variables,
	  Papadimitriou's algorithm produces a satisfying assignment with
	  probability >= 1 - 1 / n

- Proof: first focus on a single iteration of the outer for loop
	- fix an arbitrary assignment a*
	- let a_t = algorithm's assignment after inner iteration t (t = 0, 1, ...
	  , 2n^2) [a random variable]
	- Let x_t = # of variables on which a_t and a* agree
		- x_t in {0, 1, 2, ..., n}
	- Note: if x_t = n, algorithm halts with satisfying assignment a*

- Key point: suppose a_t not a satisfying assignment and algorithm picks
  unsatisfied clause with variables x_i, x_j
- Note: since a* is satisfying, it makes a different assignment than x_i or
  x_j (or both)

- Consequence of algorithm's random variable flip:
	1. if a* and a_t differ on both x_i and x_j, then x_t+1 = x_t + 1
		- guaranteed that x_t + 1 will be one more
	2. if a* and a_t differ on exactly one of x_i, x_j then:
		- x_t+1 = {x_t + 1 OR x_t - 1} -> 50% probability of either

- Consequence: probability that a single iteration of the outer for loop
  finds a satisfying assignment is >= Pr[T_n <= 2n^2] >= 1/2

- Thus: Pr[algorithm fails] <= Pr[all log2n independent trials fail]
	- <= (1/2)^(log2n)
	- 1/n