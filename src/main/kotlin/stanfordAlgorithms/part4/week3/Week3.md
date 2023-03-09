### Strategies for NP-Complete Problems

1. Identify computationally tractable special cases
	- Example: knapsack instances w/ small capacity
	- i.e., knapsack capacity W = polynomial in number of items n

2. Heuristics
	- Knapsack problem:
		- pretty good greedy heuristic
		- excellent dynamic programming heuristic
	- Ideally: should provide a performance guarantee
		- i.e., "almost correct" for all (or at least many) instances of
		  interest

3. Exponential time, but butter than brute-force search
	- Example: O(n * W)-time dynamic programming vs. O(2^n) brute force search

### Knapsack Revisited

- Input:
	- n items
	- each has a positive value v_i and a size w_i
	- knapsack capacity is W

- Output: a subset s of {1, 2, 3, ..., n} that:
	- maximizes sum v_i
	- subject to sum w_i <= W

### Greedy Heuristic

- Motivation: ideal items have big value, small weight

- Step 1:
	- sort and reindex items so that v_1 / w_1 >= v_2 / w_2 >= ... >= v_n / w_n
	- non-decreasing "bang-per-buck"
- Step 2: k items in this order until one doesn't fit, then halt.

- Upshot: greedy solution can be arbitrarily bad relative to an optimal solution

- Step 3: return either step-2 solution, or the maximum valuable item,
  whichever is better.

- Theorem: value of the 3-step greedy solution is always >= 50% value of an
  optimal solution.

### Analysis of Greedy Heuristic

- Theorem:
	- value of the 3-step greedy algorithm's solution is always >= 50% value
	  of an optimal solution
- Thought experiment:
	- what if we were allowed to fill fully the knapsack using a suitable
	  "fraction" (like 70%) of item (k + 1?)
		- the value of which is "pro-rated"
	- will call this the "greedy fractional solution"

- Claim: greedy fractional solution at least as good as every non-fractional
  solution
	1. Let S = an arbitrary feasible solution
	2. Suppose l units of knapsack filled by S with items not packaged by the
	   greedy fractional solution
	3. Must be at least l units of knapsack filled by greedy fractional
	   solution not packaged by S
	4. by greedy criterion, items in 3 have larger bang-per-buck v_1/w_i
	   than those in 2, [i.e., more valuable use of space]
	5. total value of greedy fractional solution at least that of S


- In step 2, supposed our greedy algorithm picks the 1st k items (sorted by
  v_i / w_i)
- Value of 3-step greedy algorithm:
	- is >= total value of 1st k items
	- also, is >= value of (k + 1)th item
- 2 x (value of 3-step greedy):
	- is >= total value of 1st (k + 1) items (fraction of k + 1 item)
	- is >= total value of greedy fractional solution
	- is >= optimal knapsack solution
- Therefore, value of 3-step greedy > 50% of optimal knapsack solution

### A Refined Analysis

- Suppose: every item i has a size w_i <= 10% knapsack capacity W
- Consequence:
	- if greedy algorithm fails to pack all items in step 2, then the
	  knapsack is >= 90% full
	- value of 2-step greedy algorithm
		- is >= 90% value of greedy fractional solution
		- is >= 90% value of an optimal solution
- in general, if max w_i <= d * W, then 2-step greedy value is >= (1 - d) *
  optimal

### Arbitrarily Good Approximation

- Goal: for a user-specified parameter E > 0 (e.g., E = 0.01)
	- guarantee a (1 - E)-approximation
- Catch:
	- Running time will increase as E decreases
	- i.e. algorithm exports a running time vs. accuracy trade-off
- Best-base scenario for NP-complete problems.

- High-level idea:
	- exactly solve a slightly incorrect, but easier, knapsack instance.
- Recall:
	- if the w_i's and W are integers, can solve the knapsack problem
	  via dynamic programming in O(n * W) time.
- Alternative:
	- if v_i's are integers, can solve knapsack via dynamic programming in O
	  (n^2 * v_max) time, where v_max = max v_i
