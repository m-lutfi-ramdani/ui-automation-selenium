package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import Library.CommonLib;
import UIConstant.ConstantBookStore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStore extends CommonLib {
	
	public static Books books = new Books();
	
	//Set the Book details
	public static void storeBookDetails(String automationAuthor, String automationTitle, String automationPublisher) throws Throwable {
		String authorActual = driver.findElement(By.xpath(automationAuthor)).getText();
		String titleActual = driver.findElement(By.xpath(automationTitle)).getText();
		String publisherActual = driver.findElement(By.xpath(automationPublisher)).getText();

		books.setAuthor(authorActual);
		books.setTitle(titleActual);
		books.setPublisher(publisherActual);

	}
	
	//Get and verify the book details
	public static void verifyBookDetails(String automationAuthor, String automationTitle, String automationPublisher) throws Throwable {
		String authorExpected = driver.findElement(By.xpath(automationAuthor)).getText();
		String titleExpected = driver.findElement(By.xpath(automationTitle)).getText();
		String publisherExpected = driver.findElement(By.xpath(automationPublisher)).getText();
		
		Assert.assertTrue("\n" + " Text - Actual : " + books.getAuthor() + "\n" + " Text - Expected : " + authorExpected, books.getAuthor().contains(authorExpected));
		Assert.assertTrue("\n" + " Text - Actual : " + books.getTitle() + "\n" + " Text - Expected : " + titleExpected, books.getTitle().contains(titleExpected));
		Assert.assertTrue("\n" + " Text - Actual : " + books.getPublisher() + "\n" + " Text - Expected : " + publisherExpected, books.getPublisher().contains(publisherExpected));

	}
	
	
	//Step definitions
	@Given("User access Select Books page on Demo QA web apps")
	public void user_access_select_books_page_on_demo_qa_web_apps() throws Throwable {
		SelectDriver();
		selectBooksPage();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@When("User in Book Store page {string}")
	public void user_in_book_store_page(String titlePage) throws Throwable {
	    CommonLib.textValidation(ConstantBookStore.BOOK_STORE_PAGE, titlePage);
	}

	@When("User search book {string}")
	public void user_search_book(String searchKey) throws Throwable {
	    CommonLib.enterValue(ConstantBookStore.SEARCH_BOOK_FIELD, searchKey);
	}

	@Then("User see No rows found text")
	public void user_see_no_rows_found_text() throws Throwable {
	    CommonLib.textValidation(ConstantBookStore.NO_ROW_FOUND, "No rows found");
	}
	
	@When("User click the selected book")
	public void user_click_the_selected_book() throws Throwable {
		storeBookDetails(ConstantBookStore.SELECTED_BOOK_TITLE
				,ConstantBookStore.SELECTED_BOOK_AUTHOR
				,ConstantBookStore.SELECTED_BOOK_PUBLISHER
				);
	    CommonLib.isElementVerifyClick(ConstantBookStore.SELECTED_BOOK_TITLE);
	}

	@Then("User see the details of book")
	public void user_see_the_details_of_book() throws Throwable {
		verifyBookDetails(ConstantBookStore.BOOK_TITLE_VALIDATE
				,ConstantBookStore.BOOK_AUTHOR_VALIDATE
				,ConstantBookStore.BOOK_PUBLISHER_VALIDATE);
	}
}
