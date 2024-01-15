abstract public class Payment{
    protected String paymentId,paymentMode,paymentType;
    protected float basicPaymentAmount=0.0f;

    public Payment(String paymentId,float basicPaymentAmount,String paymentMode,String paymentType){
        this.basicPaymentAmount=basicPaymentAmount;
        this.paymentId=paymentId;
        this.paymentMode=paymentMode;
        this.paymentType=paymentType;
    }
    public String getPaymentId(){
        return paymentId;
    }
    public float getBasicPaymentAccount(){
        return basicPaymentAmount;
    }
    public String getPaymentType(){
        return paymentType;
    }
    public String getPaymentMode(){
        return paymentMode;
    }
    public void setBasicPaymentAmount(float basicPaymentAmount){
        this.basicPaymentAmount=basicPaymentAmount;
    }
    public void setPaymentId(String paymentId){
        this.paymentId = paymentId;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode=paymentMode;
    }
    abstract public float calculateFinalPayment();
}
