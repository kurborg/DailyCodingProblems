import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.stream.Stream;

// Verifies if there is a match between 2 elements in an integer array for a target number
// using multiple different solutions
public class twoSum{
	
	public static void main(String[] args) {

		int[] nums = new int[] {2, 4, 5, 6, 8, 10};
		int targ1 = 8;
		int targ2 = 14;
		int targ3 = 12;
		
		int[] ans1 = bruteForceMethod(nums, targ1);
		System.out.println("First method answer: ");
		for(int i = 0; i < ans1.length; i++)
		{
			System.out.println("Index " + ans1[i]);
		}
		
//		int[] ans2 = twoPassHashTable(nums, targ2);
//		System.out.println("third method answer: ");
//		for(int i = 0; i < ans1.length; i++)
//		{
//			System.out.println(" " + ans2[i]);
//		}
		
		int[] ans3 = onePassHashTable(nums, targ3);
		System.out.println("third method answer: ");
		for(int i = 0; i < ans1.length; i++)
		{
			System.out.println("Index " + ans3[i]);
		}
		
	}
	
	// O(n^2) complexity because have to iterate through array twice searching for
	// a complement
	public static int[] bruteForceMethod(int[] nums, int target ) {
		
		for(int i = 0; i < nums.length; i++)	{
			int complement = target - nums[i];
			for(int j = i + 1; j < nums.length; j++) {
				
				if(nums[j] == complement)
					return new int[] {i,j};
				
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	
	// Faster as it maps the index and the element of each array which allows
	// for fast lookup with mapping. O(n) time complexity and O(n) space complexity
	// because we have to store exactly n elements in the hash table
	public static int[] twoPassHashTable(int[] nums, int target ) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < map.size(); i++) {
			map.put(nums[i], i); // value at index (key), index
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)&& map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	
	// Time complexity is still O(n) but we traverse the list containing n elements only
	// once. Each look up table costs only O(1) time. Space complexity: O(n) stores
	// at most n elements
	public static int[] onePassHashTable(int[] nums, int target ) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement))
				return new int[] {i, map.get(complement)};
			
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
}