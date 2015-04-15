
public class Bills {

	public static void main(String[] args){
		int money = 2567;
		
		int hundreds, fifties, twenties, tens, fives, ones;
		int modHund, modFif, modTwent, modTen, modFiv, modOne;
		
		hundreds = 2567 / 100;
		modHund = 2567 % 100;
		
		fifties = modHund / 50;
		modFif = modHund % 50;
		
		twenties = modFif / 20;
		modTwent = modFif % 20;
		
		tens = modTwent / 10;
		modTen = modTwent % 10;
		
		fives = modTen / 5;
		modFiv = modTen % 5;
		
		ones = modFiv / 1;
		
		System.out.println("You need\n" + hundreds + " $100 dollar bills,\n" + fifties + " $50 dollar bills,\n" + twenties + " $20 dollar bills,\n" + tens + " $10 dollar bills,\n" + fives + " $5 doollar bills,\nand " + ones + " $1 dollar bills to make $" + money);
		
	}
}
