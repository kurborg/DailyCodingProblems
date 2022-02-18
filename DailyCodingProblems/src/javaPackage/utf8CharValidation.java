package javaPackage;

public class utf8CharValidation {
    

    // Time Complexity is O(n) because we process n integers
    // in the array then use 8 char String for each integer

    // Space Complexity is O(1) because we use a string for 
    // each int in the array to use, but throw it away after each int
    public static boolean stringManipulationSolution(int[] arr)
    {

        int numBytesToProcess = 0;

        // loop through all integers in the arr (main loop)
        for(int i = 0; i < arr.length; i++)
        {
            // convert each int to bin string
            String binRep = Integer.toBinaryString(arr[i]);

            //System.out.println("Int: " + i + " Before manipulation " + binRep);

            // only get 8 least sig bits and if less then add 0's to binRep
            binRep = binRep.length() >= 8 ? binRep.substring(binRep.length() -  8) :
            "00000000".substring(binRep.length()%8) + binRep;

            //System.out.println("Int: " + i + " After manipulation " + binRep);

            // Processing new UTF Char
            if(numBytesToProcess == 0)
            {
                // Count starting 1's to get numBytes in Char
                for(int j = 0; j < binRep.length(); j++)
                {
                    if(binRep.charAt(j) == '0')
                        break;

                    numBytesToProcess++;
                }

                // This is a 1 byte UTF char so continue to the next integer in the array
                if(numBytesToProcess == 0)
                    continue;

                // Return false on invalid cases
                if(numBytesToProcess > 4 || numBytesToProcess == 1)
                {
                    return false;
                }
            }

            else{ // Byte is a succeeding byte in the UTF char

                if(binRep.charAt(0) != '1' && binRep.charAt(1) != '0')
                    return false;

                numBytesToProcess--;
            }
        }
        
        return numBytesToProcess == 0;
    }

    public static boolean bitManipulationSolution(int[] arr)
    {
        /*
        mask = 1 << 7 1000 0000
        mask1 = 1 << 7
        mask2 = 1 << 6

        Case 1: it's first byte of char which means that 
         we only care about first N bits, max 4
         so we get num of bytes in char by & with mask
         then shifting mask after each run
        Case 2: it's a succeeding byte which means we only 
         we only care about first 2 most sig bits so we can use 
         mask 1 & num and mask 2 & num to see if it returns 1 and 0
         and if it doesnt then return false
        */
        int numBytes = 0;

        int mask1 = 1 << 7; // 1000 0000
        int mask2 = 1 << 6; // 0100 0000

        for(int i = 0; i < arr.length; i++)
        {
            // first byte case
            if(numBytes == 0)
            {
                int mask = 1 << 7;

                while((mask & arr[i]) != 0)
                {
                    numBytes++;
                    mask = mask >> 1;
                }

                if(numBytes == 0)
                    continue;
            
                // return false for invalid cases
                if(numBytes > 4 || numBytes == 1)
                    return false;
            }
            // second byte case
            else
            {
                if(((arr[i] & mask1) != 1 && (mask2 & arr[i]) != 0))
                    return false;

                numBytes--;
            }
        }
        
        return numBytes == 0;
        
    }

    public static void main(String[] args)
    {
        int[] arr1 = new int[] {197, 130, 1};
        
        System.out.println(stringManipulationSolution(arr1));

        int[] arr2 = new int[] {197, 130, 1};

        System.out.println(bitManipulationSolution(arr2));

    }
}
