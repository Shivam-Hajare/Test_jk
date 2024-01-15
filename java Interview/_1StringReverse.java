class _1StringReverse {

    public static void main(String[] args) {
        String str = "ShivamHajare";

        String result = "";

        for (int i = str.length()-1; i>=0 ; i--) {
            result += str.charAt(i);
        }
        System.out.print(result);

    }
}