package getdressed.dto.requests;

import getdressed.domain.Category;
import getdressed.domain.Order;
import getdressed.domain.enums.Status;

public record OrderRequestDTO(
        String fullName,
        String email,
        String phone,
        Integer zipcode,
        Status status
) {
    public Order toOrder(){
        Order.OrderBuilder orderBuilder = new Order().builder()
                .fullName(fullName)
                .email(email)
                .phone(phone)
                .zipcode(zipcode)
                .status(status);
        return orderBuilder.build();
    }
}
