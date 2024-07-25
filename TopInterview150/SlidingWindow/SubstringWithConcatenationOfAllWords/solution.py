class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        output = []
        numWords = len(words)
        wordLen = len(words[0])
        windowLength = numWords*wordLen

        if len(s) < windowLength:
            return output
        
        targetCountsMap = {}

        for word in words:
            if word in targetCountsMap:
                targetCountsMap[word]+=1
            else:
                targetCountsMap[word] = 1

        for i in range(wordLen):
            """iterate over each possible starting index of the first word"""
            left = i
            right = i
            currCountMap = {}
            count = 0

            while (right + wordLen <= len(s)):
                word = s[right:right+wordLen]
                right += wordLen

                if word not in targetCountsMap:
                    currCountMap.clear()
                    count = 0
                    left = right
                else:
                    if word in currCountMap:
                        currCountMap[word] +=1
                    else:
                        currCountMap[word] = 1
                    count+=1
                    while currCountMap[word] > targetCountsMap[word]:
                        leftWord = s[left:left+wordLen]
                        currCountMap[leftWord]-=1
                        count-=1
                        left += wordLen
                    if count == numWords:
                        output.append(left)
        return output