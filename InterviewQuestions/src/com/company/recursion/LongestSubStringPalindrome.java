package com.company.recursion;

public class LongestSubStringPalindrome
{

  
  public String longestPalindrome(String originalString, int startIndex, String currentString)
   {
        if(startIndex==originalString.length())
          {
             return currentString;
          }
        
        int i = startIndex + 2;
        while(i <= originalString.length())
         {
            String s = originalString.substring(startIndex,i);
            if(isPalindrome(s))
             {
                if(currentString.length() < s.length())
                   currentString = s;
             }
            i++;
         }     
 
        startIndex = startIndex + 1;
      return longestPalindrome(originalString,startIndex,currentString);
   }

   public boolean isPalindrome(String s)
   {
      for(int i=0;i<s.length();i++)
       {
          if(s.charAt(i)!=s.charAt(s.length()-1-i))
               return false;   
       }
     return true;
   }

  public static void main(String[] args)
   {
     LongestSubStringPalindrome palindrome = new LongestSubStringPalindrome();
     String longestPalindrome = palindrome.longestPalindrome("pandsrrsdnapngrtgeeksskeeg", 0, "");
     System.out.println(longestPalindrome);
   } 

}