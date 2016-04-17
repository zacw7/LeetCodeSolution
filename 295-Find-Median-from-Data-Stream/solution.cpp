class MedianFinder {
public:
    // Adds a number into the data structure.
    void addNum(int num) {
        int size = nums.size();
        if(size) {
            int left = 0;
            int right = size-1;
            if(num > nums.at(right)) {
                nums.push_back(num);
            } else if(num < nums.at(0)) {
                nums.insert(nums.begin(), num);
            } else {
                int mid = (left+right)/2;
                while(left < mid) {
                    int mid = (left+right)/2;
                    if(nums.at(mid) == num) break;
                    left = (nums.at(mid) < num) ? mid : left;
                    right = (nums.at(mid) > num) ? mid : right;
                }
                nums.insert(nums.begin()+mid, num);
            }
            median = (median*(size-1)+num)/size;
        } else {
            nums.push_back(num);
            median = num;
        }
    }

    // Returns the median of current data stream
    double findMedian() {
        return median;
    }
private:
    vector<int> nums;
    double median;
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();