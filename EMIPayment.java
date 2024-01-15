public class EMIPayment extends Payment {

    private float downPayment;
    private int emiDuration;
    private float emiRate;
    
    //Include 7 argument constructor 
    //Fill the code here 
    public EMIPayment(String paymentId, float basicPaymentAmount, String paymentMode, 
    String paymentType,float downPayment,int emiDuration,float emiRate) {
        super(paymentId, basicPaymentAmount, paymentMode, paymentType);
        
        this.basicPaymentAmount=basicPaymentAmount;
        this.paymentId=paymentId;
        this.paymentMode=paymentMode;
        this.paymentType=paymentType;
        this.downPayment=downPayment;
        this.emiDuration=emiDuration;
        this.emiRate=emiRate;
    }
    
    public float getDownPayment(){
        return downPayment;
    }
    public float getEmiDuration(){
        return emiDuration;
    }
    public float getEmiRate(){
        return emiRate;
    }
    public void setDownPayment(float downPayment){
        this.downPayment=downPayment;
    }
    public void setEmiDuration(int emiDuration){
        this.emiDuration=emiDuration;
    }
    public void setEmiRate(float emiRate){
        this.emiRate=emiRate;
    }
    float RTO_tax,GST,Insurance;
    public float calculateFinalPayment(){
        //Fill the code here 
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
        
    return (((basicPaymentAmount+RTO_tax+Insurance+GST)+((basicPaymentAmount+RTO_tax+Insurance+GST)*emiDuration*emiRate/100))-
    downPayment)/emiDuration*12;
    }
    
}