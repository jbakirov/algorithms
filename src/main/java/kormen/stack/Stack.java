package kormen.stack;

import java.nio.BufferUnderflowException;

/**
 * Created by Baka on 25.03.2016.
 */
public class Stack {

    int[] stack;
    int top = 0;
    int size = 0;

    Stack() {
        this.stack = new int[10];
    }

    Stack(int size) {
        this.stack = new int[size];
    }

    public void push (int x){
        stack[top] = x;
        top++;
        size++;
    }

    public int pop(){
        if (isEmpty()) return -1;
        size--;
        return stack[--top];
    }

    public boolean isEmpty (){
        return top == 0;
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.push(2);
        stack1.push(3);
        stack1.push(5);
        stack1.push(11);
        stack1.push(1);

        System.out.println("Size:" + stack1.size);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

        System.out.println("Size:" + stack1.size);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

        System.out.println("Size:" + stack1.size);

        stack1.push(34);

        System.out.println("Size:" + stack1.size);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

        System.out.println("Size:" + stack1.size);
    }

}
