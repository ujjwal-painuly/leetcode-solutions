class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];



           while(low < high) {
    int mid = low + (high-low)/2;

    // Count elements <= mid
   int row = n - 1;
int col = 0;
int count = 0;

while(row >= 0 && col < m) {
    if(matrix[row][col] <= mid) {
        count += row + 1;
        col++;
    } else {
        row--;
    }
}


 if(count < k) {
    low = mid + 1;
} else {
    high = mid;
}
}
return low;
    }
}