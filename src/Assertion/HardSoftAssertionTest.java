package Assertion;

//package hardAndSoftAssertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardSoftAssertionTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void hardAssertion() {
		Assert.assertEquals("pass", "pass");
		System.out.println("This line is executed because assertEquals " + "passed as both the strings are same");
		Assert.assertNull("assertion");
		System.out.println("Since the object under assertion" + " is not null, the assertion will fail. "
				+ "This line will not be executed");
	}

	@Test
	public void softAssertion() {

		softAssert.assertNull("assertion");
		System.out.println(
				"We are using Soft assertion in this method," + " so this line of code will also be executed even if "
						+ "the assetion fails.Wherever we want to execute full "
						+ "testcase/method, we should use SoftAssertion");
		Assert.assertEquals("pass", "pass");
		System.out.println("soft assertion after pass value");
		softAssert.assertAll();
	}

}
