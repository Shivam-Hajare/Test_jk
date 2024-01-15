public class removeWhiteSpaces {
    public static void main(String[] args) {
       System.out.println(removeSpace("   aaa   "));

       String s = "  abc  def\t";
	
    }

    private static String removeSpace(String str) {
        
        return str.trim();
    }
}
