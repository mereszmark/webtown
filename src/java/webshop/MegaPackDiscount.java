package webshop;


import java.util.Map;


public class MegaPackDiscount extends Discount{

    final int FIX_DISCOUNT=6000;
    public MegaPackDiscount(String name) {
        super(name);
    }

    @Override
    public boolean calculateDiscount(ProductList products) {
         int disc = 0;
         boolean isUsed=false;
        for (Map.Entry<Product, Integer> product : products.productList.entrySet()) {
            if (product.getKey().isMegapack()&&product.getValue()>=12) {
                disc += product.getValue()/12*FIX_DISCOUNT;
                isUsed=true;
            }
        }
        discount=disc;
        return isUsed;
    }
    
}
