public class checkPalindromeString {
    public static void main(String[] args) {
        String str="aaabaaa";
        System.out.println(checkPalindromeStr(str));
        
    }

    private static boolean checkPalindromeStr(String str) {

        String str2="";
        for(int i=str.length()-1;i>=0;i--)
        {
            str2+=str.charAt(i);
        }
        return str.equals(str2);

    }
}
