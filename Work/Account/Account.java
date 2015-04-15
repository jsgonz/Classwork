import java.util.*;

public class Account {

	double balance;
	
	public Account(double n){
		
		if(n< 0){
			throw new RuntimeException();
		}
		balance = n;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double a){
		
		if(a < 0){
			throw new RuntimeException();
		}
		
		balance = a;
	}
	
	public void withdraw(double amt){
		if(amt< 0 ){
			throw new RuntimeException();
		}
		setBalance(balance - amt);
		
	}
	
	public void deposit(double amt){

		setBalance(balance + amt);
	}
}
