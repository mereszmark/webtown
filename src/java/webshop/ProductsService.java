package webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsService {

    List<Product> buyableProducts;
    ProductList shoppingCart;

    public ProductsService() {
        shoppingCart = new ProductList();
        buyableProducts = new ArrayList<>();
        initBuyableProducts();
        initDiscounts();
    }

    public void initDiscounts() {
        shoppingCart.registrateDiscount(new MegaPackDiscount("megapack -6000"));
        shoppingCart.registrateDiscount(new ThreeForTwoDiscount("2=3"));
    }

    public void initBuyableProducts() {
        buyableProducts.add(new Product("téliszalámi", 2000, false));
        buyableProducts.add(new Product("gumikacsa", 3000, false));
        buyableProducts.add(new Product("uborka", 2800, true));
        buyableProducts.add(new Product("gesztenye", 1000, true));
    }

    public String getBuyableProducts() {
        StringBuilder html = new StringBuilder();
        html.append("<table id='productForm' style='width:80%' class='names table'>");
        html.append("<tr>");
        html.append(" <th>").append("Termék neve").append("</th>");
        html.append(" <th>").append("Termék ára").append("</th>");
        html.append(" <th>").append("Termék menyisége").append("</th>");
        html.append(" </tr>");
        for (Product buyableProduct : buyableProducts) {
            html.append("<tr>");
            html.append(" <td>").append(buyableProduct.getName()).append("</td>");
            html.append(" <td>").append(buyableProduct.getPrice()).append("</td>");
            html.append(" <td>").append("<input type=\"text\" name='quantityof"+buyableProduct.getName()+"' id=\"quantity\" required/>").append(" </td>");
            html.append("</tr>");
        }
         html.append("<tr><td></td><td></td><td><input type=\"submit\" value='Rendelés leadása' /></td></tr>");
         html.append("</table>");
        return html.toString();
    }
    
    public String getOrderedProducts() {
        StringBuilder html = new StringBuilder();
        html.append("<table style='width:80%' class='names table'>");
        html.append("<tr>");
        html.append(" <th>").append("Termék neve").append("</th>");
        html.append(" <th>").append("Termék ára").append("</th>");
        html.append(" <th>").append("Termék menyisége").append("</th>");
        html.append(" </tr>");
        for (Map.Entry<Product, Integer> product : shoppingCart.getProductList().entrySet()) {

            html.append("<tr>");
            html.append(" <td>").append(product.getKey().getName()).append("</td>");
            html.append(" <td>").append(product.getKey().getPrice()).append("</td>");
            html.append(" <td>").append(product.getValue()).append("</td>");
            html.append("</tr>");
        }
        html.append("<tr><td></td><td></td><td></td></tr>");
         html.append("<tr style='border-style: solid;'><td>Összesen kedvezmény nélkül:</td><td></td><td>"+shoppingCart.getTotalPriceOfProductList()+"</td></tr>");
         html.append("<tr style='border-style: solid;'><td>Összesen kedvezménnyel:</td><td></td><td>"+shoppingCart.getTotalDiscountedPrice()+"</td></tr>");
         html.append("<tr style='border-style: solid;'><td>Használt kedvezmények:</td><td></td><td>");
             html.append(" "+shoppingCart.getUsedDiscounts()+ " ");
         html.append("</td></tr>");
         html.append("</table>");
        return html.toString();
    }
    
    
    
    public Product getProduct(String name){
        Product product=null;
        for (Product buyableProduct : buyableProducts) {
            if(buyableProduct.getName().equals(name))
                product=buyableProduct;
        }
        return product;
    }

    public void addProduct(String name,int quantity) {
        shoppingCart.addProduct(getProduct(name), quantity);
    }
    
    public void clear(){
        shoppingCart.clearAll();
    }

}
