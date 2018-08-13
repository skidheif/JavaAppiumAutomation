package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text = 'View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc = 'More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text = 'Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text = 'OK']",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc = 'Navigate up']",
            ELEMENTS_IN_LIST = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container'][@index = '{INDEX_OF_TITLE}']",
            PAGE_SEARCH_BUTTON = "id:org.wikipedia:id/menu_page_search",
            OLD_TITLE = "id:org.wikipedia:id/text1",
            NAME_OF_LIST = "xpath://*[@resource-id = 'org.wikipedia:id/item_title'][@text = '{LIST_NAME_WITH_ARTICLE}']",
            SECOND_TITLE_IN_THE_LIST = "id:org.wikipedia:id/page_list_item_title";

    private static String getIndexOfTitle(int index_of_title)
    {
        String index_title = String.valueOf(index_of_title);
        return ELEMENTS_IN_LIST.replace("{INDEX_OF_TITLE}", index_title);
    }

    private static String getNameOfFolder(String name_of_folder)
    {
        return NAME_OF_LIST.replace("{LIST_NAME_WITH_ARTICLE}", name_of_folder);
    }

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15 );
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void waitAndCheckThatSecondElementDelete()
    {
        this.waitForElementNotPresent(
                SECOND_TITLE_IN_THE_LIST,
                "Cannot delete save article",
                15
        );
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of art",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void clickByArticleWithTitle(int index_of_title)
    {
        String get_index_of_title = getIndexOfTitle(index_of_title);
        this.waitForElementAndClick(get_index_of_title, "Cannot find and click search result with substring" + index_of_title, 10);
    }

    public void clearTitleAndChooseOldItem()
    {
        this.waitForElementAndClick(
                PAGE_SEARCH_BUTTON,
                "Cannot find search_button",
                15
        );

        this.waitForElementAndClick(
                OLD_TITLE,
                "Cannot find the first element of recent search list",
                15
        );
    }

    public void addSecondArticleToMyList(String name_of_folder)
    {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        String name_of_folder_with_articles = getNameOfFolder(name_of_folder);

        this.waitForElementAndClick(
                name_of_folder_with_articles,
                "Cannot find folder to add article to reading list",
                15
        );
    }

    public void assertElementPresentEx6() // method for task Ex6
    {
        this.assertElementPresentEx6(
                TITLE,
                "Cannot find title = "
        );
    }
}
