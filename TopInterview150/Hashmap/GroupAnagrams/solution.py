class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        output = []
        map = {}
        for str in strs:
            temp = ''.join(sorted(str))
            if temp not in map:
                map[temp] = []
            map[temp].append(str)

        for key in map:
            output.append(map[key])

        return output