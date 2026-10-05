public class Debt {
    Wallet wallet;
    int debt = 1000;
    public Debt(){
        this.debt = debt;
    }
    public void payDebt(int n){
        //have to unable being able to pay more money than what they have
        debt -= n;
        wallet.money += n;

    }
    public void getLoan(int n){
        debt += n;
        wallet.money += n;
    }
}
