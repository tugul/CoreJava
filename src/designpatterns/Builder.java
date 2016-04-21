package designpatterns;

import java.util.*;

/**
 * Builder Pattern:
 * - creational pattern which uses a builder class to create instance of specific class (target class)
 * - target and builder class often exists in same package or builder class can be nested in target class
 * - target class can be huge or has many attributes to set on constructor or through setters
 * - change in target class won't affect its callers, but on only builder class
 * - builder class can be mutable and has setters on each attribute of target class
 * - method chaining is allowed in builder class's setter
 * - build method creates instance of target class using builder's properties
 */

class ComputerBuilder {
    private int memory;
    private String name;
    private List<String> components;

    public ComputerBuilder setMemory(int memory){
        this.memory = memory;
        return this;
    }

    public ComputerBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ComputerBuilder setComponents(List<String> components){
        this.components = components;
        return this;
    }

    public Computer build(){
        return new Computer(memory, name, components);
    }
}

public class Builder {
    public static void main(String[] args) {
        ComputerBuilder comBuilder = new ComputerBuilder();
        comBuilder.setName("HP").setMemory(16);
        Computer hp = comBuilder.setComponents(new ArrayList<>()).build();

        Computer lenovo = new ComputerBuilder().setName("Lenovo").build();
    }
}
