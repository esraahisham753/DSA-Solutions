"""
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

You are given an array of strings sentences, where each sentences[i] represents a single sentence.

Return the maximum number of words that appear in a single sentence.
"""

class Solution(object):
    def mostWordsFound(self, sentences):
        """
        :type sentences: List[str]
        :rtype: int
        """
        max_num_words = 0

        for i in range(len(sentences)):
            max_num_words = max(max_num_words, sentences[i].count(' ') + 1)
        
        return max_num_words