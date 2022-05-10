package com.devonfw.app.java.order.general.common.api.security;

import javax.inject.Named;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlGroup;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

  public static final String APP_ID = "order-service";

  private static final String PREFIX = APP_ID + ".";

  // Groups

  public static final String GROUP_READ_MASTER_DATA = PREFIX + "ReadMasterData";

  public static final String GROUP_ADMIN = "Admin";

  public static final String GROUP_COOK = "Cook";

  public static final String GROUP_BARKEEPER = "Barkeeper";

  public static final String GROUP_WAITER = "Waiter";

  public static final String GROUP_CHIEF = "Chief";

  // Permissions

  public static final String PERMISSION_FIND_ITEM = PREFIX + "FindItem";

  public static final String PERMISSION_FIND_CUSTOMER = PREFIX + "FindCustomer";

  public static final String PERMISSION_SAVE_ORDER = PREFIX + "SaveOrder";

  public static final String PERMISSION_FIND_ORDER = PREFIX + "FindOrder";

  public static final String PERMISSION_DELETE_ORDER = PREFIX + "DeleteOrder";

  public static final String PERMISSION_RAISE_ITEM_PRICE = PREFIX + "RaiseItemPrice";

  public static final String PERMISSION_DELETE_ITEM = PREFIX + "DeleteItem";

  public static final String PERMISSION_SAVE_ITEM = PREFIX + "SaveItem";

  public static final String PERMISSION_DELETE_CUSTOMER = PREFIX + "DeleteCustomer";

  public static final String PERMISSION_SAVE_CUSTOMER = PREFIX + "SaveCustomer";

  /**
   * The constructor.
   */
  public ApplicationAccessControlConfig() {

    super();
    AccessControlGroup readMasterData = group(GROUP_READ_MASTER_DATA, PERMISSION_FIND_ITEM, PERMISSION_FIND_CUSTOMER);
    AccessControlGroup cook = group(GROUP_COOK, readMasterData, PERMISSION_SAVE_ORDER, PERMISSION_FIND_ORDER);
    AccessControlGroup barkeeper = group(GROUP_BARKEEPER, cook, PERMISSION_DELETE_ORDER);
    AccessControlGroup waiter = group(GROUP_WAITER, barkeeper);
    AccessControlGroup chief = group(GROUP_CHIEF, waiter, PERMISSION_RAISE_ITEM_PRICE, PERMISSION_DELETE_ITEM,
        PERMISSION_SAVE_ITEM, PERMISSION_DELETE_CUSTOMER, PERMISSION_SAVE_CUSTOMER);
    group(GROUP_ADMIN, chief);
  }

}