Context:
I lost a bet with a friend and he challenged me that for the next 52 weeks, during weekends I need to create from scratch a new project and since is first week and I never created one, we decided to start with the old good calculator app.
The rules are the following:
-Each friday night, me and him will talk about what project I need to do. Mostly he will decide for me but Im allowed to suggest and do my own ideas if he agrees on.
-Once the project is decided he will tell me if Im allowed to work saturday and sunday or only sunday(surelly this won't backfire at some point underestimating a project, right?)

About the project:
The main framework used is swing to create the UI. The way it calculates the result is by creating a string, each time the user presses one of the buttons it adds to the initial string.
Once the user presses the "=" button the method evaluate is called which returns either the result or "error" message if the string is not a valid equation.

The calculator supports:
-Simple mathematical functions: +, -, *, /.
-Modulo, radical and logarithmic functions: %, √, log, ln.
-Trigonometric functions: sin, cos, tan, cot.
-Predefined π and e(Euler's number).
-Juxtaposition notation: 5cos(60) is calculated as 5*cos(60), 20log(12+5) is calculated as 20*log(12+5)
