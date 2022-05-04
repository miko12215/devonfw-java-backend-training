package com.devonfw.app.java.order.general.service.impl.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.devonfw.app.java.order.general.service.api.rest.SecurityRestService;

/**
 * Implementation of {@link SecurityRestService}.
 */
@Named
@Transactional
public class SecurityRestServiceImpl implements SecurityRestService {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(SecurityRestServiceImpl.class);

  @Override
  @PermitAll
  public String getCurrentUser() {

    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = null;
    if (context != null) {
      authentication = context.getAuthentication();
    }
    if (authentication == null) {
      throw new IllegalStateException();
    }
    UserDetails user = (UserDetails) authentication.getPrincipal();
    return user.getUsername();
  }
}