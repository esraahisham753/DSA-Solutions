/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Note: The characters in the array beyond the returned length do not matter and should be ignored.
*/

class Solution {
    public int compress(char[] chars) {
        int slow = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else if (count >= 10) {
                chars[slow++] = chars[i - 1];

                String countStr = String.valueOf(count);

                for (char digit : countStr.toCharArray()) {
                    chars[slow++] = digit;
                }

                count = 1;
            } else if (count > 1) {
                chars[slow++] = chars[i - 1];
                chars[slow++] = (char) ('0' + count);
                count = 1;
            } else {
                chars[slow++] = chars[i - 1];
            }
        }

        chars[slow++] = chars[chars.length - 1];

        if (count >= 10) {
            String countStr = String.valueOf(count);

            for (char digit : countStr.toCharArray()) {
                chars[slow++] = digit;
            }
        } else if (count > 1) {
            chars[slow++] = (char) ('0' + count);
        }

        return slow;
    }
}