package com.devonfw.app.java.order.orderservice.service.impl.rest;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.general.service.base.test.RestServiceTest;
import com.devonfw.app.java.order.orderservice.common.base.ItemEtoBuilder;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;
import com.devonfw.module.service.common.api.client.config.ServiceClientConfigBuilder;

public class OrderserviceRestServiceImplTest extends RestServiceTest {

  @Test
  void shouldFindItem() {

    OrderserviceRestService orderService = getOrderService();

    ItemSearchCriteriaTo searchCriteriaTo = new ItemSearchCriteriaTo();
    searchCriteriaTo.setName("tacos");

    Page<ItemEto> items = orderService.findItems(searchCriteriaTo);
    assertThat(items.getNumberOfElements()).isEqualTo(1);
    assertThat(items.getContent().get(0).getName()).isEqualTo("tacos");

  }

  @Test
  void shouldGetItem() {

    OrderserviceRestService orderService = getOrderService();

    ItemEto item = orderService.getItem(23L);

    assertThat(item).isNotNull();
    assertThat(item.getId()).isEqualTo(23L);
    assertThat(item.getName()).isEqualTo("tacos");

  }

  @Test
  void shouldCreateItem() {

    OrderserviceRestService orderService = getOrderService();

    ItemEto paella = ItemEtoBuilder.anItemEto().withName("paella").withDescription("Mexican").withPrice(50.0).build();
    orderService.saveItem(paella);

    ItemSearchCriteriaTo searchCriteriaTo = new ItemSearchCriteriaTo();
    searchCriteriaTo.setName("paella");

    Page<ItemEto> items = orderService.findItems(searchCriteriaTo);
    assertThat(items.getNumberOfElements()).isEqualTo(1);
    assertThat(items.getContent().get(0).getName()).isEqualTo("paella");

  }

  private OrderserviceRestService getOrderService() {

    String login = "admin";
    String password = "admin";
    OrderserviceRestService orderService = getServiceClientFactory().create(OrderserviceRestService.class,
        new ServiceClientConfigBuilder().host("localhost").authBasic().userLogin(login).userPassword(password)
            .buildMap());
    return orderService;
  }

}
