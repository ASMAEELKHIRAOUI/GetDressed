package getdressed.dto.responses;

import getdressed.domain.Product;

public record ProductResponseDTO(
        String name,
        String description,
        Double price,
        Integer stock,
        Integer promotion,
        String image,
        String category
) {
    public static ProductResponseDTO fromProduct(Product product){
        return new ProductResponseDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getPromotion(),
                product.getImage(),
                product.getCategory().getName()
        );
    }
}
