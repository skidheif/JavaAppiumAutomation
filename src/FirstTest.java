//import lib.CoreTestCase;
//import lib.ui.*;
//import org.junit.Test;
//
//public class FirstTest extends CoreTestCase {
//
//
//
//
//
//
//    //Under this line are located homework "Ex5: Тест: сохранение двух статей"
//    @Test
//    public void testEx5SaveTwoArticleToMyListAndDelete()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                15
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Swift",
//                "Cannot find search input",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container'][@index = " + 0 + "]"),
//                "Cannot find the first element in list, searching by Swift",
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
//                "Cannot find button to open article options",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text = 'Add to reading list']"),
//                "Cannot find option to add article to reading list",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find 'Got it' tip overlay",
//                15
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot find input to set name of art",
//                15
//        );
//
//        String name_of_folder = "Homework Ex5";
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "Cannot put text into articles folder input",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text = 'OK']"),
//                "Cannot press OK button",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/menu_page_search"),
//                "Cannot find search_button",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/text1"),
//                "Cannot find the first element of recent search list",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container'][@index = " + 1 + "]"),
//                "Cannot find the first element in list, searching by Swift",
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
//                "Cannot find button to open article options",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text = 'Add to reading list']"),
//                "Cannot find option to add article to reading list",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text = '" + name_of_folder + "']"),
//                "Cannot find folder to add article to reading list",
//                15
//        );
//
//        String x_link = "//android.widget.ImageButton[@content-desc = 'Navigate up']";
//        MainPageObject.waitForElementPresent(
//                By.xpath(x_link),
//                "Cannot find X link",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath(x_link),
//                "Cannot close article, cannot find X link",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc = 'My lists']"),
//                "Cannot find navigation button to my lists",
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text = '" + name_of_folder + "']"),
//                "Cannot find created folder",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text = '" + name_of_folder + "']"),
//                "Cannot find created folder",
//                15
//        );
//
//        String text_article = "//*[@text = 'Swift (programming language)']";
//        MainPageObject.swipeElementToLeft(
//                By.xpath(text_article),
//                "Cannot find save article"
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath(text_article),
//                "Cannot delete save article",
//                15
//        );
//
//        String title_path = "//*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[@text = 'Swift']";
//        MainPageObject.waitForElementPresent(
//                By.xpath(title_path),
//                "Cannot find the article with title Swift",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath(title_path),
//                "Cannot find the element with article Swift in the list",
//                15
//        );
//
//
//        WebElement title_element =  MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );
//
//        String article_title = title_element.getAttribute("text");
//        assertEquals(
//                "We see unexpected title",
//                "Swift",
//                article_title
//        );
//    }
//    // End of the homework "Ex5: Тест: сохранение двух статей"
//
//
//    //Under this line are located homework "Ex6: Тест: assert title"
//    @Test
//    public void testEx6TestAssertTitle()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                15
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Swift",
//                "Cannot find search input",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_container'][@index = " + 0 + "]"),
//                "Cannot find the first element in list, searching by Swift",
//                15
//        );
//
//        MainPageObject.assertElementPresentEx6(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find title = "
//        );
//    }
//    // End of the homework "Ex6: Тест: assert title"
//}
