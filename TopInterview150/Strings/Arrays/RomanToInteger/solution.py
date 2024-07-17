class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        total = 0
        x = len(s) -1

        """
            for x in range(len(s)-1, -1, -1):
            can't modify x in python after loop initialization
        """
        while (x >=0):
            if (s[x] == "I"):
                total += 1
            elif (s[x] == "V"):
                print(s[x-1])
                if (x != 0 and s[x-1] == "I"):
                    total += 4
                    x-=1
                else:
                    total += 5
            elif (s[x] == "X"):
                if (x != 0 and s[x-1] == "I"):
                    total += 9
                    x-=1
                else:
                    total += 10
            elif (s[x] == "L"):
                if (x != 0 and s[x-1] == "X"):
                    total += 40
                    x-=1
                else:
                    total += 50
            elif (s[x] == "C"):
                if (x != 0 and s[x-1] == "X"):
                    total += 90
                    x-=1
                else:
                    total += 100
            elif (s[x] == "D"):
                if (x != 0 and s[x-1] == "C"):
                    total += 400
                    x-=1
                else:
                    total += 500
            elif (s[x] == "M"):
                if (x != 0 and s[x-1] == "C"):
                    total += 900
                    x-=1
                else:
                    total += 1000
            x-=1
        return total