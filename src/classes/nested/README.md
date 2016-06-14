A nested class is defined inside another class. There are 4 types of nested classes in Java. 

##### 1. Inner class (Non-static nested class)
- It is an inner class which is defined in same level as instance member of a class. It is not static. 
- Inner class has access to all members of enclosing class (including private ones).
- Inner class can have any of all access modifier while outer class can be only public or package private.
- As it is instance member of outer class, it can not define static member inside. 
```java 
OuterClass.InnerClass innerObj = outerObj.new InnerClass();
```

##### 2. Static nested class
- It is an inner class defined as static and associated with its outer class. 
- Like static field/method, it can not directly access to instance members of outer class, but only through object reference.
- It interacts with instance members of outer class and other classes just like any other top-level class.
- Accessed using outer class name. Below is to create instance of static nested class
```java 
OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();
```

##### 3. Local inner class
- Local class is a class defined within a method and its any block (condition, loop, ...).
- It doesn't have access modifier
- Its declaration doesn't exist until enclosing method is called
- It can't be static and can't declare any static member
- It can access to any member of outer class and only final or 'effectively final' local variables of enclosing method. 

##### 4. Anonymous inner class/Anonymous class
- Anonymous class is a local inner class defined without a name. 
- It implements interface or extends a class. It can have method declarations, but statements are not allowed

All those types of classes can optionally implement interface or extend class except for Anonymous class which is mandatory to do it  


