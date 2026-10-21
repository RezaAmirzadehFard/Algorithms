package amortizedAnalysis.stackoperation;

import java.util.Scanner;

public class StackOperation {
    public static void main(String[] args) {
        Stack ms = new Stack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Push value");
            System.out.println("2. Pop one value");
            System.out.println("3. MultiPop (pop multiple values)");
            System.out.println("4. Show stack size");
            System.out.println("5. Show stack elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    ms.push(sc.nextInt());
                    System.out.println("Value pushed.");
                    break;
                case 2:
                    if (ms.size() == 0) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Popped value: " + ms.pop());
                    }
                    break;
                case 3:
                    System.out.print("How many values do you want to pop? ");
                    int count = sc.nextInt();
                    if (count <= 0) {
                        System.out.println("Please enter a positive number.");
                    } else {
                        ms.multiPop(count);
                    }
                    break;
                case 4:
                    System.out.println("Current stack size: " + ms.size());
                    break;
                case 5:
                    if (ms.size() == 0) {
                        System.out.println("Stack is empty.");
                        break;
                    }else{
                    for(int i = ms.size() - 1; i >= 0 ;i--){
                        System.out.printf("| %6d |%n",ms.stackArray[i]);    
                    }
                    //System.out.println("``````````");
                    System.out.println("+--------+");
                    break;
                    }
                case 6:
                    System.out.println("Program ended.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // implement the stack logic with array
    // data: a array that store element of stack
    // top: a number that show top of stack element position
    private static class Stack {
        private int[] stackArray;
        private int top;

        public Stack() {
            stackArray = new int[10];
            top = -1;
        }

        public void push(int value) {
            if (top == stackArray.length - 1) {
                int[] newStackArray = new int[stackArray.length * 2];
                System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
                stackArray = newStackArray;
            }
            stackArray[++top] = value;
        }

        public int pop() {
            if (top == -1) {
                throw new IllegalStateException("Stack is empty.");
            }
            return stackArray[top--];
        }

        public void multiPop(int n) {
            int limit = Math.min(n, size());
            for (int i = 0; i < limit; i++) {
                System.out.println(pop());
            }
        }

        public int size() {
            return top + 1;
        }
    }
}