package com.example.EssayReviewApp;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.EssayReviewApp.controller.Controller;


public class EssayViewsTest {
    @org.junit.Rule
    public ActivityScenarioRule<Controller> activityRule = new ActivityScenarioRule<>(Controller.class);

    @org.junit.Test
    public void testBackButton() {
        onView(withId(R.id.essaysButton)).perform(click());
        ViewInteraction essay = onView(withId(R.id.titleEditText));
        essay.check(matches(withHint(R.string.Title)));
        
        onView(withId(R.id.mainmenu)).perform(click());
         onView(withId(R.id.menuLabel));

    }
    //menu is the back button.

    @org.junit.Test
    public void testSubmitButton() {
        testEssayButton();
        // Type text into title, text, and type fields
        onView(withId(R.id.titleEditText)).perform(typeText("Title"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.textEditText)).perform(typeText("Text"), closeSoftKeyboard());

        // Click on the submit button
        onView(withId(R.id.submitButton)).perform(click());
        ViewInteraction item = onView(withId(R.id.titleEditText));
        ViewInteraction t = onView(withId(R.id.textEditText));

        // Check if the new essay item is displayed
        item.check(ViewAssertions.matches(withHint(R.string.Title)));
        //item.check(matches(withText(R.string.Type)));
        t.check(ViewAssertions.matches(withHint(R.string.Text)));

    }

    @org.junit.Test
    public void testEssayButton() {
        onView(withId(R.id.essaysButton)).perform(click());
        ViewInteraction essay = onView(withId(R.id.titleEditText));
        essay.check(matches(withHint(R.string.Title)));
    }

   @org.junit.Test

   public void testAllEssaysButton(){
       onView(withId(R.id.allEssaysButton)).perform(click());
       onView(withId(R.id.allEssaysButton)).check(matches(isDisplayed()));
       onView(withId(R.id.allEssaysButton)).check(matches(withText(R.string.MM)));
   }
}