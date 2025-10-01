// This solution uses an approach iterating from right to left
// Every time we decrement, we store the max element encountered so far. and just continue if its the case as no greater element can be found right side
// For elements lesser than max encountered so far, we have to traverse until greater element is found. To make this faster we use a days variable which starts from 1 i.e., next element
// We keep incrementing it by the number difference of next element as greater element is definitely after that distance
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int max = temperatures[temperatures.length-1], days = 1;
        int[] result = new int[temperatures.length];
        for(int i=temperatures.length-2;i>=0;i--) {
            if(temperatures[i]>=max) {
                max = temperatures[i];
                continue;
            }

            if(temperatures[i+1]>temperatures[i]) {
                result[i] = 1;
                continue;
            }

            days=1;
            while(temperatures[i+days]<=temperatures[i]) {
                days+=result[i+days];
            }
            result[i]=days;
        }

        return result;
    }
}

