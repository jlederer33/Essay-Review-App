package com.example.astudio;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.astudio.Controller.Controller;
import org.junit.runner.RunWith;

public class EssayViewsTest {
    @org.junit.Rule
    public ActivityScenarioRule<Controller> activityRule = new ActivityScenarioRule<>(Controller.class);

    @org.junit.Test
    public void testBackButton() {
        onView(withId(R.id.backButton)).perform(click());
        ViewInteraction menu = onView(withId(R.id.menuLabel));
        menu.check(ViewAssertions.matches(withText(R.string.MainMenu)));
    }

    @org.junit.Test
    public void testSubmitButton() {
        // Type text into title, text, and type fields
        onView(withId(R.id.titleEditText)).perform(typeText("Title"), closeSoftKeyboard());
        onView(withId(R.id.textEditText)).perform(typeText("Text"), closeSoftKeyboard());

        // Click on the submit button
        onView(withId(R.id.submitButton)).perform(click());
        ViewInteraction item = onView(withId(R.id.titleEditText));

        // Check if the new essay item is displayed
        item.check(ViewAssertions.matches(withText(R.string.Title)));
        item.check(ViewAssertions.matches(withText(R.string.Text)));
    }
}