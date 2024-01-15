import java.util.*;

import javax.swing.plaf.synth.SynthPasswordFieldUI;
public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paymentId,paymentMode,paymentType="",couponCode;
        float basicPaymentAmount;
        float downPayment=0;
        int emiDuration=0;
        float emiRate=0;
        
        System.out.println("Enter the payment id ");
        paymentId=sc.nextLine();

        System.out.println("The basic payment amount ");
        basicPaymentAmount=Float.parseFloat(sc.nextLine());

        System.out.println("Enter the mode of payment either CHEQUE or CASH");
        paymentMode=sc.nextLine();
        if(!paymentMode.equals("CASH"))
        {
            System.out.println("Invalid mode of payment" + paymentMode);
            System.exit(0);
        }

        System.out.println("Payment type \nEMI \nFull Cash");
        paymentType=sc.nextLine();

        if(paymentType.equals("EMI"))
        {
            System.out.println("Enter Downpayment");
            downPayment=sc.nextFloat();
            System.out.println("Enter Emi duration");
            emiDuration=sc.nextInt();
            System.out.println("Enter emiRate");
            emiRate=sc.nextFloat();
        }
        System.out.println("Enter the Coupon Code ");
        couponCode=sc.nextLine();

        FullCashPayment full = new  FullCashPayment( paymentId,  basicPaymentAmount,  paymentMode, 
         paymentType, couponCode);
         EMIPayment emi = new EMIPayment( paymentId,  basicPaymentAmount,paymentMode,paymentType, 
                                            downPayment, emiDuration, emiRate);

         if(full.verifyCouponCode()==true)
         {
            if(paymentType.equals("full cash"))
            {
                System.out.println("The final price after coupon usage is "+full.calculateFinalPayment());
                
            }
            else if(paymentType.equals("EMI"))
            {
                System.out.println("The final price after coupon usage is "+emi.calculateFinalPayment());
            }
         }

         

    }
}
