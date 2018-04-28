package webshop;


public abstract class Discount {
    protected String name;
    protected int discount;

    public Discount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    
    
    public abstract boolean calculateDiscount(ProductList products); 
}
