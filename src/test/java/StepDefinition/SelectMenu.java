package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Library.CommonLib;
import UIConstant.ConstantSelectMenu;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectMenu extends CommonLib {
	
	private static String[] multiSelect = {"Green", "Blue", "Black", "Red"};
	
	//App will closed after execution
	@After
	public void closeApp() throws Throwable {
		CommonLib.closeApplication();
	}
	
	//Step definitions
	@Given("User access Select Menu page on Demo QA web apps")
	public void user_access_select_menu_page_on_demo_qa_web_apps() throws Throwable {
		SelectDriver();
		selectMenuPage();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@When("User in Select Menu page {string}")
	public void user_in_select_menu_page(String titlePage) throws Throwable {
	    CommonLib.textValidation(ConstantSelectMenu.SELECT_MENU_PAGE, titlePage);
	}

	@When("User choose select value {string}")
	public void user_choose_select_value(String selectValue) throws Throwable {
	    CommonLib.enterValue(ConstantSelectMenu.SELECT_MENU_FIELD, selectValue);
	    CommonLib.pressEnterKey(ConstantSelectMenu.SELECT_MENU_FIELD);
	    
	}

	@When("User choose select one {string}")
	public void user_choose_select_one(String selectOne) throws Throwable {
		CommonLib.enterValue(ConstantSelectMenu.SELECT_ONE_FIELD, selectOne);
	    CommonLib.pressEnterKey(ConstantSelectMenu.SELECT_ONE_FIELD);
	}

	@When("User choose old style select menu {string}")
	public void user_choose_old_style_select_menu(String oldStyleSelect) throws Throwable {
	    CommonLib.selectValueByOption(ConstantSelectMenu.OLD_SELECT_DROPDOWN, oldStyleSelect);

	}

	@When("User choose multi select drop down all color")
	public void user_choose_multi_select_drop_down_all_color() throws Throwable {
		WebElement multiSelectField = driver.findElement(By.xpath(ConstantSelectMenu.MULTISELECT_FIELD));
		for (String input : multiSelect) {
			multiSelectField.sendKeys(input);
			multiSelectField.sendKeys(Keys.ENTER);
		};
	}

	@Then("User success input all select menu {string} {string} {string}")
	public void user_success_input_all_select_menu(String selectValue, String selectOne, String oldStyleSelect) throws Throwable {
	    CommonLib.textValidation(ConstantSelectMenu.SELECT_MENU_VALIDATE, selectValue);
	    CommonLib.textValidation(ConstantSelectMenu.SELECT_ONE_VALIDATE, selectOne);
	    CommonLib.textValidation(ConstantSelectMenu.OLD_SELECT_DROPDOWN, oldStyleSelect);
		List<WebElement> multiSelectField = driver.findElements(By.xpath(ConstantSelectMenu.MULTISELECT_VALIDATE));
		String multiSelectActual = multiSelectField.get(0).getText();
		try {
	    	for (String input : multiSelect) {
		    		Assert.assertTrue("\n" + " Text - Actual : " + multiSelectActual + "\n" + " Text - Expected : " + input, multiSelectActual.contains(input));
	    		}
	    } catch (Exception e) {
	    	System.out.println("\nException caught");
	    }
		
	}

}
