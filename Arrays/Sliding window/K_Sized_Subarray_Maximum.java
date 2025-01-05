//GFG problem link - https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class K_Sized_Subarray_Maximum
 {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
         int start, end;
        start=end=0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        int max=0;
        while(end<arr.length){
            //Before adding element to deque check if elements greater than curr element are present in deque if yes remove them and then add cuurent element
            while(!maxQueue.isEmpty() && maxQueue.getLast()<arr[end]){
                maxQueue.removeLast();
            }
            maxQueue.add(arr[end]);
            if(end-start+1<k){
                end++;
            }else{
                result.add(maxQueue.peek());
                //before updating start index check if it was present in deque and remove it from deque.
                if(!maxQueue.isEmpty() && maxQueue.getFirst()==arr[start]){
                    maxQueue.removeFirst();
                }
                start++;
                end++;
            }
        }
        return result;
    }
}