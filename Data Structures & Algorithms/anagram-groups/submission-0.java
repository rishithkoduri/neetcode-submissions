class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str : strs){
            char strarr[] = str.toCharArray();
            Arrays.sort(strarr);
            String nstr = new String(strarr);
            if(map.containsKey(nstr)){
                map.get(nstr).add(str);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(nstr, temp);
            }
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}
