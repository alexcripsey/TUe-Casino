public class Wallet {
    int money = 100;

    public int getMoney() {
        return money;
    }

    public void addMoney(int n) {
        money+= n;
    }
    public void subtractMoney(int n){
        money-= n;
    }
}
