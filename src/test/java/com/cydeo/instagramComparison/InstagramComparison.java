package com.cydeo.instagramComparison;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InstagramComparison {

    @Test
    public void test(){

        String username = UsernamePassword.username;
        String password = UsernamePassword.password;

        //Open Instagram and Login
        Driver.getDriver().get("https://www.instagram.com/");
        Driver.getDriver().findElement(
                By.xpath("//input[@name='username']")).sendKeys(username);
        Driver.getDriver().findElement(
                By.xpath("//input[@name='password']")).sendKeys(password + Keys.ENTER);

        //Click Confirmation
        Driver.getDriver().findElement(By.xpath("//button[.='Not Now']")).click();
        try {
            Driver.getDriver().findElement(By.xpath("//button[.='Not Now']")).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

        //Open Profile Page
        Driver.getDriver().findElement(By.xpath("(//div[.='Profile'])[4]")).click();

        //Click and Open Followers Small Window
        Driver.getDriver().findElement(By.xpath("//a[@href='/" + username + "/followers/']")).click();

        List<WebElement> followersList = new ArrayList<>();
        List<String> followersNames = new ArrayList<>();

        //Calculate Total Number Of Followers
        String numOfFollowersStr = Driver.getDriver().findElement(
                By.xpath("(//span[@class='_ac2a']/span)[2]")).getText();
        int numOfFollowers = Integer.parseInt(numOfFollowersStr);

        WebElement followersWindow = Driver.getDriver().findElement(
                By.xpath("(//div[@role='dialog'])[2]//div[@class='_aano']"));

        // Scroll down and add each Follower name's element into The List
        while (followersList.size() < numOfFollowers) {

            ((JavascriptExecutor) Driver.getDriver()).executeScript(
                    "arguments[0].scroll(0, arguments[0].scrollHeight)", followersWindow);

            followersList = Driver.getDriver().findElements(
                    By.xpath("//div[@style='height: auto; overflow: hidden auto;']//span/div"));
        }

        // Get Each Follower name from Element List
        for (WebElement eachElement : followersList) {
            if (eachElement.getText().equalsIgnoreCase("verified")){
                continue;
            }
            followersNames.add(eachElement.getText());
        }

        //Close Followers Small Window
        Driver.getDriver().findElement(By.xpath("(//div[@class='_abm0'])[2]")).click();

        System.out.println(followersNames.size() + " Profiles Are Following You.");

        //-----------------------------------------------------------------------------------------------------------

        //Calculate Total Number Of Followings
        String numOfFollowingsStr = Driver.getDriver().findElement(
                        By.xpath("(//span[@class='_ac2a']/span)[3]")).getText();
        int numOfFollowings = Integer.parseInt(numOfFollowingsStr);

        //Click and Open Following Small Window
        Driver.getDriver().findElement(By.xpath("//a[@href='/" + username + "/following/']")).click();

        List<WebElement> followingList = new ArrayList<>();
        List<String> followingNames = new ArrayList<>();

        WebElement followingsWindow = Driver.getDriver().findElement(
                By.xpath("(//div[@role='dialog'])[2]//div[@class='_aano']"));

        // Scroll down and add each Following name's element into The List
        while (followingList.size() < numOfFollowings-3) {

            ((JavascriptExecutor) Driver.getDriver()).executeScript(
                    "arguments[0].scroll(0, arguments[0].scrollHeight)", followingsWindow);

            followingList = Driver.getDriver().findElements(
                    By.xpath("//div[@style='height: auto; overflow: hidden auto;']//span/div"));

        }

        // Get Each Following name from Element List
        for (WebElement eachElement : followingList) {
            if (eachElement.getText().equalsIgnoreCase("verified")){
                continue;
            }
            followingNames.add(eachElement.getText());
        }

        //Close Followings Small Window
        Driver.getDriver().findElement(By.xpath("(//div[@class='_abm0'])[2]")).click();

        System.out.println("You Are Following " + followingNames.size() + " Profiles.");

        //----------------------------------------------------------------------------------------------------------

        followingNames.removeAll(followersNames);
        System.out.println("You Can Delete " + followingNames.size() + " Profiles, Right Now!!!");
        System.out.println("Below is the Profiles that You Can Delete Immediately: ");
        for (String each : followingNames) {
            System.out.println(each);
        }

        Driver.closeDriver();

    }

}
