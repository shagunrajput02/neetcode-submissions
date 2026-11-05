class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length]; //new array of same length

        int prefix=1; //prefix 

        for(int i=0; i<nums.length; i++){ //storing product of everything before each position
            answer[i] = prefix;
            prefix *= nums[i];
        }
        
        int suffix = 1;
        for(int i=nums.length -1 ; i>=0;i--){
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}  
