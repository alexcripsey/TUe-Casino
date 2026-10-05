public class Wallet {
    int money = 100;

    public int getMoney() {
        return money;
    }

    public void winMoney(int n) {
        money+= n;
    }
    public void loseMoney(int n){
        money-= n;
    }
}
