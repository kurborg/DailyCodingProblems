package java;

//Given an input string and a dictionary of words
//find out if the input string can be segmented into
//a space-separated sequence of dictionary words. See
//examples for more details

//Consider the following dictionary
//{i, like, sam, sung, samsung, mobile, ice, cream
//icecream, man, go, mango}

//Input: ilike
//Output: yes
//The string can be segmented as "i like"

//Input: iliksamsung
//output: yes
//the string can be segmented as "i like samsung"
//or "i like sam sung"


import java.util.*;

//Recursive implementation of
//word break problem in java
class wordBreakProblem{
	
	//set to hold dictionary values
	private static Set<String> dictionary = new HashSet<>();
	
	public static void main(String [] args)
	{
		String temp_dictionary[] = {"mobile", "samsung", "sam",
				"sung", "man", "mango", "icecream", "and", "go",
				"i", "like", "ice", "cream"};
		
		//loop to add all strings in dictionary set
		for(String temp: temp_dictionary)
			dictionary.add(temp);
		
		//sample input cases
		System.out.println(wordBreak("ilikesamsung"));
		System.out.println(wordBreak("iiiiiiii"));
		System.out.println(wordBreak(""));
		System.out.println(wordBreak("ilikelikeimangoiii"));
		System.out.println(wordBreak("samsungandmango"));
		System.out.println(wordBreak("samsungandmangok"));
		}
	
	//returns true if the word can be segmented into parts
	//such that each part is contained in dictionary
	public static boolean wordBreak(String word)
	{
		int size = word.length();
		
		//base case
		if(size == 0)	
			return true;
		
		//else check for all words
		for (int i = 0; i <= size; i++)
		{
			//Now we will first divide the word into parts,
			//the prefix will have a length of i and check if it is
			//present in dictionary, if yes then we will check for 
			//suffix of length size-i recursively. If both prefix and 
			//suffix are present the word is found in dictionary.
			if(dictionary.contains(word.substring(0,i)) &&
					wordBreak(word.substring(i,size)))	
				return true;
		}
		
		return false;
	}
}
