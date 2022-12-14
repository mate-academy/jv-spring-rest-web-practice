package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping("/complete/{userId}")
    public OrderResponseDto complete(@PathVariable Long userId) {
        return null;
    }

    @GetMapping("/{userId}")
    public OrderResponseDto get(@PathVariable Long userId) {
        return null;
    }
}
