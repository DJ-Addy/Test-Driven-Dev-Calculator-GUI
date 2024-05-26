
* Calculator

Running Instructions:
```bash

./gradlew.bat build    

./gradlew.bat run

```
* NOTE:
You need one space before every operator and function and parathesis
Normal expression: "1+1^(2*3)"
Calculator type to function: "1 + 1 ^ ( 2 * 3 )"

* If you use the buttons instead of typing in expressions it works well 

* App
App.java
This holds the JAVA FX application and attaches the stylesheet

* Calculator
Calc.java
Holds serval important methods for calculator that allows a expression string to be enter and outputs the evalutated expression string

isOperator() boolean for if a token is a operator
isFunction() boolean for if a token starts a function, ei trig functions, log, sqrt
getPrecedence() Int takes char and checks priority of operation
functionHandler() Void takes input string and checks for functions locations evaluates it and pushes it on to the stack that holds values
processOperator() Void takes char t which is some operator and evalues the subexpression ei (1 + 1) process operator(+)
processInput() String return Double. Parses a mathematical expression represented as a string, evaluates it using a stack-based approach, and returns the result. It handles numeric values, operators (+, -, *, /, %, ^), functions (e.g., sin, cos), and parentheses, ensuring proper precedence and syntax.
//TODO 
Find a way to Tokenize the string expression without using spaces 


* test/java/AppTest.java

Tests processing input for mathimatical functionality.

