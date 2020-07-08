package com.reactivespring.controller.v1;


import com.reactivespring.document.Item;
import com.reactivespring.repository.ItemReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static com.reactivespring.constants.ItemConstants.ITEM_END_POINT_V1;

@RestController
@Slf4j
public class ItemController {

    @Autowired
    ItemReactiveRepository itemReactiveRepository;


    @GetMapping(ITEM_END_POINT_V1)
    public Flux<Item> getAllItems(){

       return itemReactiveRepository.findAll();

    }
}