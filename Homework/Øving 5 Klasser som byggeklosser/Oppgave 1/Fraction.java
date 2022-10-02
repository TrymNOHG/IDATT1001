public class Fraction {

    private float dividend;
    private float divisor;
    private float multiplier = 1;
    private float storageDivis;
    private float storageDivid;

    public Fraction(float teller, float nevner){
        if(nevner == 0){
            throw new IllegalArgumentException("Can't divide by 0!");
        }
        else{
            dividend = teller;
            divisor = nevner;
        }
    }
    
    public Fraction(float teller){
        dividend = teller;
        divisor = 1;
    }

    public void adder(float dividend2, float divisor2){
        this.dividend = (this.dividend * divisor2) + (dividend2 * this.divisor);
        this.divisor = this.divisor * divisor2;

        storageDivid = this.dividend;
        storageDivis = this.divisor;

        while(storageDivid % 1 != 0 || storageDivis % 1 != 0){
            storageDivid = this.dividend;
            storageDivis = this.divisor;
            multiplier++;
            storageDivid = storageDivid * multiplier;
            storageDivis = storageDivis * multiplier;
        }

        this.divisor = this.divisor * multiplier;
        this.dividend = this.dividend * multiplier;

        for(int i = 2; i <= this.divisor; i++){
            if(this.dividend % i == 0 && this.divisor % i == 0){
                this.dividend = this.dividend/i;
                this.divisor = this.divisor / i;
            }
        }

    }

    public void subtracter(float dividend2, float divisor2){
        this.dividend = (this.dividend * divisor2) - (dividend2 * this.divisor);
        this.divisor = this.divisor * divisor2;
        storageDivid = this.dividend;
        storageDivis = this.divisor;

        while(storageDivid % 1 != 0 || storageDivis % 1 != 0){
            storageDivid = this.dividend;
            storageDivis = this.divisor;
            multiplier++;
            storageDivid = storageDivid * multiplier;
            storageDivis = storageDivis * multiplier;
        }
        this.divisor = this.divisor * multiplier;
        this.dividend = this.dividend * multiplier;

        for(int i = 2; i <= this.divisor; i++){
            if(this.dividend % i == 0 && this.divisor % i == 0){
                this.dividend = this.dividend/i;
                this.divisor = this.divisor / i;
            }
        }

    }

    public void multiplier(float dividend2, float divisor2){
        this.dividend = this.dividend * dividend2;
        this.divisor = this.divisor * divisor2;
        storageDivid = this.dividend;
        storageDivis = this.divisor;

        while(storageDivid % 1 != 0 || storageDivis % 1 != 0){
            storageDivid = this.dividend;
            storageDivis = this.divisor;
            multiplier++;
            storageDivid = storageDivid * multiplier;
            storageDivis = storageDivis * multiplier;
        }
        this.divisor = this.divisor * multiplier;
        this.dividend = this.dividend * multiplier;

        for(int i = 2; i <= this.divisor; i++){
            if(this.dividend % i == 0 && this.divisor % i == 0){
                this.dividend = this.dividend/i;
                this.divisor = this.divisor / i;
            }
        }

    }

    public void divider(float dividend2, float divisor2){
        this.dividend = this.dividend * divisor2;
        this.divisor = this.divisor * dividend2;
        storageDivid = this.dividend;
        storageDivis = this.divisor;

        while(storageDivid % 1 != 0 || storageDivis % 1 != 0){
            storageDivid = this.dividend;
            storageDivis = this.divisor;
            multiplier++;
            storageDivid = storageDivid * multiplier;
            storageDivis = storageDivis * multiplier;
        }
        this.divisor = this.divisor * multiplier;
        this.dividend = this.dividend * multiplier;

        for(int i = 2; i <= this.divisor; i++){
            if(this.dividend % i == 0 && this.divisor % i == 0){
                this.dividend = this.dividend / i;
                this.divisor = this.divisor / i;
            }
        }
    }

    @Override
    public String toString(){
        return "" + this.dividend + "/" + this.divisor;
    }
    
    public float getDividend() {
        return dividend;
    }

    public float getDivisor() {
        return divisor;
    }
    

}
