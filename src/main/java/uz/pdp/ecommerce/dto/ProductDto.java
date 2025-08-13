package uz.pdp.ecommerce.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
     private String name;
     private Integer price;
     private Boolean isActive;
     private Integer categoryId;
     private Integer attachmentId;
}
