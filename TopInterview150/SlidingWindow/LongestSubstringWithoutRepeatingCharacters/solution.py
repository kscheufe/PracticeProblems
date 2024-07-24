class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        p1 = 0
        longestLength = 0
        for p2 in range(0, len(s)):
            print(p1, p2, longestLength)
            """if s[p2] exists, move p1 up"""
            while p1 < p2 and s[p2] in s[p1:p2]:
                p1+=1
            """add p2 to substring (increment p2)"""
            longestLength = max(longestLength, p2-p1+1)
            p2+=1
            
        return longestLength
    
  