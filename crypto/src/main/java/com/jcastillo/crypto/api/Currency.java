package com.jcastillo.crypto.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Currency {

	@GetMapping("currencies")
	public List<String> getCurrencies(){
		return List.of("btc","iota","bnb","ada");
	} 
}
