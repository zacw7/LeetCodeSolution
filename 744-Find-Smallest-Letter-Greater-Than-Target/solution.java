class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        if (letters[low] >= target) high = low;
        if (letters[high] <= target) low = high;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (letters[mid] == target) {
                high = mid + 1;
                break;
            }
            if (letters[mid] < target) low = mid;
            else high = mid;
        }
        while (high < letters.length && letters[high] <= target) high++;
        return (high >= letters.length) ? letters[0] : letters[high];
    }
}