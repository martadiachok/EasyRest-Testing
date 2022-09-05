package com.easyrest.tests.administrator;

import com.easyrest.config.ConfigProvider;
import com.easyrest.dao.OrderDao;
import com.easyrest.facade.AdministratorOperationsFacade;
import com.easyrest.facade.AuthorizedHeaderMenuPanelFacade;
import com.easyrest.facade.SignInFacade;
import com.easyrest.pages.SignInPage;
import com.easyrest.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdministratorOperationsTest extends BaseTest {

    private final String email = ConfigProvider.administratorEmail;
    private final String password = ConfigProvider.administratorPassword;
    private AdministratorOperationsFacade administrator;
    private OrderDao orderDao;
    private int insertedOrderId;

    @BeforeMethod
    public void init() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToSignInPage();
        SignInFacade signInFacade = new SignInFacade(driver);
        signInFacade.signIn(email, password);
        administrator = new AdministratorOperationsFacade(driver);
        orderDao = new OrderDao();
    }

    @Test
    public void acceptWaitingForConfirmOrder() {
        insertedOrderId = orderDao.saveWaitingForConfirmOrder(email);
        Integer ordersCountBeforeAccepting = administrator.seeWaitingForConfirmOrdersCount();
        administrator.acceptOrder();
        Integer ordersCountAfterAccepting = administrator.seeWaitingForConfirmOrdersCount();

        Assert.assertEquals(ordersCountAfterAccepting, ordersCountBeforeAccepting - 1, "Order is not accepted");
    }

    @Test
    public void assignWaiterForAcceptedOrder() {
        insertedOrderId = orderDao.saveAcceptedOrder(email);
        Integer ordersCountBeforeAssigning = administrator.seeAcceptedOrdersCount();
        administrator.assignWaiter();
        Integer ordersCountAfterAssigning = administrator.seeAcceptedOrdersCount();

        Assert.assertEquals(ordersCountAfterAssigning, ordersCountBeforeAssigning - 1, "Waiter is not assigned");
    }

    @AfterMethod
    public void cleanup() {
        orderDao.deleteOrder(insertedOrderId);
        AuthorizedHeaderMenuPanelFacade menu = new AuthorizedHeaderMenuPanelFacade(driver);
        menu.clickOnLogoutMenuItem();
    }

}
