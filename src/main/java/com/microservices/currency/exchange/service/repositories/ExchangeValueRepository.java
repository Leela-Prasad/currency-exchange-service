package com.microservices.currency.exchange.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currency.exchange.service.models.CurrencyExchangeBean;

public interface ExchangeValueRepository extends JpaRepository<CurrencyExchangeBean,Integer>{

	public abstract CurrencyExchangeBean findByFromAndTo(String from,String to);
	
}
