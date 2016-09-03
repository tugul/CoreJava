package interfaces;

/**
 *
 * In scenario where a class implementing or interface extending two interfaces which have same methods:
 * 1. Static methods with same signature won't conflict
 * 2. Default methods with same signature will conflict. Resolution is to override the method
 *
 */

interface IMe {
	static void me(){System.out.println("IMe");}
}

interface IYou {
	default void me(){System.out.println("IYou");}
}

interface IYouAndMe extends IMe, IYou {}

class Wondering implements IMe {
	public static void me(){ System.out.println("I am wondering...");}
}

class Lost implements IYouAndMe {
	public void me(){ System.out.println("I am lost");}
}

interface IGo {
    default int doIt() { return 0; }
    static int goFor() { return 0; }
}

interface IDo {
    default int doIt() { return 1; }
    static int goFor() { return 0; }
}

interface IGoDo1 extends IGo, IDo {
    // DOES NOT COMPILE, default methods conflict
    // static methods don't conflict
}

interface IGoDo2 extends IGo, IDo {
    // Resolution is to override conflicting default method
    default int doIt() { return 2; }
}

public class ConflictingMethods {
    public static void main(String[] args) {
    	IMe aa = new Lost();
    	Lost ab = new Lost();
    	IMe.me();
    	ab.me();
    	
    	Wondering.me();
    	new Wondering().me();
    	IMe x = new Wondering();
    	((Wondering)x).me();
    	x.me();		// DOES NOT COMPILE
    	//aa.me();
    }
}
