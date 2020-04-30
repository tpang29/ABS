# ABS - Algorithms by Step
This program aims to help the user developer a clearer understanding of the actions taken during each step of common algorithms.

Jump to...
- [Usage](#Usage)
- [Examples](#Examples)

# [Usage](#ABS---Algorithms-by-Step)

## Setup
- download the `src` folder 
- navigate into `src`
- compile all source files with `javac *.java`

## Run
- `java Sorting -option [integer1, ..., integerN]`
- Press the `Enter` or `Return` key to step through the algorithm until complete
- Use `control` + `c` to terminate during execution

## Options
Currently, there are four algorithms from which to choose. They are as follows:

Name|Option
:-|:-:
[Bubble Sort](#Bubble-Sort)|b
[Bubble Sort Optimized](#Bubble-Sort-Optimized)|c
[Insertion Sort](#Insertion-Sort)|i

# [Examples](#ABS---Algorithms-by-Step)

## [Bubble Sort](#Options)
```
User-MacBook-Pro:src User$ java Sorting -b 3 2 1
Before bubble sort: [3, 2, 1]

Starting pass 1, array is: [3, 2, 1]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 3 with 2         swapped 3 with 2         [2, 3, 1]
compare 3 with 1         swapped 3 with 1         [2, 1, 3]
--------------------------------------------------------------------------------------------------------------
After pass 1, array is: [2, 1, 3]


Starting pass 2, array is: [2, 1, 3]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 2 with 1         swapped 2 with 1         [1, 2, 3]
compare 2 with 3         none                     [1, 2, 3]
--------------------------------------------------------------------------------------------------------------
After pass 2, array is: [1, 2, 3]


After bubble sort: [1, 2, 3]
```

## [Bubble Sort Optimized](#Options)
```
User-MacBook-Pro:src User$ java Sorting -c 3 2 1
Before bubble sort optimized: [3, 2, 1]

Starting pass 1, array is: [3, 2, 1]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 3 with 2         swapped 3 with 2         [2, 3, 1]
compare 3 with 1         swapped 3 with 1         [2, 1, 3]
--------------------------------------------------------------------------------------------------------------
After pass 1, array is: [2, 1, 3]


Starting pass 2, array is: [2, 1, 3]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 2 with 1         swapped 2 with 1         [1, 2, 3]
--------------------------------------------------------------------------------------------------------------
After pass 2, array is: [1, 2, 3]


After bubble sort optimized: [1, 2, 3]
```

## [Insertion Sort](#Options)
```
User-MacBook-Pro:src user$ java Sorting -i 3 2 1
Before insertion sort: [3, 2, 1]

Starting pass 1, array is: [3, 2, 1]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 2 with 3         replace 2 with 3         [3, 3, 1]
found insert position    replace 3 with 2         [2, 3, 1]
--------------------------------------------------------------------------------------------------------------
After pass 1, array is: [2, 3, 1]


Starting pass 2, array is: [2, 3, 1]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 1 with 3         replace 1 with 3         [2, 3, 3]
compare 1 with 2         replace 3 with 2         [2, 2, 3]
found insert position    replace 2 with 1         [1, 2, 3]
--------------------------------------------------------------------------------------------------------------
After pass 2, array is: [1, 2, 3]


After insertion sort: [1, 2, 3]
```