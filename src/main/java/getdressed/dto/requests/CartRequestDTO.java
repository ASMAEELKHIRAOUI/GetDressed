package getdressed.dto.requests;

import getdressed.domain.Cart;
import getdressed.domain.Category;
import getdressed.domain.Product;
import getdressed.domain.User;

public record CartRequestDTO(
        Integer quantity,
        Long product,
        Long user
) {
    public Cart toCart(){
        Cart.CartBuilder cartBuilder = new Cart().builder().quantity(quantity);
        if (product != null){
            cartBuilder.product(Product.builder().id(product).build());
        }
        if (user != null){
            cartBuilder.user(User.builder().id(user).build());
        }
        return cartBuilder.build();
    }
}
