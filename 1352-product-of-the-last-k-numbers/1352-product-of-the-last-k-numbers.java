class ProductOfNumbers {
     
       ArrayList<Integer> nums=new ArrayList<>();
         ArrayList<Integer> prefix=new ArrayList<>();
    public ProductOfNumbers() {
     
    }
    
    public void add(int num) {
        if(num==0){
            prefix.clear();
            return;
        }
       if (!prefix.isEmpty()) {
   prefix.add(prefix.get(prefix.size() - 1) * num);
       }else{
         prefix.add(num);
       }
      nums.add(num);
    
      
       

    }
    
    public int getProduct(int k) {
        if(k>prefix.size()){
            return 0;
        }else if(prefix.size()==k){
          return prefix.get(prefix.size() - 1);
        }else{
            return prefix.get(prefix.size() - 1)/prefix.get(prefix.size()-k-1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */