
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {

            int count = map.getOrDefault(x, 0);

            if(count == ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(count).add(x);

            map.put(x, count + 1);
        }

        return ans;
    }
}
