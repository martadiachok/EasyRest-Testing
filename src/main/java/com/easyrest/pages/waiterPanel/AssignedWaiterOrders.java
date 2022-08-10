package com.easyrest.pages.waiterPanel;

import com.easyrest.components.waiter.AssignedWaiterOrderItem;
import com.easyrest.pages.WaiterPage;
import org.openqa.selenium.WebDriver;

public class AssignedWaiterOrders extends WaiterPage {

    public AssignedWaiterOrders(WebDriver driver) {
        super(driver);
    }

    public AssignedWaiterOrderItem getAssignedWaiterOrderItem() {
        return new AssignedWaiterOrderItem(driver);
    }

}