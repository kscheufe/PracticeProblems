class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """

        targetMap = {}
        output = ""
        currentMap = {}

        """add target chars to dictionary"""
        for char in t:
            if char in targetMap:
                targetMap[char]+=1
            else:
                targetMap[char]=1

        """now iterate through string s"""
        left = 0
        formedChars = 0
        requiredChars = len(targetMap)
        min_len = float('inf')
        for right in range(0, len(s)):
            """if char not needed"""
            if (s[right] not in targetMap):
                continue

            """otherwise, add/increment it in current list"""
            if (s[right] in currentMap):
                currentMap[s[right]]+=1
            else:
                currentMap[s[right]] = 1

            """now check if there's enough characters in currentMap"""
            if currentMap[s[right]] == targetMap[s[right]]:
                    formedChars += 1
            
            """and if there are, try to shorten from the beginning"""
            while formedChars == requiredChars and left <= right:
                window_len = right - left + 1
                if window_len < min_len:
                    min_len = window_len
                    output = s[left:right + 1]

                # Remove the leftmost character from the window
                left_char = s[left]
                if left_char in targetMap:
                    if currentMap[left_char] == targetMap[left_char]:
                        formedChars -= 1
                    currentMap[left_char] -= 1
                    if currentMap[left_char] == 0:
                        del currentMap[left_char]

                left += 1

        return output