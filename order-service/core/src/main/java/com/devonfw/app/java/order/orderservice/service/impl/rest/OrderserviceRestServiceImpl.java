package com.devonfw.app.java.order.orderservice.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Orderservice}.
 */
@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

  @Inject
  private Orderservice orderservice;

  @Override
  public ItemEto getItem(long id) {

    return this.orderservice.findItem(id);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    return this.orderservice.saveItem(item);
  }

  @Override
  public void deleteItem(long id) {

    this.orderservice.deleteItem(id);
  }

  @Override
  public Page<ItemEto> findItems(ItemSearchCriteriaTo searchCriteriaTo) {

    return this.orderservice.findItems(searchCriteriaTo);
  }

  @Override
  public CustomerEto getCustomer(long id) {

    return this.orderservice.findCustomer(id);
  }

  @Override
  public CustomerEto saveCustomer(CustomerEto customer) {

    return this.orderservice.saveCustomer(customer);
  }

  @Override
  public void deleteCustomer(long id) {

    this.orderservice.deleteCustomer(id);
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo searchCriteriaTo) {

    return this.orderservice.findCustomers(searchCriteriaTo);
  }

  @Override
  public OrderEto getOrder(long id) {

    return this.orderservice.findOrder(id);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.orderservice.saveOrder(order);
  }

  @Override
  public void deleteOrder(long id) {

    this.orderservice.deleteOrder(id);
  }

  @Override
  public Page<OrderCto> findOrders(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.orderservice.findOrders(searchCriteriaTo);
  }

}
