package com.qa.ims.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDao;
	private Utils utils;
	
	public OrderController(OrderDAO orderDao, Utils utils) {
		super();
		this.orderDao = orderDao;
		this.utils = utils;
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDao.readAll();
		for(Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	@Override
	public Order create() {
		LOGGER.info("Enter customer id");
		Long customer_id = utils.getLong();
		Order order = orderDao.create(new Order(customer_id));
		LOGGER.info("Order was created");
		return order;
	}
	
	public void orderItem(Long order_id) {
		LOGGER.info("Enter item id");
		Long id = utils.getLong();
		orderDao.item(id, order_id);
		
	}
	
	@Override
	public Order update() {
		LOGGER.info("Enter the customer id to update");
		Long id = utils.getLong();
		Order order = orderDao.read(id);
		LOGGER.info("Add or delete an item in this order? Add/Delete/Cancel");
		String choice = utils.getString();
		if(choice.toLowerCase().trim().equals("add")) {
			orderItem(order.getId());
		}else if(choice.toLowerCase().trim().equals("delete")) {
			delItem(order.getId());
		}
		LOGGER.info("Order was updated");
		return order;
	} 
	
	@Override
	public int delete(){
		LOGGER.info("Enter the id to delete");
		Long id = utils.getLong();
		return orderDao.delete(id);
	}

	
	public void delItem(Long order_id) {
		LOGGER.info("Enter the item id");
		Long id = utils.getLong();
		orderDao.delItem(id, order_id);
	}
	

}
