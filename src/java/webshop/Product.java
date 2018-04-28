package webshop;


public class Product {
    private String name;
    private int price;
    private boolean megapack;

    public Product(String name, int price, boolean megapack) {
        this.name = name;
        this.price = price;
        this.megapack = megapack;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMegapack() {
        return megapack;
    }

    public void setMegapack(boolean megapack) {
        this.megapack = megapack;
    }

    @Override
    public boolean equals(Object product2) {
       return this.getName().equals(((Product)product2).getName());
    }

    
}
