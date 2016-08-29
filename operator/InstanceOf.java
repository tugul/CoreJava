package operator;

public class InstanceOf {

	public static void main(String[] args) {
		Runnable runnable = new Thread();
		String string;
		
		System.out.println(string instanceof InstanceOf);		// DOES NOT COMPILE, apparently incompatible
		System.out.println(runnable instanceof InstanceOf);	// false, seemingly incompatible but interface reference difficult to determine 
	}
}
