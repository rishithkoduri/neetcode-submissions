class sortByValue implements Comparator<Map.Entry<Integer, Integer>>{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
        if(o1.getValue().equals(o2.getValue())) return o2.getKey()-o1.getKey();
        return o2.getValue() - o1.getValue();
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        int top[] = new int[k];
        Map<Integer, Integer> frequency = new HashMap<>();
        for(Integer i : nums){
            frequency.put(i, frequency.getOrDefault(i, 0)+1);
        }
        Set<Map.Entry<Integer, Integer>> setOf = frequency.entrySet();
        List<Map.Entry<Integer, Integer>> listOf = new ArrayList<>(setOf);
        Collections.sort(listOf, new sortByValue());
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : listOf){
            if(count == k){
                break;
            }
            top[count] = entry.getKey();
            count += 1;
        }
        return top;
    }
}