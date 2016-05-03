



There is one more issue you might see with lambdas. We’ve been defining an argument
list in our lambda expressions. Since Java doesn’t allow us to re‐declare a local variable, the
following is an issue:
(a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE
(a, b) -> { int c = 0; return 5;} // COMPILES




ceilling(Object o) on Collections


