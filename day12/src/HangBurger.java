public class HangBurger {


    private String bname;
    private String bmeat;
    private String rollType;
    private double bprice;

    private String addname1;
    private double addprice1;
    private String addname2;
    private double addprice2;
    private String addname3;
    private double addprice3;
    private String addname4;
    private double addprice4;


    public HangBurger(String bname, String  bmeat, String  rollType, double bprice)
    {
        this.bname = bname;
        this.bmeat = bmeat;
        this.rollType = rollType;
        this.bprice = bprice;
    }


    public void add1(String  name, double price){

        this.addname1 = name;
        this.addprice1 = price;
    }

    public void add2(String name, double price)
    {

        this.addname2 = name;
        this.addprice2 = price;
    }


    public void add3(String name, double price)
    {

        this.addname3 = name;
        this.addprice3 = price;
    }

    public void add4(String name, double price)
    {

        this.addname4 = name;
        this.addprice4 = price;
    }

    public double itemprice()
    {
        double totalPrice =+ this.bprice;


        System.out.println("burger "+bname+" and the meat type "+ bmeat + " and roll type is "+rollType+" and the price is "+bprice);

        if( addname1 != null)
        {
            totalPrice =totalPrice + addprice1;
            System.out.println("added "+ this.addname1+" and the price is "+ this.addprice1);
        }

        if (addname2 != null)
        {
            totalPrice = totalPrice +addprice2;
            System.out.println("added "+ this.addname2+" and the price is "+ this.addprice2);
        }

        if (addname3 != null)
        {
            totalPrice = totalPrice +addprice3;
            System.out.println("added "+ this.addname3+" and the price is "+ this.addprice3);
        }

        if (addname4 != null)
        {
            totalPrice = totalPrice +addprice1;
            System.out.println("added " +this.addname4 +" and the price is "+this.addprice4);
        }

        return totalPrice;

    }

}
