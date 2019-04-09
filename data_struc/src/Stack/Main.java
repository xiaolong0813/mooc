package Stack;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("hello Array!");

        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);

    }
}
