class Solution {
    public boolean isAnagram(String s, String t) {
        char sarr[] = s.toCharArray();
        char tarr[] = t.toCharArray();

        Arrays.sort(sarr);  Arrays.sort(tarr);

        String ns = new String(sarr);
        String nt = new String(tarr);

        if(ns.equals(nt)) return true;

        return false;
    }
}
