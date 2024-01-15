import java.util.*;
public class FullCashPayment extends Payment{
     String paymentId,paymentMode,paymentType;
     float basicPaymentAmount=0.0f;
     private String couponCode;

     String companyName,DiscountValue;
     char DiscountBooster;
     int Discount;
     
    public FullCashPayment(String paymentId, float basicPaymentAmount, String paymentMode, 
    String paymentType,String couponCode) {
        super(paymentId, basicPaymentAmount, paymentMode, paymentType);

        this.basicPaymentAmount=basicPaymentAmount;
        this.paymentId=paymentId;
        this.paymentMode=paymentMode;
        this.paymentType=paymentType;
        this.couponCode=couponCode;

    }
    public String getCouponCode(){
        return couponCode;
    }
    public void setCouponCode(String couponCode) {
        this.couponCode =couponCode;
    }
    public boolean verifyCouponCode(){
        //Fill the code here 
            if(couponCode.substring(0, 3).equals("BBC"))
            {
                companyName=couponCode.substring(0, 3);
                if(couponCode.charAt(3)=='-')
                {
                    if(couponCode.charAt(4)=='0'||couponCode.charAt(4)=='1'||couponCode.charAt(4)=='2'
                    ||couponCode.charAt(4)=='3'||couponCode.charAt(4)=='4'||couponCode.charAt(4)=='5'
                    ||couponCode.charAt(4)=='6'||couponCode.charAt(4)=='7'||couponCode.charAt(4)=='8'
                    ||couponCode.charAt(4)=='9' &&
                    couponCode.charAt(5)=='0'||couponCode.charAt(5)=='1'||couponCode.charAt(5)=='2'
                    ||couponCode.charAt(5)=='3'||couponCode.charAt(5)=='4'||couponCode.charAt(5)=='5'
                    ||couponCode.charAt(5)=='6'||couponCode.charAt(5)=='7'||couponCode.charAt(5)=='8'
                    ||couponCode.charAt(5)=='9' &&
                    couponCode.charAt(6)=='0'||couponCode.charAt(6)=='1'||couponCode.charAt(6)=='2'
                    ||couponCode.charAt(6)=='3'||couponCode.charAt(6)=='4'||couponCode.charAt(6)=='5'
                    ||couponCode.charAt(6)=='6'||couponCode.charAt(6)=='7'||couponCode.charAt(6)=='8'
                    ||couponCode.charAt(6)=='9')
                    {
                        DiscountValue=couponCode.substring(4,7);
                        if(couponCode.charAt(7)=='-'){
                            if(couponCode.charAt(8)=='H'||couponCode.charAt(8)=='K')
                            {
                                DiscountBooster=couponCode.charAt(8);
                                return true;
                            }
                        }
                    }
                }
            }
        
    return false ;    
    }
    float RTO_tax,GST,Insurance;
    @Override
    public float calculateFinalPayment() {
        int DiscountValueConvert = Integer.parseInt(DiscountValue);
      
        if (DiscountBooster=='H') {
            Discount = DiscountValueConvert*100;

        }
        if(DiscountBooster=='K')
        {
            Discount=DiscountValueConvert*1000;
        }
        if(basicPaymentAmount>4000000)
        {
            RTO_tax=(float) (0.60*basicPaymentAmount);
            Insurance=(float) (0.30*basicPaymentAmount);
            GST=(float) (0.54*basicPaymentAmount);
        }
        else if(basicPaymentAmount>3000000 && basicPaymentAmount<=4000000)
        {
            RTO_tax=(float) (0.50*basicPaymentAmount);
            Insurance=(float) (0.30*basicPaymentAmount);
            GST=(float) (0.45*basicPaymentAmount);
        }
        else if(basicPaymentAmount>1500000 && basicPaymentAmount<=3000000)
        {
            RTO_tax=(float) (0.40*basicPaymentAmount);
            Insurance=(float) (0.30*basicPaymentAmount);
            GST=(float) (0.36*basicPaymentAmount);
        }
        else if(basicPaymentAmount<=1500000)
        {
            RTO_tax=(float) (0.30*basicPaymentAmount);
            Insurance=(float) (0.30*basicPaymentAmount);
            GST=(float) (0.27*basicPaymentAmount);
        }

        return ((basicPaymentAmount+RTO_tax+Insurance+GST)-Discount);
    }
    

  
}

  
