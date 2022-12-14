package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
	protected final String name;

	public TestCase(String name) {
		this.name = name;
	}

	public TestResult run() {
		TestResult result = new TestResult();
		result.testStarted();
		setUp();

		try {
			Method method = getClass().getMethod(name);
			method.invoke(this);
		} catch (Exception e) {
			result.testFailed();
		}

		tearDown();
		return result;
	}

	public void tearDown() {
	}

	public void setUp() {
	}
}
