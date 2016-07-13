package designpatterns;

import java.util.*;

/**
 * Immutable object pattern:
 * - creational pattern ensures object's state doesn't change after created
 * - provides thread safety
 *
 * Common behaviour:
 * - final class or its methods are final to prevent being overridden
 * - has no setter to modify, so thread-safe
 * - its constructor sets all variables on its creation
 * - all instance variables are private final
 * - has no reference to mutable objects to be accessed directly
 * - don't use directly mutable object parameter, instead use of its copy
 *
 */

final class Computer {
    private final int memory;
    private final String name;
    private List<String> components;

    public Computer(int memory, String name, List<String> components) {
        this.memory = memory;
        this.name = name;
        this.components = new ArrayList<>(components);  // make copy of mutable object
    }

    public int getMemory() {
        return memory;
    }

    public String getName() {
        return name;
    }

    public List<String> getComponents() {
        return new ArrayList<>(components);
    }
}

public class ImmutableObject {
}
