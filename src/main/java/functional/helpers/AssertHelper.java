package functional.helpers;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.*;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description: Generic assertion methods
 */

public class AssertHelper {
    public static <T> void assertThat(String reason, T actual, Matcher<T> matcher) {
        MatcherAssert.assertThat(reason, actual, matcher);
    }

    public static <T> void assertEquals(String reason, T actual, T expected) {
        assertThat(reason, actual, is(expected));
    }

    public static void contains(String reason, String actual, String expected) {
        assertThat(reason, actual, containsString(expected));
    }

    public static void assertTrue(String reason, Boolean actualCondition) {
        assertThat(reason, actualCondition, is(Boolean.TRUE));
    }

    public static void assertFalse(String reason, Boolean actualCondition) {
        assertThat(reason, actualCondition, is(Boolean.FALSE));
    }
}
