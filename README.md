# Week 1 Project — Calculator App

## Context
I lost a bet with a friend and he challenged me that for the next 52 weeks, during weekends I need to create from scratch a new project.  

Since this is the first week and I’ve never created one before, we decided to start with the classic **calculator app**.  

### The rules are the following:
- Each Friday night, me and him will talk about what project I need to do.  
- Mostly he will decide for me, but I’m allowed to suggest and do my own ideas if he agrees on.  
- Once the project is decided, he will tell me if I’m allowed to work Saturday **and** Sunday, or only Sunday.  
  (Surely this won’t backfire at some point by underestimating a project, right? 😅)

---

## About the project
The main framework used is **Swing** to create the UI.  

The way it calculates the result is by creating a string. Each time the user presses one of the buttons, it adds to the initial string.  

Once the user presses the `=` button, the method `evaluate()` is called which returns either the result or an `"error"` message if the string is not a valid equation.

---

## Features
The calculator supports:

- **Simple mathematical functions**: `+`, `-`, `*`, `/`  
- **Modulo, radical and logarithmic functions**: `%`, `√`, `log`, `ln`  
- **Trigonometric functions**: `sin`, `cos`, `tan`, `cot`  
- **Predefined constants**: `π` and `e` (Euler's number)  
- **Juxtaposition notation**:  
  - `5cos(60)` → calculated as `5 * cos(60)`  
  - `20log(12+5)` → calculated as `20 * log(12+5)`
