package getdressed.controllers;

import getdressed.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order_item")
public class OrderItemController {

    private final OrderItemService orderItemService;

}
