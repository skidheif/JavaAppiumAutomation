package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyListsPageObject extends MainPageObject {

    public static final String
            FOLDER_BY_NAME = "xpath://*[@resource-id = 'org.wikipedia:id/item_title'][@text = '{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "xpath://*[@text = '{TITLE}']",
            THE_FIRST_ARTICLE_IN_LIST_PATH = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text = 'Swift']",
            TITLE_OF_THE_FIRST_ARTICLE_IN_LIST = "id:org.wikipedia:id/view_page_title_text",
            SECOND_TITLE_IN_THE_LIST = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title'][@text = 'Swift (programming language)']";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSavedSecondArticleXpathByTitle(String article_title)
    {
        return SECOND_TITLE_IN_THE_LIST;
    }

   public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_by_xpath = getFolderXpathByName(name_of_folder);

        this.waitForElementPresent(
                folder_name_by_xpath,
                "Cannot find folder by name" + name_of_folder,
                10
        );

        this.waitForElementAndClick(
                folder_name_by_xpath,
                "Cannot find folder by name" + name_of_folder,
                10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title" + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent((article_xpath), "Saved article still present with title" + article_title, 15);
    }

    public void waitForArticleToDisappearSecondArticle(String article_title)
    {
        String article_xpath = getSavedSecondArticleXpathByTitle(article_title);
        this.waitForElementNotPresent((article_xpath), "Saved article still present with title" + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find save article"
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public WebElement waitForSecondTitleElement()
    {
        return this.waitForElementPresent((SECOND_TITLE_IN_THE_LIST), "Cannot find second article title on page!", 15 );
    }

    public String getSecondArticleTitle()
    {
        WebElement title_element = waitForSecondTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeSecondElementInListByArticleToDelete(String article_title)
    {
        this.getSavedSecondArticleXpathByTitle(article_title);
        String article_xpath = getSavedSecondArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find save article"
        );
        this.waitForArticleToDisappearSecondArticle(article_title);
    }

    public void openTheFirstArticleInListAndCheck()
    {
        this.waitForElementPresent(
                THE_FIRST_ARTICLE_IN_LIST_PATH,
                "Cannot find the article with title Swift",
                15
        );

        this.waitForElementAndClick(
                THE_FIRST_ARTICLE_IN_LIST_PATH,
                "Cannot find the element with article Swift in the list",
                15
        );


        this.waitForElementPresent(
                TITLE_OF_THE_FIRST_ARTICLE_IN_LIST,
                "Cannot find article title",
                15
        );
    }
}
