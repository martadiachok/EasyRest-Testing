package com.easyrest.tests.owner;

import com.easyrest.config.ConfigProvider;
import com.easyrest.facade.SignInFacade;
import com.easyrest.facade.owner.AddSecondRestaurantFacade;
import com.easyrest.pages.OwnerPanel;
import com.easyrest.pages.SignInPage;
import com.easyrest.tests.BaseTest;
import com.easyrest.userData.FakeData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddSecondRestaurantTest extends BaseTest {
    private final String ownerEmail = ConfigProvider.ownerEmail;
    private final String ownerPassword = ConfigProvider.ownerPassword;
    private SignInPage signInPage;
    private SignInFacade signInFacade;
    private AddSecondRestaurantFacade addSecondRestaurantFacade;
    private OwnerPanel ownerPanel;

    @BeforeMethod
    public void goToSignInOwner() {
        signInPage = new SignInPage(driver);
        signInFacade = new SignInFacade(driver);
        signInPage.goToSignInPage();
        signInFacade.signIn(ownerEmail, ownerPassword);
    }

    @Test
    public void addSecondRestaurantsTest() {
        addSecondRestaurantFacade = new AddSecondRestaurantFacade(driver);
        ownerPanel = new OwnerPanel(driver);
        String name = FakeData.getNameRestaurants();
        String address = FakeData.getAddress();
        addSecondRestaurantFacade.addSecondRestaurant(name, address);
        Assert.assertTrue(ownerPanel.isRestaurantsDisplayed(name), "The restaurant has not been added");
    }
}
