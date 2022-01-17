package slidingWindow.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hackerrank: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 
Given a chocolate bar, two children, Lily and Ron, are determining how to share it. Each of the squares has an integer on it.
Lily decides to share a contiguous segment of the bar selected such that:
The length of the segment matches Ron's birth month, and,
The sum of the integers on the squares is equal to his birth day.

You must determine how many ways she can divide the chocolate.

Consider the chocolate bar as an array of squares, s=[2,2,1,3,2]. She wants to find segments summing to Ron's birth day, d=4
with a length equalling his birth month,m=2. In this case, there are two segments meeting her criteria:[2,2] and [1,3].

s: an array of integers, the numbers on each of the squares of chocolate
d: an integer, Ron's birth day
m: an integer, Ron's birth month
 *
 */
public class SubarrayDivision {
	
	public static int birthday(List<Integer> s, int d, int m) {
        //sliding window
        //find no.of subsets sum equals to d where window length is m
        
        int count = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < s.size()){
            sum += s.get(j);
            if(j-i+1 < m){
                j++;
            }
            else if(j-i+1 == m){
                if(sum == d)
                    count++;
                sum -= s.get(i);
                i++;
                j++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(birthday(Arrays.asList(1,2,1,3,2), 3, 2));	//2 = {1,2} and {2,1}
	}

}
