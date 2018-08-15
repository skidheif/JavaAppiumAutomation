package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";

        ELEMENTS_IN_LIST = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container'][@index = '{INDEX_OF_TITLE}']";
        PAGE_SEARCH_BUTTON = "id:org.wikipedia:id/menu_page_search";
        OLD_TITLE = "id:org.wikipedia:id/text1";
        NAME_OF_LIST = "xpath://*[@resource-id = 'org.wikipedia:id/item_title'][@text = '{LIST_NAME_WITH_ARTICLE}']";
        SECOND_TITLE_IN_THE_LIST = "id:org.wikipedia:id/page_list_item_title";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
