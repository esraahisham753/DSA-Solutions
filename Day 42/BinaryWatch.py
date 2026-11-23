# A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

# For example, the below binary watch reads "4:51".

# Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

# The hour must not contain a leading zero.

# For example, "01:00" is not valid. It should be "1:00".
# The minute must consist of two digits and may contain a leading zero.

# For example, "10:2" is not valid. It should be "10:02".

class Solution:
    def readBinaryWatch(self, turnedOn: int) -> list[str]:
        output = []

        def dfs(ind, h, turnOn, hours, minutes):
            if hours > 11 or minutes > 59:
                return 

            if turnOn == turnedOn:
                timing = f"{hours}:{minutes:02}"
                output.append(timing)
                return
            
            if ind == 64:
                return

            # choose to turn on
            if h:
                hours += ind
            else:
                minutes += ind

            turnOn += 1

            # explore
            newInd = ind
            newH = h

            if h and newInd == 8:
                newH = False
                newInd = 1
            else:
                newInd *= 2

            dfs(newInd, newH, turnOn, hours, minutes) 
            
            # unchoose
            if h: 
                hours -= ind
            else:
                minutes -= ind
            
            turnOn -= 1

            # choose not to turn on
            dfs(newInd, newH, turnOn, hours, minutes)

        dfs(1, True, 0, 0, 0)

        return output
            