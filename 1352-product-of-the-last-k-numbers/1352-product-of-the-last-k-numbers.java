class ProductOfNumbers {

    ArrayList<Integer> prefix = new ArrayList<>();

    public ProductOfNumbers() {
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
        } else {
            if (prefix.isEmpty()) {
                prefix.add(num);
            } else {
                prefix.add(prefix.get(prefix.size() - 1) * num);
            }
        }
    }

    public int getProduct(int k) {
        if (k > prefix.size()) {
            return 0;
        }

        int n = prefix.size();

        if (k == n) {
            return prefix.get(n - 1);
        }

        return prefix.get(n - 1) / prefix.get(n - k - 1);
    }
}