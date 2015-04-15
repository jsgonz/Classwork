public class HW3 {

	public static boolean isValid(long number){
		
		int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		
		if(getSize(number) >= 13 && getSize(number)<=16){
			
			if(prefixMatched(number, 1)){
				
				if((total % 10) == 0){
					
					return true;
				}else{
					
					return false;
				}
			}else{
				
				return false;
			}
		}else{
			
			return false;
		}
	}
	
	public static int sumOfDoubleEvenPlace(long number){
		
		int result = 0;
		long temp = 0;
		
		while(number > 0){
			
			temp = number % 100;
			result += getDigit((int)(temp/10) *2);
			number = number / 100;
		}
		
		return result;
	}
	
	public static int getDigit(int number){
		
		int fDigit = number % 10;
		int sDigit = number / 10;
		
		return fDigit + sDigit;
	}
	
	public static int sumOfOddPlace(long number){
		
		int result = 0;
		
		while(number > 0){
			
			result += (number%10);
			number = number / 100;
		}
		
		return result;
	}
	
	public static boolean prefixMatched(long number, int d){
		
		if((getPrefix(number, d)) == 4 || 
			(getPrefix(number, d)) == 5 || 
			(getPrefix(number, d)) == 6 || 
			(getPrefix(number, d)) == 37){
			
			return true;
		}else{
			
			return false;
		}
	}
	
	public static int getSize(long d){
		
		int numOfInts = 0;
		
		while(d > 0){
			
			d = d / 10;
			numOfInts ++;
		}
		
		return numOfInts;
	}
	
	public static long getPrefix(long number, int k){
		
		int size = getSize(number);
		long temp = number;
		
		for(int i = 0; i < (size - k); i++){
			
			number = number/10;
			
			if(number == 4 || number == 5 || number == 6){
				
				break;
			}else if(number == 3){
				
				for(int j = 0; j < (size - (k + 1)); j++){
					
					temp = temp/10;
					
					if(temp == 37){
						
						number = temp;
						break;
					}
				}
			}
		}
		
		return number;
	}
	
	public static void displayPermutation(String s){
		
		displayPermutation("", s);
	}
	
	public static void displayPermutation(String s1, String s2){
		
		int n = s2.length();
		
		if(n == 0){
		
			System.out.println(s1);
		}else{
			
			for(int i = 0; i < n; i++){
				
				displayPermutation((s1 + s2.charAt(i)), (s2.substring(0, i) + s2.substring(i+1, n)));
			}
		}
	}
}
