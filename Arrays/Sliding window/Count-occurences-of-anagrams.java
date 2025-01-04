class Count-occurences-of-anagrams {

    int search(String pat, String txt) {
        int start, end;
        start=end=0;
        Map<Character, Integer> map = getMapWithCharCount(pat);
        int counter = map.size();
        int result =0;
        while(end<txt.length()){
            //decrement the count of char in map if it is present in txt. when value of the char becomes zero decrement counter;
            if(map.containsKey(txt.charAt(end))){
                int value = map.get(txt.charAt(end));
                if(value ==1){
                    counter--;
                }
                map.put(txt.charAt(end),value-1);
            }
            if(end-start+1<pat.length()){
                end++;
            }else{
                //if counter equals zero means all chars present in anagram are present in subarray.
                if(counter==0){
                    result++;
                }
                //increment the count of char at start index if it is present in map. This is done before updating start
                if(map.containsKey(txt.charAt(start))){
                    int value = map.get(txt.charAt(start));
                    if(value ==0){
                        counter++;
                    }
                    map.put(txt.charAt(start),value+1);
                }
                start++;
                end++;
            }
        }
        return result;
    }
	
	
	//create the map with char in the anagrams and their count
    private static  Map<Character, Integer> getMapWithCharCount(String pat ){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : pat.toCharArray()){
            map.merge(c,1, (oldValue, newValue)->oldValue+newValue);
        }
        return map;
    }
}