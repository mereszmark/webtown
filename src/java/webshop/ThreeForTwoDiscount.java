package webshop;


import java.util.Map;

public class ThreeForTwoDiscount extends Discount {

    public ThreeForTwoDiscount(String name) {
        super(name);
    }

    @Override
    public boolean calculateDiscount(ProductList products) {
        int disc = 0;
         boolean isUsed=false;
        for (Map.Entry<Product, Integer> product : products.getProductList().entrySet()) {
            if (product.getValue() >= 3) {
                disc += product.getValue() / 3 * product.getKey().getPrice();
                isUsed=true;
            }
        }

        discount = disc;
        return isUsed;
    }

}
