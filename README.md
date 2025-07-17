# Java-Programming

A collection of algorithms and data structures implemented in Java.

## Table of Contents
- [Search Algorithms](#search-algorithms)
- [Array Operations](#array-operations)
- [Subarray Algorithms](#subarray-algorithms)
- [Algorithmic Problems](#algorithmic-problems)
- [Sorting Algorithms](#sorting-algorithms)
- [Data Structures](#data-structures)
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

## Advanced Algorithms

### Dynamic Programming
- **Description**: Breaking down problems into simpler subproblems
- **Examples**: Fibonacci, Knapsack, LCS
- **Properties**: Overlapping subproblems, Optimal substructure

### Graph Algorithms
- **Description**: Algorithms operating on graph data structures
- **Examples**: BFS, DFS, Dijkstra's, Prim's, Kruskal's
- **Applications**: Network routing, Social networks, Maps

### Divide and Conquer
- **Description**: Breaking problems into subproblems, solving separately, combining
- **Examples**: Merge Sort, Quick Sort, Binary Search
- **Applications**: Efficient searching and sorting

### Greedy Algorithms
- **Description**: Making locally optimal choices at each stage
- **Examples**: Huffman Coding, Fractional Knapsack, Prim's
- **Applications**: Optimization problems

## Object-Oriented Programming

### Classes and Objects
- **Description**: Implementation of classes with proper encapsulation
- **Features**: Constructors, Methods, Access modifiers
- **Applications**: Modeling real-world entities

### Inheritance
- **Description**: Building relationships between classes
- **Types**: Single, Multiple (interfaces), Hierarchical
- **Applications**: Code reuse, Is-A relationships

### Polymorphism
- **Description**: Method overloading and overriding
- **Types**: Compile-time (Overloading), Runtime (Overriding)
- **Applications**: Flexible and extensible code

### Abstraction
- **Description**: Hiding implementation details, showing functionality
- **Implementation**: Abstract classes, Interfaces
- **Applications**: Creating frameworks, APIs

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

### Date and Time
- **Description**: Date manipulation and formatting
- **Implementation**: Using java.time package
- **Applications**: Scheduling, Logging, User interfaces

### Collections
- **Description**: Framework for working with groups of objects
- **Types**: Lists, Sets, Maps, Queues
- **Implementation**: ArrayList, HashSet, HashMap, etc.
- **Applications**: Data management, Algorithms

## Algorithm Application Patterns

This section identifies common problem patterns and which algorithms are best suited to solve them.

### Search and Find Problems

| Problem Pattern | Suitable Algorithm | Time Complexity | Example in Code |
|-----------------|-------------------|-----------------|-----------------|
| Finding element in unsorted array | Linear Search | O(n) | `linearSearch()` |
| Finding element in sorted array | Binary Search | O(log n) | `binarySearch()` |
| Finding min/max value | Single-pass traversal | O(n) | `largest()`, `smallest()` |
| Checking for duplicates | Nested loops comparison | O(n²) | `isDistinct()` |

### Array Transformation Problems

| Problem Pattern | Suitable Algorithm | Time Complexity | Example in Code |
|-----------------|-------------------|-----------------|-----------------|
| Reversing array elements | Two-pointer technique | O(n) | `reverseArray()` |
| Generating all pairs | Nested loops | O(n²) | `arrayPairs()` |
| Generating all subarrays | Triple nested loops | O(n³) | `SubArray()` |
| Sorting small arrays or nearly sorted data | Insertion Sort | O(n²) | `insertionSort()` |
| Sorting arrays with limited range of integers | Counting Sort | O(n+k) | `countingSort()` |

### Optimization Problems

| Problem Pattern | Suitable Algorithm | Time Complexity | Example in Code |
|-----------------|-------------------|-----------------|-----------------|
| Maximum subarray sum | Kadane's Algorithm | O(n) | `kadanesAlgo()` |
| Best time to buy/sell stock | Single-pass tracking | O(n) | `buyAndSellStock()` |
| Trapping rain water | Auxiliary arrays technique | O(n) | `trappedWater()` |

### When to Use Each Sorting Algorithm

| Algorithm | Best For | Avoid When | Example in Code |
|-----------|----------|------------|-----------------|
| Bubble Sort | Educational purposes, tiny arrays | Performance is critical | `bubbleSort()` |
| Selection Sort | Minimizing memory writes | Large datasets | `selectionSort()` |
| Insertion Sort | Nearly sorted data, online algorithm | Large random arrays | `insertionSort()` |
| Counting Sort | Small range of integer keys | Non-integer data, large ranges | `countingSort()` |

### Common Algorithm Techniques in Code

1. **Two-Pointer Technique**
   - Used in: Array reversal, trapping rain water
   - Pattern: Maintain two pointers that move toward each other or in same direction

2. **Sliding Window**
   - Used in: Kadane's Algorithm (implicit)
   - Pattern: Maintain a "window" that expands or contracts as needed

3. **Prefix Computation**
   - Used in: Maximum subarray sum using prefix approach
   - Pattern: Precompute cumulative values to enable efficient range queries

4. **Greedy Approach**
   - Used in: Buy and sell stock problem
   - Pattern: Make locally optimal choice at each step

5. **Auxiliary Data Structures**
   - Used in: Trapping rain water (left/right max arrays)
   - Pattern: Precompute and store values to avoid repeated calculations
