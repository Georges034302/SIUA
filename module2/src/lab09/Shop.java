package lab09;


import lab08.In;


public class Shop{
    private Product product;
    private CashRegister cashRegister;

    public Shop(){
        this.product = new Product("Pepsi",3.50,10);
        this.cashRegister = new CashRegister();
    }

    private void sell(){
        int quantity = product.readQuantity();
        if(product.has(quantity)){
            double cash = product.sold(quantity); // ---> a double cash
            cashRegister.gain(cash);
        }else
            System.out.println("Not enough stock!");
    }

    private void restock(){
        int quantity = product.readQuantity(); //stock to purchase

        double cash = product.cash(quantity);

        if(cashRegister.has(cash)){
            cash = product.stocked(quantity);
            cashRegister.pay(cash);
        }else
            System.out.println("Not enough funds!");
    }

    private void view(){
        System.out.println(product);
        System.out.println(cashRegister);
    }
    
    private char readChoice(){
        System.out.print("Choice(s/r/v/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        
        while((c = readChoice()) != 'x'){
            switch(c){
                case 's':sell();break;
                case 'r':restock(); break;
                case 'v':view();break;
                default: help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("s - sell");
        System.out.println("r - restock");    
        System.out.println("v - view");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new Shop()).menu();
    }
}


