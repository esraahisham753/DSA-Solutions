# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

# A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        output = []
        numToChars = {
            2: 0,
            3: 3,
            4: 6,
            5: 9,
            6: 12,
            7: 15,
            8: 19,
            9: 22
        }

        def getDigitStart(digit, curChar):
            return chr(ord('a') + numToChars[int(digit)] + curChar)
        
        def dfs(ind, path):
            if ind == len(digits):
                newPath = path
                output.append(newPath)
                return

            count = 3
            #print(f"ind: {ind}")
            if digits[ind] == "7" or digits[ind] == "9":
                count = 4
            
            #print(f"count: {count}")

            for c in range(count):
                # choose
                newChar = getDigitStart(digits[ind], c)
                path += newChar

                # explore
                dfs(ind + 1, path)

                # unchoose
                path = path[: -1]
        
        dfs(0, "")

        return output
            
