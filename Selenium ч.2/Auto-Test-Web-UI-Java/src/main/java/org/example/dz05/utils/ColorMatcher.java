package org.example.dz05.utils;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

/**
 * Created by Olga Shestakova
 * Date 31.08.2021
 */
public class ColorMatcher extends TypeSafeMatcher<WebElement> {
    private String colorToCompare;

    @Override
    protected boolean matchesSafely(WebElement element) {
        if (element.getCssValue("color").equals(colorToCompare)) {
            return true;
        } else {
            return false;
        }
    }

    public ColorMatcher(String colorToCompare) {
        this.colorToCompare = colorToCompare;
    }

    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("color of element ").appendValue(item).appendText(" was ")
                .appendValue(item.getCssValue("color"));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("excpected color :" + colorToCompare);
    }

    public static Matcher<WebElement> hasColor(String color) {
        return new ColorMatcher(color);
    }
}
