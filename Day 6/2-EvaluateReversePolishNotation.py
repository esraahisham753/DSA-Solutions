"""
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
"""

class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []

        for token in tokens:
            if token == "+":
                stack.append(str(int(stack.pop()) + int(stack.pop())))
            elif token == "*":
                stack.append(str(int(stack.pop()) * int(stack.pop())))
            elif token == "-":
                num2 = int(stack.pop())
                num1 = int(stack.pop())
                stack.append(str(num1 - num2))
            elif token == "/":
                num2 = int(stack.pop())
                num1 = int(stack.pop())
                abs_division = abs(num1) // abs(num2)
                
                if abs_division > 0 and (num1 * num2 < 0):
                    stack.append(abs_division * -1)
                else:
                    stack.append(abs_division)
            else:
                stack.append(token)
        
        return int(stack[0])
        
