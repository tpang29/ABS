# ABS - Algorithms by Step
This program aims to help the user developer a clearer understanding of the actions taken during each step of common algorithms.
# Usage

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
Bubble Sort|b
Bubble Sort, optimized|c
Insertion Sort|i
Insertion Sort, optimized|j

# Examples

Jump to..
- [Bubble Sort](#Bubble-Sort)
- [Bubble Sort Optimized](#Bubble-Sort-Optimized)
- [Insertion Sort](#Insertion-Sort)
- [Insertion Sort Optimized](#Insertion-Sort-Optimized)

## [Bubble Sort](#Examples)
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

## [Bubble Sort, optimized](#Examples)
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

## [Insertion Sort](#Examples)
```
User-MacBook-Pro:src user$ java Sorting -i 2 1 3 4
Before insertion sort: [2, 1, 3, 4]

Starting pass 1, array is: [2, 1, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 1 with 2         swapped 2 with 1         [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 1, array is: [1, 2, 3, 4]


Starting pass 2, array is: [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 3 with 2         none                     [1, 2, 3, 4]
compare 2 with 1         none                     [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 2, array is: [1, 2, 3, 4]


Starting pass 3, array is: [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 4 with 3         none                     [1, 2, 3, 4]
compare 3 with 2         none                     [1, 2, 3, 4]
compare 2 with 1         none                     [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 3, array is: [1, 2, 3, 4]


After insertion sort: [1, 2, 3, 4]
```

## [Insertion Sort, optimized](#Examples)
```
User-MacBook-Pro:src user$ java Sorting -j 2 1 3 4
Before insertion sort optimized: [2, 1, 3, 4]

Starting pass 1, array is: [2, 1, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 1 with 2         swapped 2 with 1         [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 1, array is: [1, 2, 3, 4]


Starting pass 2, array is: [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 3 with 2         none                     [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 2, array is: [1, 2, 3, 4]


Starting pass 3, array is: [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
Comparing                Action                   Array State
--------------------------------------------------------------------------------------------------------------
compare 4 with 3         none                     [1, 2, 3, 4]
--------------------------------------------------------------------------------------------------------------
After pass 3, array is: [1, 2, 3, 4]


After insertion sort optimized: [1, 2, 3, 4]
```