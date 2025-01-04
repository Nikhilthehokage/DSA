
//GFG problem link - https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

Class First-negative-integer-in-every-window-of-size-k{
	
	static List<Integer> FirstNegativeInteger(int arr[], int k) {
			 int start, end;
			start=end=0;
			List<Integer> negativeIntegersIfPresent = new ArrayList<>();
			//list to store all negative elements in array
			List<Integer> negativeIntegers = new ArrayList<>();
			int trackNegativeInteger =0;
			while(end<arr.length){
				if(arr[end]<0){
					negativeIntegers.add(arr[end]);
				}
				if(end-start+1<k){
					end++;
				}else{
					if(negativeIntegers.size()<=trackNegativeInteger){
						negativeIntegersIfPresent.add(0);
					}else{
						negativeIntegersIfPresent.add(negativeIntegers.get(trackNegativeInteger));
					}
					//remove negative number from negativeIntegers before updating start index
					if(negativeIntegers.size()>trackNegativeInteger && arr[start]==negativeIntegers.get(trackNegativeInteger)){
						trackNegativeInteger++;
					}
					start++;
					end++;
				}
			}
			return negativeIntegersIfPresent;
		}
}