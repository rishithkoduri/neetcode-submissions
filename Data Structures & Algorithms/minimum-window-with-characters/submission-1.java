class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
        }
        int left = 0;
        int start = 0, end = 0;
        int count = 0;
        for(int right=0; right<s.length(); right++){
            char rch = s.charAt(right);
            if(tmap.containsKey(rch)){
                map.put(rch, map.getOrDefault(rch, 0)+1);
                if(map.get(rch) <= tmap.get(rch)) count++;
            }
            while(count==t.length()){
                int len = right-left+1;
                if(len<minLen){
                    minLen = len;
                    start = left;
                    end = right;
                }
                char lch = s.charAt(left);
                if(tmap.containsKey(lch)){
                    map.put(lch, map.get(lch)-1);
                    if(map.get(lch)<tmap.get(lch)) count--;
                }
                left++;
            }
        }
        return (minLen==Integer.MAX_VALUE) ? "" : s.substring(start, end+1);
    }
}
