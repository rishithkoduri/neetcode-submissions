class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zero_count = 0;
        int total_product = 1;
        for(int num : nums){
            if(num!=0) total_product *= num;
            else zero_count++;
        }
        int result[] = new int[n];
        int ptr = 0;
        for(int num : nums){
            if(zero_count>=2) result[ptr++] = 0;
            else if (zero_count==1){
                if(num==0) result[ptr++] = (total_product);
                else result[ptr++] = 0;
            }
            else result[ptr++] = total_product/num;
        }

        return result;
    }
}  
