package enums;

/**
 *
 * Enums implicitly inherit class java.lang.Enum
 * In jvm, it is converted to class. Its elements are instance of the enumeration class.
 * - Enums are public(or default) static final. So can't be extended
 * - Enums can have members: fields, constructor and methods
 * - Enum elements must be first, before any other members if any.
 * - Its constructor can be only private. Making it protected or public lead compilation error
 *
 * Methods:
 * - values(): returns array of all elements
 * - valueOf(String str) : parses String and converts to Enum element
 * - name() : returns name of element in String
 */

enum Season {
    Summer, Autumn, Winter, Spring;
}

enum JobPosition {
    Developer(100), Manager(150), Architect(130), CTO("Technical Officer");
    int salary;
    String description;

    JobPosition(int salary) {
        this.salary = salary;
    }

    JobPosition(String description) {
        this.description = description;
    }
}

public class TestEnums {
    public static void main(String[] args) {
        System.out.println(JobPosition.Architect.name());           // Architect
        System.out.println(JobPosition.valueOf("Developer"));       // Developer
        System.out.println(JobPosition.CTO.valueOf("Developer"));   // Developer

        System.out.println(JobPosition.CTO.description);          // Technical Officer
        System.out.println(JobPosition.Architect.description);    // null
        System.out.println(JobPosition.values().length);          // 4
    }
}