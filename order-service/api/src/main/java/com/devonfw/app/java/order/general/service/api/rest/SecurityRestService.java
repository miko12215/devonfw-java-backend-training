package com.devonfw.app.java.order.general.service.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.devonfw.module.rest.common.api.RestService;

/**
 * The security REST service provides access to the csrf token, the authenticated user's meta-data. Furthermore, it
 * provides functionality to check permissions and roles of the authenticated user.
 */
@Path("/security/v1")
public interface SecurityRestService extends RestService {

  /**
   * @return the {@link UserProfileTo} of the currently logged-in user.
   */
  @GET
  @Path("/currentuser/")
  String getCurrentUser();

}