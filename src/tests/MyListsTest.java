package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String
            name_of_folder = "Learning programming",
            name_of_folder_for_homework = "Homework Ex5";

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if(Platform.getInstance().isIOS()){
            ArticlePageObject.closeArticle();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }



    //Under this line are located homework "Ex5: Тест: сохранение двух статей"
    public void testEx5SaveTwoArticleToMyListAndDelete()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Swift");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        String article_title = MyListsPageObject.getSecondArticleTitle();//вот тут

        ArticlePageObject.clickByArticleWithTitle(0);
        ArticlePageObject.waitForTitleElement();

        ArticlePageObject.addArticleToMyList(name_of_folder_for_homework);
        ArticlePageObject.clearTitleAndChooseOldItem();
        ArticlePageObject.clickByArticleWithTitle(1);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addSecondArticleToMyList(name_of_folder_for_homework);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();


        MyListsPageObject.openFolderByName(name_of_folder_for_homework);
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
