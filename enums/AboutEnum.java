package enums;

/**
 *
 * - Java Enum 
 * implicitly inherits java.lang.Enum class 
 * JVM converts it to class. Its elements are instance of the enumeration class.
 * It is public(or default) static final. So can't be extended
 * It can have members: fields, constructors and methods
 * Its elements must be declared first, before any other members if any.
 * If enum defines abstract method, each constant element must override it
 * Its constructor can be only private. Making it protected or public lead compilation error
 *
 * - Enum methods:
 * values(): returns array of all elements
 * valueOf(String str) : parses String and converts to Enum element
 * name() : returns name of element in String
 * ordinal() : returns index of element
 */

enum Planet {
    // semicolon is not mandatory at the end
    // when there is no other extra members after elements
    Earth, Mars, Saturn
}

enum Season {
    Summer, Autumn, Winter { void printWeather() { System.out.println("cold");}}, Spring;
    void printWeather() { System.out.println("mild"); }
}

enum JobPosition {
    Developer(100)  { void sayMyName() { System.out.println("Devo"); } },
    Manager(150)    { void sayMyName() { System.out.println("Mana"); } },
    Architect(130)  { void sayMyName() { System.out.println("Arch"); } },
    CTO("Technical Officer") {
        void sayMyName() { System.out.println("Ofi"); }
        void sayMySalary() { System.out.println("millions");}
    };

    int salary;
    String description;

    JobPosition(int salary) {
        this.salary = salary;
    }

    JobPosition(String description) {
        this.description = description;
    }

    // Abstract method must be overridden in each enum constant
    abstract void sayMyName();

    void sayMySalary() { System.out.println("No way!"); }
}

public class AboutEnum {
    public static void main(String[] args) {
        JobPosition devOne = JobPosition.valueOf("Developer");
        JobPosition IamCto = JobPosition.Manager.valueOf("CTO");
        JobPosition devTwo = JobPosition.CTO.valueOf("developer"); // IllegalArgument exception, no matching constant
        devOne.sayMyName();             // Devo
        devOne.sayMySalary();           // No way!
        IamCto.sayMySalary();           // millions (overridden)

        System.out.println(JobPosition.Architect.name());         // Architect
        System.out.println(JobPosition.CTO.description);          // Technical Officer
        System.out.println(JobPosition.Architect.description);    // null
        System.out.println(JobPosition.values().length);          // 4
        
        switch(devOne){
        	case Manager : System.out.println("manager");
        	case 1: System.out.println("1");					// DOES NOT COMPILE, type mismatch
        	case JobPosition.CTO : System.out.println("cto");	// DOES NOT COMPILE
        }
    }
}
