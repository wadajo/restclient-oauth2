package com.wadajo.resource_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelsController {

        @GetMapping("/hotels")
        public String[] getHotels() {
            return new String[] { "Hotel Ibis Budget", "Hotel AC by Marriott", "Hotel Ibis La Garena" };
        }

}
