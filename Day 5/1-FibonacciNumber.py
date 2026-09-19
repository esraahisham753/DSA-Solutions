"""
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
"""

class Solution:
    def __init__(self):
        self.res = []

    def fib_rec(self, n):
        if n == 0:
            self.res[0] = 0
            return 0
        if n == 1:
            self.res[1] = 1
            return 1
        if self.res[n] != 0:
            return self.res[n]
        
        self.res[n] = self.fib_rec(n-1) + self.fib_rec(n-2)
        
        return self.res[n]

    def fib(self, n: int) -> int:
        self.res = [0] * (n + 1)

        return self.fib_rec(n)


        


        

        