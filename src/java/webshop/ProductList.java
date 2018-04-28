package webshop;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductList{

    Map<Product, Integer> productList;
    int totalPriceOfProductList;
    Set<Discount> discounts;
    String usedDiscounts;

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public ProductList() {
        productList = new HashMap<>();
        discounts=new HashSet<>();
        totalPriceOfProductList = 0;
        usedDiscounts="";
    }

    public void addProduct(Product product) {
        if (productList.containsKey(product)) {
            productList.put(product, 1);
        } else {
            int count = productList.get(product);
            productList.put(product, count + 1);
        }
        totalPriceOfProductList += product.getPrice();
    }
    
     public void addProduct(Product product,int count) {
        if (productList.containsKey(product)) {
            int c = productList.get(product);
            productList.put(product, c + count);
            
        } else {
            productList.put(product, count);
        }
        totalPriceOfProductList += product.getPrice()*count;
    }
     
     public void registrateDiscount(Discount discount){
         discounts.add(discount);
     }
    

    public int getTotalPriceOfProductList() {
        return totalPriceOfProductList;
    } 
    
    public int getTotalDiscountedPrice() {
        int maxdiscount=0;
        String nameOfMaxDiscount="";
        int totaldiscountedprice=totalPriceOfProductList;
        for (Discount discount : discounts) {
            if(discount.calculateDiscount(this)){
                if(discount.getDiscount()>maxdiscount){
                    maxdiscount=discount.getDiscount();
                    nameOfMaxDiscount=discount.getName();
                }
              
            }
        }
        totaldiscountedprice-=maxdiscount;
        usedDiscounts=nameOfMaxDiscount;
        return totaldiscountedprice;
    } 

    public String getUsedDiscounts() {
        return usedDiscounts;
    }

    void clearAll() {
    productList.clear();
    totalPriceOfProductList=0;
    }
    
    

}
