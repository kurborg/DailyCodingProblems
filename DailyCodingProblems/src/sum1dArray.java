public class sum1dArray {
    
    public static void main(String[] args) {
		
        int nums1[] = {1, 2, 3, 4};
        int nums2[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int nums3[] = {17, 2, 0, 4, 3, 9, 7, 8};

        sum1dArray solution = new sum1dArray();
        
        int checkFlag = 0;

        int actualAns1[] = {1, 3, 6, 10};
        int actualAns2[] = {1, 3, 6, 10, 15, 21, 28, 36};
        int actualAns3[] = {17, 19, 19, 23, 26, 35, 42, 50};

        int expectedAnsw1[] = solution.runningSum(nums1);
        int expectedAnsw2[] =solution.runningSum(nums2);
        int expectedAnsw3[] =solution.runningSum(nums3);

        //Array 1
        for(int i = 0; i < expectedAnsw1.length; i++){
            if(expectedAnsw1[i] == actualAns1[i]){

            }
            else{
                checkFlag = 1;
            }
        }

        if(checkFlag == 1)
            System.out.println("Incorrect!");
        else
            System.out.println("Correct!");

        //Array 2
        for(int i = 0; i < expectedAnsw2.length; i++){
            if(expectedAnsw2[i] == actualAns2[i]){

            }
            else{
                checkFlag = 1;
            }
        }
    
        if(checkFlag == 1)
            System.out.println("Incorrect!");
        else
            System.out.println("Correct!");

        //Array 3
        for(int i = 0; i < expectedAnsw3.length; i++){
            if(expectedAnsw3[i] == actualAns3[i]){
            }
            else{
                checkFlag = 1;
            }
        }
        
        if(checkFlag == 1)
            System.out.println("Incorrect!");
        else
            System.out.println("Correct!");


	}

        public int[] runningSum(int[] nums) {
            int answer[] = new int[nums.length];
            int temp = 0;
            
            for(int i = 0; i < nums.length; i++){
                answer[i] = temp + nums[i];
                temp = temp + nums[i];
            }
            
            return answer;
        }
}
