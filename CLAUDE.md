# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java-based data structure and algorithm study repository. It contains implementations of classic data structures, algorithm problem solutions from various online judges (BOJ, LeetCode, Programmers, Softeer), and course materials from Inflearn courses.

## Build & Run

This is an IntelliJ IDEA project with no build tool (Maven/Gradle). Each Java file contains its own `main` method and can be run independently.

**To compile and run a single file:**
```bash
# From project root
javac -d out src/path/to/File.java
java -cp out package.name.ClassName
```

**To run in IntelliJ:** Right-click on any Java file and select "Run".

## Code Architecture

### `/src/structure/`
Data structure implementations from "Do it! 자료구조와 함께 배우는 알고리즘 입문" book:
- `chap01-03`: Basic algorithms (max, median, search)
- `chap04`: Stack and Queue implementations (IntStack, IntQueue, GenericStack, etc.)
- `chap05`: Recursion (factorial, Hanoi tower, Eight Queens)
- `chap06`: Sorting algorithms (QuickSort, MergeSort, HeapSort, ShellSort, BubbleSort)

### `/src/algorithm/`
Algorithm problem solutions organized by source:
- `inflearn/`, `inflearn2/`, `inflearn3/`, `inflearn4/`: Inflearn course problems by section (string, array, sliding window, hash, stack/queue, search, sort, graph, tree)
- `book/`: Problems from algorithm books (question001.java, question002.java, etc.)
- `boj/`: Baekjoon Online Judge solutions
- `leetcode/`: LeetCode solutions
- `programmers/`: Programmers solutions
- `softeer/`: Softeer solutions
- `review/`: Review/practice problems

## Conventions

- Algorithm solutions typically use `BufferedReader`/`StringTokenizer` for fast I/O (competitive programming style)
- Each solution file is self-contained with its own `main` method
- Package names match directory structure
- File naming: lowercase for algorithm problems (e.g., `solution4.java`, `boj3190.java`), PascalCase for data structures (e.g., `QuickSort.java`)
