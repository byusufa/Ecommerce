package uz.pdp.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ecommerce.service.OrderItemService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(orderItemService.getAllOrderItemsById(id));

    }
}
