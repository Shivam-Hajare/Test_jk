import java.math.BigInteger;
import java.util.*;
class AddToArrayFormOfInt{
    public static void main(String[] args) {
        int num[]={9,9,9,9,9,9,9,9,9,9};
        List<Integer> result=new ArrayList<>();
        int k=806;
        result= addToArrayForm(num,k);
        result.forEach(p->System.out.print(p));

    }

    public static List<Integer> addToArrayForm(int[]num,int k)
    {
        List<Integer> result=new ArrayList<>();
        String str="";
        for(int i=0;i<num.length;i++)
        {
            str+=String.valueOf(num[i]);
        }
        
      //  long rst=Long.parseLong(str)+k;
        BigInteger sum = new BigInteger(str);
        
        BigInteger newK = new BigInteger(String.valueOf(k));
        sum.add(newK);

        while (!sum.equals(BigInteger.ZERO)) {
            BigInteger[] divisionResult = sum.divideAndRemainder(BigInteger.TEN);
            int rem = divisionResult[1].intValue();
            result.add(rem);
            sum = divisionResult[0];
        }

        Collections.reverse(result);
        return result;

    }
}