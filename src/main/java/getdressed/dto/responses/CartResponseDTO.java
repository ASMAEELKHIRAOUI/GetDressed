package getdressed.dto.responses;

import getdressed.domain.Cart;
import getdressed.domain.Product;
import getdressed.domain.User;

public record CartResponseDTO(
        Integer quantity,
        ProductResponseDTO product,
        User user
) {
    public static CartResponseDTO fromCart(Cart cart){
        return new CartResponseDTO(
                cart.getQuantity(),
                ProductResponseDTO.fromProduct(cart.getProduct()),
                cart.getUser()
        );
    }

}
