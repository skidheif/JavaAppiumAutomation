package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    //Under this line are located homework "Ex5: Тест: сохранение двух статей"
    public void testEx5SaveTwoArticleToMyListAndDelete()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Swift");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        String article_title = MyListsPageObject.getSecondArticleTitle();

        ArticlePageObject.clickByArticleWithTitle(0);
        ArticlePageObject.waitForTitleElement();

        String name_of_folder = "Homework Ex5";

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.clearTitleAndChooseOldItem();
        ArticlePageObject.clickByArticleWithTitle(1);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();


        MyListsPageObject.openFolderByName(name_of_folder);// lошел до сюда точно
        MyListsPageObject.swipeSecondElementInListByArticleToDelete(article_title);

        ArticlePageObject.waitAndCheckThatSecondElementDelete();

        MyListsPageObject.openTheFirstArticleInListAndCheck();

        String first_element_in_list = ArticlePageObject.getArticleTitle();
        assertEquals(
                "We see unexpected title",
                "Swift",
                first_element_in_list
        );
    }
    // End of the homework "Ex5: Тест: сохранение двух статей"
}
