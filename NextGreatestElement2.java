// This solution uses a two fold approach to go over the array twice
// First iteration we keep adding elements to stack and resolve the possible lesser elements prior to each index
// For second iteration we resolve unresolved elements until the point when the circle reaches the same index as there is no point to go over a complete array iteration again
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack();
        int[] response = new int[n];
        for(int i=0;i<2*n;i++) {

            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]) {
                int j = stack.pop();
                response[j%n] = nums[i%n];
            }
           
            if(i<n) {
                response[i]=-1;
                stack.push(i);
            } else if(i%n==stack.peek()) break;
        }
        return response;
    }
}

