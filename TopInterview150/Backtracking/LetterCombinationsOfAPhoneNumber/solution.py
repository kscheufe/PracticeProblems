class Solution(object):
    #String digits, int index, StringBuilder comb, List<String> result, Map<Character, String> map
    def recurse(self, digits, index, comb, result, map):
        """
        :type digits: str
        :type index: int
        :type comb: str
        :type result: List[str]
        :type map: Map{char: str]
        :rType: null
        """

        if index == len(digits):
            result.append("".join(comb))
            return
        
        for char in map[digits[index]]:
            comb.append(char)
            self.recurse(digits, index+1, comb, result, map)
            comb.pop()


    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        result = []
        if len(digits) == 0 or digits == '':
            return []
        map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        self.recurse(digits, 0, [], result, map)
        return result
    
   
