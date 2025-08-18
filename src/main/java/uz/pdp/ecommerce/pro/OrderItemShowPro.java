package uz.pdp.ecommerce.pro;

public interface OrderItemShowPro {
    String getProductName();
    Float getProductPrice();
    Integer getProductCount();
    String getCreatedAt();
}