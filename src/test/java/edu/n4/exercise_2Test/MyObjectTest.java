package edu.n4.exercise_2Test;

import org.junit.jupiter.api.Test;
import edu.n4.exercise_2.MyObject;
import org.hamcrest.Matcher;
import org.hamcrest.FeatureMatcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MyObjectTest {

	public static Matcher<String> length(Matcher<? super Integer> matcher) {
		return new FeatureMatcher<String, Integer>(matcher, "a String of length that", "length") {
			@Override
			protected Integer featureValueOf(String actual) {
				return actual.length();
			}
		};
	}

	@Test
	void givenMordorString_whenHaveLenght6_thenAssertionSucceeds() {
		int expectedLenght = 6;
		String mordorString = new MyObject().getMordorString();
		assertThat(mordorString, length(is(expectedLenght)));
	}
}
