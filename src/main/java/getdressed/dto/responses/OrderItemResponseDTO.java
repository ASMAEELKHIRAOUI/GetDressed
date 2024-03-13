package getdressed.dto.responses;

import getdressed.domain.OrderItem;
import getdressed.domain.Order;
import getdressed.domain.Product;

public record OrderItemResponseDTO(
        Integer total,
        Integer quantity,
        Order order,
        Product product
) {
    public static OrderItemResponseDTO fromOrderItem(OrderItem orderItem){
        return new OrderItemResponseDTO(
                orderItem.getTotal(),
                orderItem.getQuantity(),
                orderItem.getOrder(),
                orderItem.getProduct()
        );
    }
}
