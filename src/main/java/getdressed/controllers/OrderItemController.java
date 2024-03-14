package getdressed.controllers;

import getdressed.domain.OrderItem;
import getdressed.dto.requests.OrderItemRequestDTO;
import getdressed.dto.responses.OrderItemResponseDTO;
import getdressed.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order_item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDTO>> getAll(){
        List<OrderItem> orderItems = orderItemService.getAll();
        if (orderItems.isEmpty())return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(orderItems.stream().map(OrderItemResponseDTO::fromOrderItem).toList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDTO> getById(@PathVariable Long id){
        OrderItem orderItem = orderItemService.getById(id).orElse(null);
        if (orderItem != null) return new ResponseEntity<>(OrderItemResponseDTO.fromOrderItem(orderItem), HttpStatus.OK);
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/order/{order}")
    public ResponseEntity<List<OrderItemResponseDTO>> getAllByOrder(@PathVariable Long order){
        List<OrderItem> orderItems = orderItemService.getByOrder(order).orElse(null);
        if (orderItems.isEmpty())return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(orderItems.stream().map(OrderItemResponseDTO::fromOrderItem).toList(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        orderItemService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
