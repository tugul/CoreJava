# Enum
Simply imagine java enum is a class which has only limited number of pre-defined instances. Those instances are its elements and they are initialized when the enum type is first referenced, i.e. lazy initialization.  

If it has a single element, it means it is Singleton as there is only one instance. 

## Quick facts
- Uses reserved word ``enum`` on declaration
- Implicitly inherits ``java.lang.Enum`` class
- At compile time, it is converted to a class and JVM instantiates its elements
- It is **public** or default package, static final

### Declaration
- Its elements are declared always **at first** 
- Can have **any member** like class (field, constructor or method)
- Its constructor is **private** by default. Can't compile if protected or public

### Inherited Methods
Every enum type has below inherited methods:  
 ``values()``: returns an array of all elements  
 ``valueOf(String str)`` : parses String and converts to Enum element, case-sensitive  
 ``name()`` : returns a name of element in String  
 ``ordinal()`` : returns an index of element  

## Main usages
- When there is need for variable which can have **a limited set of possible values**. 
- **Type checking** at compile can help to avoid mismiatching values. 
- It is **descriptive** as it explains itself what it is for and what are possible values