- Upshot:
	- if all v_i's are small integers (polynomial in n) then we already know
	  a poly-time algorithm.
- Plan:
	- throw out lower-order bits of the v_i's

- Step 1:
	- Round each v_i down to the nearest multiple of m
		- larger m -> throw out more info (less accuracy)
		- where m depends on E, exactly value to be determined later
	- Divide the results by m to get v_hat_i's (integers).
		- i.e., v_hat_i = v_i / m
- Step 2:
	- Use dynamic programming to solve the knapsack instance with values
	  v_hat_1, ..., v_hat_n, sizes w_1, ..., w_n, capacity W
	- Running time = O(n^2 * max v_hat_i)

- Note: computes feasible solution for the original knapsack instance

- Dynamic Programming Algorithm 1
	1. Assume sizes w_i and capacity W are integers
	2. Running time = O(n * W)

- Dynamic Programming Algorithm 2
	- Assume values v_i are integers
	- Running time = O(n^2 * v_max), where v_max = max (i) v_i

- Subproblems:
	- for i = 0, 1, 2, ..., n
	- and x = 0, 1, 2, ..., n * v_max
	- define S_i,x = minimum total size needed to achieve value >= x while
	  using only the first i items
		- or +infinity if impossible

- Recurrence: (i >= 1)
	- case_1 = s_(i-1),x -> item i not used in optimal solution
	- case_2 = w_i + S_(i-1),(x-v_i) -> item i used in optimal solution
		- interpret 2nd part as 0 if v_i >= x
	- S_i,x = min { case_1, case_2 }

- Let A = 2D Array [indexed by i = 0, 1, 2, ..., n and x = 0, 1, 2, ..., n * 
  v_max]

- Base case:
	- A[0, x] = { 0 if x = 0, +infinity otherwise }

- for i = 1, 2, 3, ..., n:
	- for x = 0, 1, 2, ..., n * v_max:
		- case_1 = A[i - 1, x]
		- case_2 = A[i - 1, x - v_i]
			- interpret as 0 if v_i >= x
		- A[i, x] = min { case_1, case_2 }

- Return the largest x, such that A[n, x] <= W
- Running time: O(n^2 * v_max)

### The Dynamic Programming Heuristic

- Step 1: set v_hat_i = v_i / m for every item i
- Step 2: compute optimal solution with respect to the v_hat_i's using
  dynamic programming.

- Plan for analysis:
	1. figure out how big we can take m, subject to achieving a (1 - E)
	   -approximation
	2. plug in this value of m to determine running time

- Since we rounded down to the nearest multiple of m, m * v_hat_i is between
  [v_i - m, v_i] for each item i

- Thus,
	1. v_i >= m * v_hat_i
	2. m * v_hat_i >= v_i - m
- Also, if S* = optimal solution to the original problem (with the original
  v_i's), and S = our heuristic's solution, then:
	3. sum (i in S) v_hat_i >= sum (i in S*) v_hat_i
		- since S is optimal for the v_hat_i's

- sum (i in S) v_i
  > = m * sum (i in S) v_hat_i
  > = m * sum (i in S*) v_hat_i
  > = sum (i in S*) (v_i - m)

Thus: sum (i in S) v_i >= sum (i in S*) v_i * (m * n)
Constraint: sum (i in S) v_i >= (1 - E) * sum (i in S*) v_i
To achieve this: choose m small enough that m * n <= E * sum (i in S*) v_i

sum (i in S*) v_i -> unknown to algorithm but definitely >= v_max

Sufficient: set m so that m * n = E * v_max

- i.e., heuristic uses the value m = E * v_max / n

Point: setting m = E * v_max / n guarantees that value of our solution is >=
(1 - E) * value of optimal solution

Recall: running time is O(n^2 * v_max)

- Note:
	- for every item i, v_hat_i <= v_i / m <= v_max / m 
    - = v_max * n / (E * v_max)
    - = n / E

Running Time: O((n^3) / E)