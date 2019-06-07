package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	public void assertEquals() {
		Assert.assertEquals("This assertion will pass", "This assertion will pass");
		System.out.println("This line is executed because assertEquals " + "passed since both the strings are same");
		Assert.assertEquals("assertion", "This assertion will fail");
		System.out.println(
				"This line will not be executed because " + "assertEquals fails both the strings are different."
						+ "Also the test/method will be declared failed");
	}

	@Test
	public void assertNotEquals() {
		Assert.assertNotEquals("This assertion will pass", "Since the " + "expected and actual result do not match");
		System.out.println("This line is executed because assertNotEquals" + " assertion pass for the given situation");
	}

	@Test
	public void assertTrue() {
		Assert.assertTrue(3 < 5);
		System.out.println(
				"This line will be executed as assertTrue will" + " pass because the 3<5(which will return true)");
	}

	@Test
	public void assertFalse() {
		Assert.assertFalse(3 > 5);
		System.out.println("This line is executed because assertFalse"
				+ "assertion passes as the given condition will return false");
	}

	@Test
	public void assertNull() {
		Assert.assertNull(null);
		System.out.println("Since we we set null in the condition, the assertion " + "assertNull will pass");
	}

	@Test
	public void assertNotNull() {
		Assert.assertNotNull("This assertion will pass because this " + "string don't returns a null value");
		System.out.println("This line is executed because assertNotNull have have passed");
	}
}