public class Debt {
    Wallet wallet;
    int debt = 1000;
    public Debt(){
        this.debt = debt;
    }
    public void payDebt(int n){
        if(n <= wallet.getMoney()) {
            debt -= n;
            wallet.subtractMoney(n);
        }
    }
    public void getLoan(int n){
        debt += n;
        wallet.addMoney(n);
    }
}
