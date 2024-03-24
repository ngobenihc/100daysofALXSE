public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        HangBurger hangBurger = new HangBurger("cli", "beef", "white", 10);
        //double money = hangBurger.itemprice();

        hangBurger.add1("hl", 20);

        System.out.println("total! is + "+ hangBurger.itemprice());
    }
}