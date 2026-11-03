
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        // Step 1: Count frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Store all frequencies in ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        for (int freq : map.values()) {
            list.add(freq);
        }

        // Step 3: Sort frequencies in ascending order
        Collections.sort(list);

        // Step 4: Remove elements having minimum frequency
        int unique = map.size();

        for (int i = 0; i < list.size(); i++) {

            if (k >= list.get(i)) {
                k = k - list.get(i);
                unique--;
            } 
            else {
                break;
            }
        }

        return unique;
    }
}
