package uz.pdp.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.pro.OrderItemShowPro;
import uz.pdp.ecommerce.repo.OrderItemRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItemShowPro> getAllOrderItemsById(UUID id) {
        return orderItemRepository.getOrderItemsByOrderId(id);
    }
}
