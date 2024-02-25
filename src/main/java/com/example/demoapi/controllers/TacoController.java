package com.example.demoapi.controllers;

import com.example.demoapi.models.Taco;
import com.example.demoapi.models.TacoOrder;
import com.example.demoapi.repositories.OrderRepository;
import com.example.demoapi.repositories.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    private final TacoRepository tacoRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public TacoController(TacoRepository tacoRepository,
                          OrderRepository orderRepository) {
        this.tacoRepository = tacoRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepository.findById(id);

        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder tacoOrder) {
        tacoOrder.setId(orderId);

        return orderRepository.save(tacoOrder);
    }

    @PatchMapping(path = "/orderId", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder patch) {

        TacoOrder order=orderRepository.findById(orderId).get();
        
        /*if (patch.getDeliveryName()!=null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        
        if (patch.getDeliveryCity()!=null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        
        if (patch.getDeliveryStreet()!=null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        
        if (patch.getDeliveryState()!=null) {
            order.setDeliveryState(patch.getDeliveryState());
        }

        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }

        if (patch.getCcNumber()!=null) {
            order.setCcNumber(patch.getCcNumber());
        }

        if (patch.getCcExpiration()!=null) {
            order.setCcExpiration(patch.getCcExpiration());
        }

        if (patch.getCcCVV()!=null) {
            order.setCcCVV(patch.getCcCVV());
        }*/

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
