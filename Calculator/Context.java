package Calculator;

import ExceptionPackage.ArgumentTypeException;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    private Stack<Double> stack;
    private HashMap<String, Double> defineMap;

    Context() {
        stack = new Stack<>();
        defineMap = new HashMap<>();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public double[] pop(int count) {
        double[] out = new double[count];
        for (int i = 0; i < count; i++) {
            out[i] = stack.pop();
        }
        return out;
    }

    public double peek() {
        return stack.peek();
    }

    public void define(String identifier, double value) {
        defineMap.put(identifier, value);
    }

    public Double identify(String identifier) {
        return defineMap.get(identifier);
    }

    public int stackSize() {
        return stack.size();
    }

    public void reset() {
        stack = new Stack<>();
        defineMap = new HashMap<>();
    }
}
