package webshop;


public interface ProductDiscounter {
    final int DISCOUNT_OF_MEGAPACK=6000;
    public int calculateDiscountByMegaPack();
    public int calculateDiscountByThreeForTwo();
    
}
