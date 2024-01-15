 class OuterClass {
    int a = 10;
    static int x = 20;

    void OuterShow() {
        System.out.println("Outer show..");
    }

    static void OuterShow1() {
        System.out.println("Outer static show..");
    }

   static class InnerClass {
        int b = 30;

        // static int c=40;
        void showOfInner() {
            System.out.println("inner non static show");

            OuterClass o = new OuterClass();
            System.out.println("in inner Outer a=" + o.a);
            System.out.println("in inner Outer x: " + o.x);

            // System.out.println("in inner Outer show: "+o.OuterShow());

          //  System.out.println("in inner Outer show: "+o.OuterShow1());
            // System.out.println(OuterShow());
            // System.out.println(OuterClass.OuterShow1());

        }

        static void showOfInner1()
        {
        System.out.println("inner non static show");
        }
    }
    void aaa(){

        InnerClass i = new InnerClass();
        InnerClass.showOfInner1();
    }

}
class DemoInnerClass{
    public static void main(String[] args) {
        OuterClass o = new OuterClass();
        o.aaa();
    //   //  System.out.println(o.OuterShow());
    //   o.OuterShow();
    //   OuterClass.OuterShow1();
   // OuterClass.InnerClass i = new OuterClass().new InnerClass();
    //   i.showOfInner();
  //  i.showOfInner1();

    }
}
