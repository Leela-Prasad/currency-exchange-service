package com.microservices.currency.exchange.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currency.exchange.service.models.CurrencyExchangeBean;
import com.microservices.currency.exchange.service.repositories.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchangeBean getExchangeValue(@PathVariable("fromCurrency") String fromCurrency,
										 @PathVariable("toCurrency") String toCurrency) {
		//ExchangeValue exchangeValue = new ExchangeValue(100,fromCurrency,toCurrency,new BigDecimal("65"));
		CurrencyExchangeBean exchangeValue = repository.findByFromAndTo(fromCurrency, toCurrency); 
		exchangeValue.setPort(Integer.parseInt(env.getProperty("server.port")));
		return exchangeValue;
		
	}
}
