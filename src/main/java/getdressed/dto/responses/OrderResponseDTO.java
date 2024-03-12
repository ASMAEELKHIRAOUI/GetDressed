package getdressed.dto.responses;

import getdressed.domain.Order;
import getdressed.domain.enums.Status;

public record OrderResponseDTO(
        String fullName,
        String email,
        String phone,
        Integer zipcode,
        Status status
) {
    public static OrderResponseDTO fromOrder(Order order){
        return new OrderResponseDTO(
                order.getFullName(),
                order.getEmail(),
                order.getPhone(),
                order.getZipcode(),
                order.getStatus()
        );
    }
}
