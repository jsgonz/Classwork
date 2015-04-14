
public class StopWatch {
	
	 long startTime;
	 long endTime;
	
	public StopWatch(){
		startTime = System.currentTimeMillis();
	}
	
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public void stop(){
		endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime(){
	
		long elapsedTime;
		
		
		elapsedTime = endTime - startTime;
		return elapsedTime;
	}
}


/*
 * 
 * 
 * 
 * }
 */