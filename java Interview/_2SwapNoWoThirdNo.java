public class _2SwapNoWoThirdNo {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println("before swap a: "+a+" b: "+b);
        a=a+b;
        b=a-b;;
        a=a-b;
        System.out.println("After swap a: "+a+" b: "+b);
    }
}
