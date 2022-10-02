public class Valuta{

    double rate;
    String valutaName;

    public Valuta(double exchangeRate, String type){
        this.rate = exchangeRate;
        this.valutaName = type;

    }

    public double toNok(double amount) {
        return amount * this.rate;
    }

    public double fraNok(double amount){
        return amount * ( 1 / this.rate);
    }

}   