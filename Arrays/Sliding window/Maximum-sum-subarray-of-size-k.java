GFG problem link - https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/

class Maximum-sum-subarray-of-size-k {
    public int maximumSumSubarray(int[] arr, int k) {
        int start, end;
        start=end=0;
        int max,sum;
        max=sum=0;
        while(end<arr.length){
            sum=sum+arr[end];
            if(end-start+1<k){
                end++;
            }else if(end-start+1==k){
                max= max>sum?max:sum;
                sum=sum-arr[start];
                start++;
                end++;
            }
        }
        return max;
    }
}