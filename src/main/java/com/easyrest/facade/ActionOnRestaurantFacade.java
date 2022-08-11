package com.easyrest.facade;

import com.easyrest.components.ActionOnRestaurants;
import com.easyrest.components.HeaderForAuthorizedUser;
import com.easyrest.components.UserRoleMenuPanel;
import com.easyrest.components.moderator.LeftSideMenu;
import com.easyrest.pages.moderatorPanel.Restaurants;
import org.openqa.selenium.WebDriver;

public class ActionOnRestaurantFacade {
    private WebDriver driver;
    private ActionOnRestaurants actionOnRestaurants;
    private LeftSideMenu leftSideMenu;

    public ActionOnRestaurantFacade(WebDriver driver) {
        actionOnRestaurants = new ActionOnRestaurants(driver);
        leftSideMenu = new LeftSideMenu(driver);
        this.driver = driver;
    }

    public void seeAllRestaurants() {
        leftSideMenu.clickOnMenuButtonRestaurants();
    }

    private void clickUnapprovedRestaurant() {
        leftSideMenu.clickOnMenuButtonRestaurants();
        actionOnRestaurants.clickOnButtonUnapproved();
    }

    private void clickApprovedRestaurant() {
        leftSideMenu.clickOnMenuButtonRestaurants();
        actionOnRestaurants.clickOnButtonApproved();
    }

    private void clickArchivedRestaurant() {
        leftSideMenu.clickOnMenuButtonRestaurants();
        actionOnRestaurants.clickOnButtonArchived();
    }

    public boolean approveRestaurant() {
        clickUnapprovedRestaurant();
        String restaurantName = actionOnRestaurants.getFirstNameFromRestaurant();
        actionOnRestaurants.approveRestaurant();
        return actionOnRestaurants.checkIfRestaurantMovedToApprovedList(restaurantName);
    }

    public boolean disapproveRestaurant() {
        clickUnapprovedRestaurant();
        String restaurantName = actionOnRestaurants.getFirstNameFromRestaurant();
        actionOnRestaurants.disapproveRestaurant();
        return actionOnRestaurants.checkIfRestaurantMovedToArchivedList(restaurantName);
    }

    public boolean archiveRestaurant() {
        clickApprovedRestaurant();
        String restaurantName = actionOnRestaurants.getFirstNameFromRestaurant();
        actionOnRestaurants.archiveRestaurant();
        return actionOnRestaurants.checkIfRestaurantMovedToArchivedList(restaurantName);
    }

    public boolean restoreRestaurant() {
        clickArchivedRestaurant();
        String restaurantName = actionOnRestaurants.getFirstNameFromRestaurant();
        actionOnRestaurants.restoreRestaurant();
        return actionOnRestaurants.checkIfRestaurantMovedToApprovedList(restaurantName);
    }
}