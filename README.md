# Java-Programming

A collection of algorithms and data structures implemented in Java.

## Table of Contents
- [Search Algorithms](#search-algorithms)
- [Array Operations](#array-operations)
- [Subarray Algorithms](#subarray-algorithms)
- [Algorithmic Problems](#algorithmic-problems)
- [Sorting Algorithms](#sorting-algorithms)
- [Data Structures](#data-structures)
- [Dynamic Programming](#dynamic-programming)
- [Dynamic Programming Problem Patterns](#dynamic-programming-problem-patterns-and-formulas)
- [Segment Trees](#segment-trees)
- [Advanced Algorithms](#advanced-algorithms)
- [Object-Oriented Programming](#object-oriented-programming)
- [Utility Classes](#utility-classes)
- [Algorithm Application Patterns](#algorithm-application-patterns)

## Search Algorithms

### Linear Search
- **Description**: Sequentially checks each element until finding a match
- **Time Complexity**: O(n)
- **Implementation**: Iterates through array comparing each element with key
- **Code Found In**: Test.java

### Binary Search
- **Description**: Efficient search algorithm for sorted arrays
- **Time Complexity**: O(log n)
- **Implementation**: Divides search interval in half repeatedly
- **Code Found In**: Test.java

### Search Algorithm Formulas and Patterns

| Algorithm | Formula/Approach | Time Complexity | Space Complexity | Best Use Case |
|-----------|------------------|-----------------|------------------|---------------|
| Linear Search | Iterate: `for i=0 to n-1: if arr[i] == key: return i` | O(n) | O(1) | Unsorted arrays, small datasets |
| Binary Search | Iterative: `while start <= end: mid = (start+end)/2` | O(log n) | O(1) | Sorted arrays |
| Jump Search | Jump √n steps, then linear search | O(√n) | O(1) | Sorted arrays, better cache performance than binary |
| Interpolation Search | `pos = lo + ((key-arr[lo])*(hi-lo))/(arr[hi]-arr[lo])` | O(log log n) avg, O(n) worst | O(1) | Uniformly distributed sorted arrays |
| Exponential Search | Find range by doubling index, then binary search | O(log n) | O(1) | Unbounded/infinite arrays |
| Ternary Search | Divide range into 3 parts | O(log₃ n) | O(1) | Unimodal functions, finding extrema |

### Common Search Algorithm Patterns

1. **Divide and Conquer**
   - Used in: Binary search, merge sort
   - Implementation: Repeatedly divide problem into subproblems

2. **Two Pointers**
   - Used in: Binary search (start and end pointers)
   - Implementation: Maintain two indices to track search space

3. **Jumping Ahead**
   - Used in: Jump search, exponential search
   - Implementation: Skip elements to reduce comparisons

4. **Comparison Reduction**
   - Used in: Binary search vs linear search
   - Implementation: Minimize number of comparisons

## Array Operations

### Finding Largest/Smallest Element
- **Description**: Locates maximum or minimum value in an array
- **Time Complexity**: O(n)
- **Implementation**: Single pass through array tracking extremes
- **Code Found In**: Test.java

### Array Reversal
- **Description**: Reverses elements of an array in-place
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Implementation**: Two-pointer technique swapping elements
- **Code Found In**: Test.java

### Array Pairs
- **Description**: Generates all possible pairs of elements
- **Time Complexity**: O(n²)
- **Implementation**: Nested loops to create all combinations
- **Code Found In**: Test.java

### Array Operation Techniques and Formulas

| Operation | Formula/Approach | Time Complexity | Space Complexity | Implementation Notes |
|-----------|------------------|-----------------|------------------|----------------------|
| Array Traversal | `for i=0 to n-1: process arr[i]` | O(n) | O(1) | Sequential access pattern |
| Find Min/Max | `max = arr[0]; for i=1 to n-1: if arr[i] > max: max = arr[i]` | O(n) | O(1) | Single-pass algorithm |
| Array Reversal | `for i=0 to n/2-1: swap(arr[i], arr[n-1-i])` | O(n) | O(1) | In-place using two-pointer technique |
| Array Rotation | `reverse(0,d-1); reverse(d,n-1); reverse(0,n-1)` | O(n) | O(1) | Juggling algorithm or reversal algorithm |
| Array Shuffling | Fisher-Yates: `for i=n-1 to 1: swap(arr[i], arr[random(0,i)])` | O(n) | O(1) | Generate uniform random permutation |
| Prefix Sums | `prefix[0] = arr[0]; for i=1 to n-1: prefix[i] = prefix[i-1] + arr[i]` | O(n) | O(n) | Enables O(1) range sum queries |
| Sliding Window | `while right < n: expand/contract window based on condition` | O(n) | O(1) | Fixed or variable size window |

### Array Operation Patterns

1. **In-place Modification**
   - Used in: Array reversal, rotation
   - Benefits: No extra space required
   - Technique: Use swapping, mathematical formulas

2. **Preprocessing**
   - Used in: Prefix sums, frequency counting
   - Benefits: Enables faster queries later
   - Technique: Build auxiliary data structures

3. **Two-Pointer Technique**
   - Used in: Reversal, two-sum problem
   - Variants: Same direction, opposite directions
   - Technique: Maintain pointers that move based on conditions

4. **Frequency Counting**
   - Used in: Finding duplicates, majority element
   - Implementation: Hash map or array (for limited range)
   - Technique: Count occurrences of each element

## Subarray Algorithms

### Subarray Generation
- **Description**: Generates all possible subarrays
- **Time Complexity**: O(n³)
- **Implementation**: Triple nested loops
- **Code Found In**: Test.java

### Maximum Subarray Sum

#### Brute Force Approach
- **Description**: Checks all possible subarrays to find maximum sum
- **Time Complexity**: O(n³)
- **Implementation**: Triple nested loops
- **Code Found In**: Test.java

#### Prefix Sum Approach
- **Description**: Uses prefix sums to optimize subarray sum calculation
- **Time Complexity**: O(n²)
- **Space Complexity**: O(n)
- **Implementation**: Precomputes cumulative sums for efficient lookups
- **Code Found In**: Test.java

#### Kadane's Algorithm
- **Description**: Optimal approach for maximum subarray sum
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Implementation**: Dynamic programming, tracks current and maximum sum
- **Code Found In**: Test.java

### Subarray Algorithm Formulas and Techniques

| Algorithm | Formula/Approach | Time Complexity | Space Complexity | Key Insight |
|-----------|------------------|-----------------|------------------|-------------|
| Generate All Subarrays | Triple nested loops: `for i, for j>=i, for k from i to j` | O(n³) | O(1) | Enumerate all start and end positions |
| Maximum Subarray Sum (Brute) | `for i, for j>=i: calculate sum from i to j` | O(n²) | O(1) | Try all possible subarrays |
| Maximum Subarray Sum (Prefix) | `for i, for j>=i: sum = prefix[j] - prefix[i-1]` | O(n²) | O(n) | Use prefix sums for efficient calculation |
| Maximum Subarray Sum (Kadane) | `currSum = max(arr[i], currSum + arr[i])` | O(n) | O(1) | Dynamic programming approach |
| Sliding Window Maximum | Use deque to track max in window | O(n) | O(k) | Maintain candidates for maximum in window |
| Count Subarrays with Sum K | Hash map to track prefix sum frequencies | O(n) | O(n) | Use formula: count += prefixSumMap[currSum - k] |
| Longest Subarray with Sum K | Hash map to store first occurrence of prefix sum | O(n) | O(n) | Track earliest occurrence of prefix sum |

### Subarray Pattern Recognition

1. **Fixed-Length Subarrays**
   - Technique: Sliding window of fixed size
   - Applications: Maximum/minimum sum of size K

2. **Variable-Length Subarrays**
   - Technique: Grow/shrink window based on condition
   - Applications: Subarrays with sum/product constraint

3. **Prefix Sum Applications**
   - Technique: Compute running sum, use for range queries
   - Applications: Subarray sum equals K, count subarrays with given sum

4. **Kadane's Pattern**
   - Technique: Local vs. global maximum tracking
   - Applications: Maximum subarray sum, maximum product subarray

5. **Deque for Sliding Window**
   - Technique: Maintain monotonic queue
   - Applications: Sliding window maximum/minimum

## Algorithmic Problems

### Trapping Rain Water
- **Description**: Calculates water trapped between bars of different heights
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Implementation**: Uses left and right max arrays to compute water at each position
- **Code Found In**: Test.java

### Buy and Sell Stock
- **Description**: Determines maximum profit from single buy-sell transaction
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Implementation**: Tracks minimum buy price and maximum profit
- **Code Found In**: Test.java

### Distinct Elements Check
- **Description**: Detects if array contains duplicate elements
- **Time Complexity**: O(n²)
- **Implementation**: Nested loops comparing all element pairs
- **Code Found In**: Test.java

### Algorithmic Problem Formulas and Techniques

| Problem Type | Formula/Approach | Time Complexity | Space Complexity | Problem Examples |
|--------------|------------------|-----------------|------------------|------------------|
| Trapping Rain Water | `water += min(leftMax[i], rightMax[i]) - height[i]` | O(n) | O(n) | Histogram water, container with most water |
| Buy/Sell Stock | `profit = max(profit, price[i] - minPrice)` | O(n) | O(1) | Single transaction, multiple transactions |
| Duplicate Detection | Hash set or sorting approach | O(n) or O(n log n) | O(n) or O(1) | Contains duplicate, find all duplicates |
| Majority Element | Boyer-Moore voting: `if count==0: candidate=num; if num==candidate: count++; else: count--` | O(n) | O(1) | Element appearing > n/2 times |
| Interval Merging | Sort by start time, merge overlapping | O(n log n) | O(n) | Merge intervals, insert interval |
| Dutch National Flag | Three-way partitioning | O(n) | O(1) | Sort colors, partition array |
| Two Pointers | `while left < right: adjust pointers based on condition` | O(n) | O(1) | Container with most water, 3Sum |

### Common Problem-Solving Techniques

1. **Auxiliary Arrays**
   - Used in: Trapping rain water (leftMax/rightMax)
   - Pattern: Precompute values to avoid repeated calculations

2. **Greedy Choice**
   - Used in: Buy/sell stock, activity selection
   - Pattern: Make locally optimal decisions

3. **Space-Time Tradeoff**
   - Used in: Hash tables for O(1) lookup
   - Pattern: Use extra space to reduce time complexity

4. **Problem Simplification**
   - Used in: Breaking complex problems into simpler cases
   - Pattern: Solve for special cases first, then generalize

5. **Invariant Maintenance**
   - Used in: Dutch national flag problem
   - Pattern: Establish and maintain loop invariants

## Sorting Algorithms

### Bubble Sort
- **Description**: Simple comparison-based sorting algorithm
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Implementation**: Repeatedly swaps adjacent elements if in wrong order
- **Code Found In**: Test.java

### Selection Sort
- **Description**: In-place comparison sorting algorithm
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Implementation**: Repeatedly finds minimum element and places at beginning
- **Code Found In**: Test.java

### Insertion Sort
- **Description**: Builds sorted array one element at a time
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Implementation**: Compares each element with previous elements
- **Code Found In**: Test.java

### Counting Sort
- **Description**: Integer sorting algorithm that counts occurrences
- **Time Complexity**: O(n+k) where k is the range of input
- **Space Complexity**: O(k)
- **Implementation**: Uses counting array to track frequencies
- **Optimization**: Handles both positive and negative integers
- **Code Found In**: Test.java

### Sorting Algorithm Formulas and Complexities

| Algorithm | Formula/Approach | Time Complexity (Best/Avg/Worst) | Space Complexity | Stability | Key Characteristic |
|-----------|------------------|----------------------------------|------------------|-----------|-------------------|
| Bubble Sort | Repeatedly swap adjacent elements | O(n)/O(n²)/O(n²) | O(1) | Stable | Simple implementation |
| Selection Sort | Find min, place at beginning | O(n²)/O(n²)/O(n²) | O(1) | Unstable | Minimizes swaps |
| Insertion Sort | Build sorted array incrementally | O(n)/O(n²)/O(n²) | O(1) | Stable | Efficient for small arrays |
| Merge Sort | Divide, sort, merge | O(n log n)/O(n log n)/O(n log n) | O(n) | Stable | Guaranteed performance |
| Quick Sort | Partition around pivot | O(n log n)/O(n log n)/O(n²) | O(log n) | Unstable | Fast in practice |
| Heap Sort | Build max heap, extract max | O(n log n)/O(n log n)/O(n log n) | O(1) | Unstable | In-place, no quadratic worst-case |
| Counting Sort | Count occurrences, reconstruct | O(n+k)/O(n+k)/O(n+k) | O(n+k) | Stable | Linear time for small ranges |
| Radix Sort | Sort by each digit position | O(d(n+k))/O(d(n+k))/O(d(n+k)) | O(n+k) | Stable | No comparisons needed |

### Sorting Algorithm Selection Guide

| When to Use | Recommended Algorithm | Why |
|-------------|----------------------|-----|
| Small arrays (<50 elements) | Insertion Sort | Low overhead, good for nearly sorted data |
| General purpose sorting | Quick Sort or Merge Sort | Good average performance |
| Guaranteed performance needed | Merge Sort | No bad worst-case |
| Memory constraints | Heap Sort | In-place algorithm |
| Stability required | Merge Sort | Maintains relative order of equal elements |
| Integer data with small range | Counting Sort | Linear time complexity |
| External sorting (disk) | Merge Sort | Works well with sequential access |
| Partially sorted data | Insertion Sort | Takes advantage of existing order |

### Common Sorting Optimizations

1. **Hybrid Sorting**
   - Example: Timsort (Python's sort) - combines merge sort and insertion sort
   - Pattern: Use insertion sort for small subarrays in recursive algorithms

2. **Pivot Selection**
   - Example: Median-of-three in quicksort
   - Pattern: Better pivot choices reduce worst-case scenario probability

3. **Early Termination**
   - Example: Bubble sort with swapped flag
   - Pattern: Detect when array is already sorted

4. **Memory Usage**
   - Example: In-place merge sort variants
   - Pattern: Reduce auxiliary space requirements

## Data Structures

### Linked List
- **Description**: Linear data structure with elements linked using pointers
- **Operations**: Insertion, Deletion, Traversal
- **Time Complexity**: 
  - Access: O(n)
  - Search: O(n)
  - Insertion: O(1) when position is known
  - Deletion: O(1) when node is known

### Stack
- **Description**: LIFO (Last In First Out) data structure
- **Operations**: Push, Pop, Peek
- **Time Complexity**: O(1) for all operations
- **Applications**: Function calls, Expression evaluation, Backtracking

### Queue
- **Description**: FIFO (First In First Out) data structure
- **Operations**: Enqueue, Dequeue, Front, Rear
- **Time Complexity**: O(1) for all operations
- **Applications**: Job scheduling, Request handling

### Binary Tree
- **Description**: Hierarchical data structure with at most two children per node
- **Types**: Complete, Full, Perfect, Balanced
- **Operations**: Insertion, Deletion, Traversal (Inorder, Preorder, Postorder)
- **Time Complexity**: O(h) where h is height of tree, O(log n) for balanced trees

### Binary Search Tree
- **Description**: Binary tree with left child < parent < right child
- **Operations**: Search, Insert, Delete
- **Time Complexity**: O(h) where h is height, O(log n) for balanced BST
- **Applications**: Fast lookup, insertion, deletion when balanced

### Data Structure Operation Complexities

| Data Structure | Access | Search | Insertion | Deletion | Space | Key Characteristics |
|----------------|--------|--------|-----------|----------|-------|---------------------|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) | Contiguous memory, constant-time access |
| Linked List | O(n) | O(n) | O(1)* | O(1)* | O(n) | Dynamic size, efficient insertion/deletion |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) | LIFO access pattern |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) | FIFO access pattern |
| Hash Table | N/A | O(1) avg | O(1) avg | O(1) avg | O(n) | Fast lookup, insertion, deletion |
| Binary Search Tree | O(log n)** | O(log n)** | O(log n)** | O(log n)** | O(n) | Ordered operations |
| AVL Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) | Self-balancing |
| Red-Black Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) | Self-balancing with less rotation |
| B-Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) | Optimized for disk access |
| Heap | O(n) | O(n) | O(log n) | O(log n) | O(n) | Efficient min/max extraction |
| Trie | O(m) | O(m) | O(m) | O(m) | O(n*m) | Fast prefix searching |
| Graph | O(1)*** | O(V+E) | O(1) | O(V+E) | O(V+E) | Models relationships |

\* When position is known  
\** For balanced trees  
\*** With adjacency list and direct reference  

### Data Structure Implementation Techniques

| Data Structure | Key Implementation Techniques | Common Applications |
|----------------|-------------------------------|---------------------|
| Linked List | Node class with next/prev pointers | LRU cache, undo functionality |
| Stack | Array or linked list implementation | Expression evaluation, backtracking |
| Queue | Circular array or linked list | BFS, task scheduling |
| Hash Table | Collision resolution (chaining, open addressing) | Fast lookups, caches, sets |
| Binary Tree | Recursive operations, iterative traversals | Hierarchical data, expression trees |
| BST | Comparison-based insertion, deletion, lookup | Ordered maps, sets |
| Heap | Complete binary tree in array | Priority queues, heap sort |
| Trie | Multi-children nodes, character mapping | Auto-complete, spell checker |
| Graph | Adjacency matrix/list, edge list | Network flows, shortest paths |

### Data Structure Selection Guide

| When You Need | Consider Using | Because |
|---------------|----------------|---------|
| Fast lookups by key | Hash Table | O(1) average lookup time |
| Ordered data with fast search | BST | O(log n) ordered operations |
| Fast min/max operations | Heap | O(1) access to min/max element |
| Add/remove from ends only | Stack/Queue | O(1) operations at ends |
| String prefix matching | Trie | O(m) lookup where m is key length |
| Model relationships | Graph | Natural representation of connections |
| Frequent insertions/deletions | Linked List | O(1) operations with direct access |
| Cache with access ordering | LinkedHashMap | Combines hash table with order tracking |
| Nested data | Tree | Represents hierarchical relationships |

## Dynamic Programming

### Memoization Approach
- **Description**: Top-down approach that stores previously calculated results
- **Time Complexity**: Depends on problem, typically O(n) or O(n²)
- **Space Complexity**: O(n) or O(states in the problem)
- **Implementation**: Recursion with cached results
- **Applications**: Fibonacci, coin change, knapsack problems

### Tabulation Approach
- **Description**: Bottom-up approach that builds solution using smaller subproblems
- **Time Complexity**: Depends on problem, typically O(n) or O(n²)
- **Space Complexity**: O(n) or O(states in the problem)
- **Implementation**: Iterative approach using arrays/tables
- **Applications**: Longest common subsequence, edit distance, matrix chain multiplication

### DP Problem Types
- **1D Problems**: Linear state dependency (e.g., Fibonacci, climbing stairs)
- **2D Problems**: Matrix or two-variable dependency (e.g., grid paths, knapsack)
- **String Problems**: Operations on strings (e.g., edit distance, LCS)
- **Decision Problems**: True/false results (e.g., subset sum, partition equal subset)
- **Optimization Problems**: Maximize/minimize value (e.g., maximum subarray, coin change)

## Dynamic Programming Problem Patterns and Formulas

This section catalogs common DP problems by pattern, providing recurrence relations and implementation approaches.

### 1. Fibonacci-Type Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| Fibonacci | `F(n) = F(n-1) + F(n-2)` | `Fibonacci.java` | Bottom-up tabulation using array of size n+1 |
| Climbing Stairs | `ways(n) = ways(n-1) + ways(n-2)` | `ClimbingStairs.java` | Same as Fibonacci, represents ways to reach step n |
| House Robber | `rob(i) = max(rob(i-2) + nums[i], rob(i-1))` | `HouseRobber.java` | Cannot rob adjacent houses, maintain max value so far |
| Min Cost Climbing Stairs | `cost(i) = min(cost(i-1), cost(i-2)) + cost[i]` | `MinCostClimbingStairs.java` | Can start from step 0 or 1, minimum cost to reach top |

### 2. Knapsack-Type Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| 0/1 Knapsack | `dp[i][w] = max(dp[i-1][w], dp[i-1][w-wt[i]] + val[i])` | `Knapsack01.java` | 2D table: rows=items, columns=weights |
| Subset Sum | `dp[i][sum] = dp[i-1][sum] \|\| dp[i-1][sum-nums[i]]` | `SubsetSum.java` | Boolean DP array to track if sum is possible |
| Partition Equal Subset Sum | Same as Subset Sum with target = sum/2 | `EqualPartition.java` | Check if array can be divided into two equal sum parts |
| Coin Change | `dp[amount] = min(dp[amount], 1 + dp[amount-coin])` | `CoinChange.java` | Minimum number of coins to make given amount |
| Coin Change 2 | `dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]` | `CoinChange2.java` | Number of ways to make amount using coins |

### 3. String Manipulation Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| Longest Common Subsequence | `LCS[i][j] = 1 + LCS[i-1][j-1] if X[i] = Y[j] else max(LCS[i-1][j], LCS[i][j-1])` | `LCS.java` | 2D array to track common subsequence length |
| Edit Distance | `dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+cost)` | `EditDistance.java` | Minimum operations (insert, delete, replace) to convert string 1 to string 2 |
| Longest Palindromic Subsequence | `LPS[i][j] = 2 + LPS[i+1][j-1] if s[i] = s[j] else max(LPS[i+1][j], LPS[i][j-1])` | `LongestPalindromicSubsequence.java` | Find longest palindromic subsequence in string |
| Distinct Subsequences | `dp[i][j] = dp[i-1][j] + (s[i] == t[j] ? dp[i-1][j-1] : 0)` | `DistinctSubsequences.java` | Count number of distinct subsequences of t in s |

### 4. Matrix/Grid Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| Unique Paths | `dp[i][j] = dp[i-1][j] + dp[i][j-1]` | `UniquePaths.java` | Number of ways to reach bottom-right from top-left |
| Minimum Path Sum | `dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]` | `MinPathSum.java` | Minimum sum path from top-left to bottom-right |
| Dungeon Game | `dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])` | `DungeonGame.java` | Minimum initial health needed, work backward from bottom-right |
| Maximal Square | `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1 if matrix[i][j] = '1'` | `MaximalSquare.java` | Size of largest square containing only 1's |

### 5. Interval Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| Burst Balloons | `dp[i][j] = max(dp[i][j], dp[i][k-1] + dp[k+1][j] + nums[i-1]*nums[k]*nums[j+1])` | `BurstBalloons.java` | Maximum coins by strategically bursting balloons |
| Matrix Chain Multiplication | `dp[i][j] = min(dp[i][k] + dp[k+1][j] + dims[i-1]*dims[k]*dims[j])` | `MatrixChainMultiplication.java` | Minimum number of scalar multiplications |
| Palindrome Partitioning | `dp[i] = min(dp[j+1] + 1) for all j where s[i:j] is palindrome` | `PalindromePartitioning.java` | Minimum cuts needed to partition string into palindromes |

### 6. Decision Problems

| Problem | Recurrence Relation | Program | Approach Description |
|---------|---------------------|---------|----------------------|
| Jump Game | `dp[i] = any dp[j] where j < i and j + nums[j] >= i` | `JumpGame.java` | Boolean array to track if position is reachable |
| Word Break | `dp[i] = any dp[j] where s[j:i] is in wordDict` | `WordBreak.java` | Can string be segmented into dictionary words |
| Regex Matching | Complex - see code | `RegexMatching.java` | Match string with pattern including '*' and '.' |
| Interleaving String | `dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) \|\| (dp[i][j-1] && s2[j-1] == s3[i+j-1])` | `InterleavingString.java` | Can s3 be formed by interleaving s1 and s2 |

### DP Space Optimization Techniques

1. **Fibonacci Optimization**
   - Standard: O(n) time, O(n) space
   - Optimized: O(n) time, O(1) space
   - Technique: Only keep last two values

2. **2D to 1D Array Reduction**
   - Example: Knapsack
   - Standard: O(n*W) time, O(n*W) space
   - Optimized: O(n*W) time, O(W) space
   - Technique: Use single row and update in reverse

3. **State Compression**
   - Example: Travelling Salesman Problem
   - Technique: Use bitwise operations to represent states

### Common DP Implementation Pitfalls

1. **Base Case Errors**
   - Solution: Verify base cases with simple examples
   - Example: In LCS, initialize dp[i][0] and dp[0][j] correctly

2. **State Transition Mistakes**
   - Solution: Trace algorithm on small examples
   - Example: In Edit Distance, make sure to handle all operations

3. **Off-by-One Errors**
   - Solution: Be consistent with 0-indexed or 1-indexed arrays
   - Example: In Matrix Chain Multiplication, pay attention to array boundaries

4. **Overlapping States**
   - Solution: Ensure memoization cache covers all unique states
   - Example: In recursive solutions, pass all relevant parameters

## Segment Trees

### Basic Segment Tree
- **Description**: Tree-like data structure for range queries and updates
- **Time Complexity**: 
  - Build: O(n)
  - Query: O(log n)
  - Update: O(log n)
- **Space Complexity**: O(4*n)
- **Applications**: Range sum, min/max queries, range GCD

### Lazy Propagation
- **Description**: Optimization technique to handle range updates efficiently
- **Time Complexity**: Same as basic segment tree
- **Implementation**: Delay updates until necessary
- **Applications**: Range updates like add/multiply to a range

### Segment Tree Formulas and Operations

| Operation | Formula/Approach | Time Complexity | Space Complexity | Implementation Notes |
|-----------|------------------|-----------------|------------------|----------------------|
| Build Tree | `buildTree(arr, tree, node, start, end)` | O(n) | O(4*n) | Recursive construction from leaf to root |
| Point Update | `update(tree, node, start, end, idx, val)` | O(log n) | O(1) | Traverse from root to leaf, update path |
| Range Query | `query(tree, node, start, end, l, r)` | O(log n) | O(1) | Divide and conquer over ranges |
| Range Update (Lazy) | `updateRange(tree, lazy, node, start, end, l, r, val)` | O(log n) | O(1) | Mark lazy updates, propagate when needed |
| Next Larger Element | Segment tree with binary search | O(log² n) | O(n) | Useful for finding next greater/smaller element |
| Persistent Update | Create new nodes for changes | O(log n) | O(log n) per update | Maintains history of all versions |

## Advanced Algorithms

### Dynamic Programming
- **Description**: Breaking down problems into simpler subproblems
- **Examples**: Fibonacci, Knapsack, LCS
- **Properties**: Overlapping subproblems, Optimal substructure

### Graph Algorithms
- **Description**: Algorithms operating on graph data structures
- **Examples**: BFS, DFS, Dijkstra's, Prim's, Kruskal's
- **Applications**: Network routing, Social networks, Maps

### Advanced Algorithm Formulas and Complexities

| Algorithm Category | Representative Algorithms | Time Complexity | Space Complexity | Key Applications |
|--------------------|---------------------------|-----------------|------------------|------------------|
| Dynamic Programming | See DP section | Varies | Varies | Optimization problems, counting |
| Greedy Algorithms | Huffman coding, Dijkstra's | Varies | Varies | Optimization when greedy choice works |
| Divide and Conquer | Merge sort, Strassen's matrix | Usually O(n log n) | Usually O(n) | Breaking problems into subproblems |
| Backtracking | N-Queens, Sudoku solver | Exponential | Usually O(n) | Constraint satisfaction, puzzles |
| Graph Algorithms | BFS, DFS, Dijkstra's, Floyd-Warshall | Varies | Varies | Network analysis, pathfinding |

## Object-Oriented Programming

### Classes and Objects
- **Description**: Implementation of classes with proper encapsulation
- **Features**: Constructors, Methods, Access modifiers
- **Applications**: Modeling real-world entities

### Inheritance
- **Description**: Building relationships between classes
- **Types**: Single, Multiple (interfaces), Hierarchical
- **Applications**: Code reuse, Is-A relationships

### OOP Design Principles and Patterns

| Principle/Pattern | Description | Usage Example | Benefits |
|-------------------|-------------|---------------|----------|
| Encapsulation | Bundling data and methods, hiding implementation | Private fields with getters/setters | Information hiding, modularity |
| Inheritance | Creating new classes from existing ones | Vehicle → Car, Truck | Code reuse, hierarchical modeling |
| Polymorphism | Objects of different types through same interface | Shape.draw() for Circle, Rectangle | Flexibility, extensibility |
| Abstraction | Exposing essential features, hiding complexity | Abstract class Animal with speak() | Simplification, focus on relevant aspects |

## Utility Classes

### String Manipulation
- **Description**: Methods for string processing
- **Operations**: Searching, Matching, Transforming
- **Applications**: Text processing, Data validation

### File I/O
- **Description**: Reading from and writing to files
- **Types**: Text files, Binary files
- **Implementation**: Using streams, buffers
- **Applications**: Data persistence, Configuration

### Utility Class Implementation Techniques

| Utility Category | Common Operations | Implementation Approaches | Java Classes/Libraries |
|------------------|-------------------|---------------------------|------------------------|
| String Manipulation | Searching, matching, replacing | Regular expressions, string builders | String, StringBuilder, Pattern, Matcher |
| File I/O | Reading, writing, path operations | Streams, buffers, channels | File, Files, Path, BufferedReader, FileOutputStream |
| Date and Time | Parsing, formatting, arithmetic | Immutable date objects, formatters | LocalDate, LocalTime, LocalDateTime, DateTimeFormatter |

## Algorithm Application Patterns

This section provides a comprehensive reference for common algorithm patterns, when to use them, and their key characteristics.

| Pattern | When to Use | Key Formulas/Concepts | Time Complexity | Suitable Data Structures & Why |
|---------|-------------|----------------------|-----------------|--------------------------------|
| **Sliding Window** | • Fixed/variable size subarrays/substrings<br>• Finding max/min/average in subarrays<br>• String problems with window constraints | • Fixed window: `for (end = 0; end < n; end++) { add(end); if (end >= k-1) { process window; remove(start); start++; }`<br>• Variable window: `while (right < n) { expand window; while (condition violated) { contract window; } }`<br>• Window sum calculation: `windowSum += nums[end] - nums[start-1]` | • O(n) for most applications<br>• O(n×k) if window processing is complex | • **Array/String**: Direct access to elements<br>• **HashMap/HashSet**: Track frequencies or unique elements in window<br>• **Deque**: Maintain monotonic properties (e.g., max/min in window)<br>• Why: Need fast access to window elements and efficient updates as window slides |
| **Two Pointers** | • Sorted array problems<br>• Palindrome verification<br>• Removing duplicates<br>• Finding pairs/triplets with conditions | • Opposite direction: `left=0, right=n-1; while (left < right) {...}`<br>• Same direction: `slow=0, fast=0; while (fast < n) {...}`<br>• Dutch national flag: `while (mid <= high) { if (arr[mid] == 0) swap(low++, mid++); else if (arr[mid] == 1) mid++; else swap(mid, high--); }` | • O(n) for most applications<br>• O(n²) for nested iterations (e.g., 3Sum) | • **Array**: Fast random access for pointer movement<br>• **LinkedList**: For slow/fast pointer problems<br>• **StringBuilder**: For in-place string manipulation<br>• Why: Need direct access to elements at arbitrary positions for comparison and swapping |
| **Fast & Slow Pointers** | • Cycle detection in linked lists<br>• Finding middle element<br>• Finding kth element from end<br>• Palindrome linked list | • Floyd's cycle detection: `slow = head, fast = head; while (fast && fast.next) { slow = slow.next; fast = fast.next.next; if (slow == fast) return true; }`<br>• Finding middle: `while (fast && fast.next) { slow = slow.next; fast = fast.next.next; }`<br>• Cycle start: After meeting, reset one pointer to head and move both at same pace | • O(n) time<br>• O(1) space (key advantage) | • **LinkedList**: Natural fit for traversal with different speeds<br>• Why: Linked structure allows nodes to be traversed at different rates without extra space for tracking visited nodes |
| **Merge Intervals** | • Schedule/meeting problems<br>• Interval merging/insertion<br>• Coverage/overlap problems | • Sort intervals by start time: `Arrays.sort(intervals, (a, b) -> a[0] - b[0])`<br>• Merge logic: `if (current.end >= next.start) { current.end = Math.max(current.end, next.end); }`<br>• Non-overlapping intervals: Check `current.end <= next.start` | • O(n log n) due to sorting<br>• O(n) for linear scan after sorting | • **Array/ArrayList**: For storing and sorting intervals<br>• **PriorityQueue**: For problems requiring minimum/maximum end times<br>• **TreeMap**: For efficient interval search operations<br>• Why: Need to sort intervals and perform sequential processing with occasional lookups |
| **Cyclic Sort** | • Arrays containing 1 to n values<br>• Finding missing/duplicate numbers<br>• When array elements map to indices | • Core idea: `nums[i]` should be at position `nums[i] - 1`<br>• Algorithm: `while (nums[i] != i + 1 && nums[i] <= n) { swap(nums, i, nums[i] - 1); }`<br>• Finding missing: Elements not at correct positions<br>• For 0 to n-1 range: `nums[i]` should be at position `nums[i]` | • O(n) time<br>• O(1) space (in-place) | • **Array**: Direct in-place swapping capabilities<br>• Why: Relies on direct index-to-value mapping and requires constant-time element swapping |
| **In-place Reversal of Linked List** | • Linked list reversal problems<br>• K-group reversal<br>• Alternating reversal | • Basic reversal: `prev = null, current = head; while (current) { next = current.next; current.next = prev; prev = current; current = next; }`<br>• K-group: Reverse each group separately<br>• Remember to store the connections between groups | • O(n) time<br>• O(1) space | • **LinkedList**: Natural choice for pointer manipulation<br>• Why: Enables O(1) pointer reassignments for reversals without extra space |
| **Binary Search** | • Sorted arrays/matrices<br>• Monotonic functions<br>• Search space reduction<br>• "Find the minimum value that satisfies condition" | • Basic: `while (left <= right) { mid = left + (right - left) / 2; if (target < arr[mid]) right = mid - 1; else if (target > arr[mid]) left = mid + 1; else return mid; }`<br>• Lower bound: `if (condition(mid)) right = mid; else left = mid + 1;`<br>• Upper bound: `if (condition(mid)) left = mid; else right = mid - 1;` | • O(log n) time<br>• O(1) space (iterative)<br>• O(log n) space (recursive) | • **Array**: Random access needed for mid-point calculation<br>• **Binary Search Tree**: For more complex search operations<br>• Why: Requires O(1) access to middle elements to enable divide and conquer approach |
| **DFS/BFS** | • Tree/graph traversal<br>• Path finding<br>• Connected components<br>• Topological ordering | • DFS (recursive): `void dfs(node) { visit(node); for (neighbor : node.neighbors) { if (!visited[neighbor]) dfs(neighbor); } }`<br>• BFS (queue): `queue.offer(start); while (!queue.isEmpty()) { node = queue.poll(); for (neighbor : node.neighbors) { if (!visited[neighbor]) { visit(neighbor); queue.offer(neighbor); } } }`<br>• DFS uses stack (implicit or explicit), BFS uses queue | • O(V + E) time<br>• O(V) space<br>• BFS finds shortest path in unweighted graphs | • **Adjacency List/Matrix**: For graph representation<br>• **Queue**: For BFS level-order traversal<br>• **Stack/Recursion**: For DFS depth-first traversal<br>• **HashSet/Array**: To track visited nodes<br>• Why: Queue ensures level-by-level exploration; stack/recursion enables backtracking |
| **Backtracking** | • Combinatorial problems<br>• Constraint satisfaction<br>• Permutations/combinations<br>• Puzzle solving | • Pattern: `void backtrack(state, choices) { if (isSolution(state)) { add(state); return; } for (choice : choices) { if (isValid(choice)) { apply(choice); backtrack(newState, remainingChoices); undo(choice); } } }`<br>• Decision tree exploration<br>• Pruning: Early termination of paths that can't lead to solutions | • O(branches^depth) often exponential<br>• Space complexity depends on recursion depth | • **Recursion Stack**: To manage state exploration<br>• **ArrayList/StringBuilder**: For state building and backtracking<br>• **HashSet**: For constraint checking<br>• Why: Recursion naturally implements the stack needed for depth-first exploration with backtracking capability |
| **Dynamic Programming** | • Optimization problems<br>• Counting problems<br>• Problems with overlapping subproblems | • Memoization (top-down): `dp(state) { if (memo.contains(state)) return memo[state]; result = recurrence_relation(state); memo[state] = result; return result; }`<br>• Tabulation (bottom-up): Build table from base cases<br>• State transitions: Express current state in terms of previous states | • Time: O(states × transitions)<br>• Space: O(states) or O(states × recursion depth) | • **Array/Matrix**: For tabulation approach<br>• **HashMap**: For memoization with complex states<br>• **Recursion + Map**: For top-down approach<br>• Why: Arrays provide O(1) access to previous states; maps handle non-sequential states efficiently |
| **Greedy Algorithm** | • Making locally optimal choices<br>• When local optimum leads to global optimum<br>• Activity selection, Huffman coding | • Sort by some criteria (start time, end time, ratio)<br>• Make best choice at each step without reconsidering<br>• Activity selection: `sort by end time; select earliest ending compatible activity`<br>• Fractional knapsack: `sort by value/weight ratio; take items in ratio order` | • Often O(n log n) due to sorting<br>• O(n) for selection phase | • **PriorityQueue/Heap**: For selecting optimal choice at each step<br>• **Array**: For sorting by criteria<br>• **Greedy Choice Array**: To track selected items<br>• Why: Heaps efficiently extract the next best choice; sorted arrays enable sequential processing by optimization criteria |
| **Bit Manipulation** | • Optimizing space/time<br>• Low-level operations<br>• Flags and states representation | • Set bit: `num \| (1 << pos)`<br>• Clear bit: `num & ~(1 << pos)`<br>• Toggle bit: `num ^ (1 << pos)`<br>• Check bit: `(num >> pos) & 1`<br>• Clear rightmost set bit: `num & (num - 1)`<br>• Isolate rightmost set bit: `num & -num`<br>• Power of 2: `(n & (n-1)) == 0` | • O(1) for most bit operations<br>• O(log n) or O(number of bits) for iteration | • **Primitive Integer Types**: Direct bit manipulation<br>• **BitSet**: For large bit arrays<br>• Why: Provides direct access to binary representation with efficient bit-level operations |
| **Topological Sort** | • Directed Acyclic Graphs (DAGs)<br>• Dependency resolution<br>• Task scheduling<br>• Course prerequisites | • Kahn's algorithm: `Start with nodes having 0 in-degree; Process node and decrement neighbor in-degrees; Add to queue when in-degree becomes 0`<br>• DFS approach: `Perform DFS and add nodes to result in reverse post-order`<br>• Cycle detection: If topological sort doesn't include all vertices, graph has cycle | • O(V + E) time<br>• O(V) space | • **Adjacency List**: Graph representation<br>• **Queue**: For Kahn's algorithm processing nodes with 0 in-degree<br>• **Stack**: For DFS-based approach to store post-order<br>• **HashMap/Array**: For tracking in-degrees<br>• Why: Queue enables processing nodes in correct dependency order; adjacency list provides efficient edge traversal |
| **Union-Find (Disjoint Set)** | • Connected components<br>• Cycle detection in undirected graphs<br>• Dynamic connectivity<br>• Kruskal's MST algorithm | • Operations: `find(x)` and `union(x, y)`<br>• Path compression: `find(x) { if (x != parent[x]) parent[x] = find(parent[x]); return parent[x]; }`<br>• Union by rank: `if (rank[rootX] < rank[rootY]) parent[rootX] = rootY; else { parent[rootY] = rootX; if (rank[rootX] == rank[rootY]) rank[rootX]++; }` | • Nearly O(1) amortized per operation with optimizations<br>• O(n) space | • **Array**: For parent and rank tracking<br>• **Custom DisjointSet Class**: Encapsulating operations<br>• Why: Arrays provide O(1) access to parent relationships; simple structure enables path compression optimizations |
| **Trie (Prefix Tree)** | • String prefix operations<br>• Autocomplete/spell checking<br>• Dictionary implementations<br>• IP routing | • Structure: Tree where each node has multiple children (often 26 for lowercase letters)<br>• Each path from root represents a string/prefix<br>• Operations: `insert(word)`, `search(word)`, `startsWith(prefix)`<br>• Often uses terminal nodes or boolean flags to mark complete words | • O(m) time for operations where m is key length<br>• O(n×m) space where n is number of keys | • **Custom TrieNode Class**: With children array/map<br>• **HashMap/Array**: For storing children at each node<br>• Why: Tree structure naturally represents character sequences; array/map of children enables efficient prefix-based operations |
