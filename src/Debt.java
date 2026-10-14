public class Debt {
    Wallet wallet;
    int debt = -1000;
    public Debt(Wallet wallet){
        this.debt = debt;
        this.wallet = wallet;
    }
    public void payDebt(int n){
        if(n <= wallet.getMoney()) {
            debt += n;
            this.wallet.subtractMoney(n);
        }
    }
    public void getLoan(int n){
        debt -= n;
        this.wallet.addMoney(n);
    }
    public int getDebt() {
        return debt;
    }
    public String debtToString() {
        String amount = String.valueOf(getDebt() + "$");
        return amount;
    }

}
