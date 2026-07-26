class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int majorityElement(int[] arr) {
        //  2 2 1 1 1 2 2 
        // sort -> 1 1 1 2 2 2 2 
        // Arrays.sort(nums); // BuiltIn Sort -> O(n*log n)
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>=1; j--){
                if(arr[j] < arr[j-1])
                    swap(arr, j, j-1);
                else break;
            }
        }
        return arr[arr.length/2];
    }
}