class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList(arr.length);
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (o1, o2) -> Math.abs(o1 - x) == Math.abs(o2 - x)
                ? o1 - o2 : Math.abs(o1 - x) - Math.abs(o2 - x));
        list = list.subList(0, k);
        Collections.sort(list);
        return list;
    }
}