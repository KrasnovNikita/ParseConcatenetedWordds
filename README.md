# ParseConcatenetedWords

Task

We have provided a file called “wordsforproblem.txt” which contains a sorted list of
approximately 173,000 words. The words are listed one word per line, do not contain spaces,
and are all lowercase.
Your task is to write a program that reads the file and provides the following:
❖ the longest concatenated word (that is, the longest word that is comprised entirely of
shorter words in the file)
❖ the 2nd longest concatenated word
❖ the total count of all the concatenated words in the file
For example, if the file contained:
cat
cats
catsdogcats
dog
dogcatsdog
hippopotamuses
rat
ratcatdogcat
The longest concatenated word would be 'ratcatdogcat' with 12 characters. ‘hippopotamuses’ is
a longer word, however it is not comprised entirely of shorter words in the list. The 2nd longest
concatenated word is ‘catsdogcats’ with 11 characters. The total number of concatenated words
is 3. Note that ‘cats’ is not a concatenated word because there is no word ‘s’ in the list.

Solution:

I have the following algorithm:
1) Load all words in the ArrayList;
2) Sort the words in the ArrayList in the descending order (from higher to lower), because you need to start checking from the largest word;
3) Pass through the ArrayList in two cycles: the first cycle starts with the first value, the second cycle with the value of the First + 1 index. If the first value contains a string from the second value, replace it with an empty string ""; checking in the second cycle starts with a word whose length is less than or equal to the "First Word -2" length, since the word can be concatenated from two words, the length of one of which is 2. If the length of the first word is 3, then the check is interrupted, because, in this case, the word can not be concatenated from one letter and a word of two letters;
4) As a result, words that are concatenated will be replaced by an empty string "".The indexes of empty lines are added  and moved to a separate ArrayList and the we can find the largest concatenated word;
5) Delete it, repeat step 4 and find the second longest concatenated word.

Result:
Quantity of fully cancateneted words: 81143

The longest concatenated word: ethylenediaminetetraacetates

The second longest concateneted word: electroencephalographically
