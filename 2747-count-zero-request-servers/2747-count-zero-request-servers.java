class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] q) {
    Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
    int[][] arr=new int[q.length][2];
     for(int i=0;i<q.length;i++){
        arr[i][0]=q[i];// val
        arr[i][1]=i;//  original idx
     }
     int[] ans=new int[q.length];
  Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
    
     HashMap<Integer,Integer> map=new HashMap<>();
     int j=0;
     int left=0;
     for(int i=0;i<arr.length;i++){
        int start=arr[i][0]-x;
        int end=arr[i][0];
       
        while(j<logs.length  &&  logs[j][1]<=end){
           int id = logs[j][0];
              map.put(id, map.getOrDefault(id, 0) + 1);

                j++;

        }//remove the left
        while(left < j && logs[left][1] < start) {
    int id = logs[left][0];

    if(map.get(id) == 1) {
        map.remove(id);
    } else {
        map.put(id, map.get(id) - 1);
    }

   left++;
}
int count=map.size();
int a=n-count;
 ans[arr[i][1]] = a;

     }
        
    return ans;

    }
}