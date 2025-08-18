package uz.pdp.ecommerce.pro;

import java.util.UUID;

public interface OrderPro {
    UUID getId();
    Integer getOrderNumber();
    Long getCount();
    Float getTotalPrice();
    String getCreatedAt();
}
