package java;

class MedianOfTwoSortedArrayOfDifferentLength {
    public double findMedianSortedArrays(int[] A, int[] B) {
        
        // Making sure larger array is at B
        if(A.length>B.length){
            return findMedianSortedArrays(B, A);
        }
        
        int aLen = A.length;
        int bLen = B.length;
        int low = 0;
        int high = aLen;
        
        while(low <= high){
            int partitionX = (low + high) /2; //Dividing A to find median
            int partitionY = (aLen + bLen +1)/2 - partitionX; //Setting median of B equal to the half len - i since
            // aLen is larger and B is the larger array
          
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX -1];
            int minRightX = (partitionX == aLen) ? Integer.MAX_VALUE : A[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
            int minRightY = (partitionY == bLen) ? Integer.MAX_VALUE : B[partitionY];
            
            if( maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((aLen + bLen) % 2 == 0) //even so must find avg of 2 middle nums
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX)) /2.0;
            
                else // odd so can just find median of both arrays
                	return Math.max(maxLeftX, maxLeftY);
            }
            
            
            else if(maxLeftX > minRightY)
                high = partitionX -1;
            else
                low = partitionX + 1;
        }
        
        throw new IllegalArgumentException();
}
    
    public static void main(String[] args) {
        
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 25};
        
        // aLen = 5
        // bLen = 5
        
        // low = 0
        // high = 5
        
        // partitionX = 2
        // partitionY = 3
        
        // 1st loop:
        // maxLeftX = 3
        // minRightX = 8
        // maxLeftY = 19
        // minRightY = 21
        
        // 2nd loop:
        // maxLeftX = 8
        // minRightX = 9
        // maxLeftY = 11
        // minRightY = 19
        
        // 3rd loop:
        // maxLeftX = 9
        // minRightX = 15
        // maxLeftY = 7
        // minRightY = 11
        
        //max(7,9) = 9, min(11, 15) = 11
        // 11 + 9 /2 = 10 (ANSWER)
        
        // 1, 3, 7, 8, 9, 11, 15, 19, 21, 25
        // Median is 9 + 11 /2 = 10
        MedianOfTwoSortedArrayOfDifferentLength solution = new MedianOfTwoSortedArrayOfDifferentLength();
        System.out.println(solution.findMedianSortedArrays(x, y));
    }
    
}