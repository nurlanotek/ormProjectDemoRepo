package org.uca.sas.cs.course1.lesson5.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id="newMessageText")
    private WebElement newMessageText;

    @FindBy(id="pChatMessages")
    private WebElement pChatMessages;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitNewTextMessageToChat(String text) {
        newMessageText.sendKeys("Hi, all!");
        newMessageText.submit();
    }


}
