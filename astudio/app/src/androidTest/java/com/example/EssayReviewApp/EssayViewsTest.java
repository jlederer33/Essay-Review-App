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
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.junit.Before;
import org.junit.Test;
import android.os.SystemClock;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.EssayReviewApp.controller.Controller;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.example.EssayReviewApp.view.AddReviewsFragment;
import com.example.EssayReviewApp.view.IAddReviewsView;
import com.example.EssayReviewApp.view.ISelectedReviewView;
import com.example.EssayReviewApp.view.SelectedEssayFragment;
import com.example.EssayReviewApp.view.SelectedReviewFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


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

    public void testAllEssaysButton() {
        onView(withId(R.id.allEssaysButton)).perform(click());
        onView(withId(R.id.aeBackButton)).check(matches(isDisplayed()));
        // onView(withId(R.id.allEssaysButton)).check(matches(withText(R.string.MM)));
    }


}
public class SelectedEssayFragmentTest {

    private Essay mockEssay;

    @Before
    public void setUp() {
        // Initialize your mockEssay here
        mockEssay = new Essay("Mock Title", "Mock Text", "Mock Type");

        // Launch the fragment with the mockEssay
        FragmentScenarios.launchInContainer(SelectedEssayFragment.class, null);
    }

    @Test
    public void testEssayDisplay() {
        onView(withId(R.id.selectedEssayTitle)).check(matches(withText(mockEssay.getTitle())));
        onView(withId(R.id.selectedEssayText)).check(matches(withText(mockEssay.getText())));
    }

    @Test
    public void testRecyclerView() {
        // Perform a scroll action on the recyclerView if necessary
        onView(withId(R.id.recyclerViewReviews))
                .perform(RecyclerViewActions.scrollToPosition(0));

        // Check if the recyclerView is displayed
        onView(withId(R.id.recyclerViewReviews)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonFunctionality() {
        // Example for testing button click
        onView(withId(R.id.backToUserEssays)).perform(click());
    }


    public void testAddReview() {
        Essay mockEssay = new Essay("Mock Title", "Mock Text", "Mock Type");
        IAddReviewsView.Listener mockListener = new IAddReviewsView.Listener("essay", "title", "text") {


            FragmentScenario<AddReviewsFragment> scenario = FragmentScenario.launchInContainer(
                    AddReviewsFragment.class,
                    AddReviewsFragmentArgs.Builder(mockListener, mockEssay).build().toBundle(),
                    R.style.AppTheme,
                    null
            );

        };

            // Enter text in the EditText fields
            onView(withId(R.id.enterReviewTitle)).

            perform(typeText("Test Review Title"));

            onView(withId(R.id.enterReviewText)).

            perform(typeText("Test Review Text"));

            // Click the submit button
            onView(withId(R.id.submitReview)).

            perform(click());



        }

    private static class Listener implements IAddReviewsView {
            // Implement the methods of the Listener interface
        }

    }

public class SelectedReviewFragmentTest {

    @Test
    public void testSelectedReviewFragmentDisplaysCorrectly() {
        Essay mockEssay = new Essay("Mock Essay Title", "Mock Essay Text", "Mock Essay Type");
        Review mockReview = new Review(mockEssay.id, "Mock Review Text", "mock");

        ISelectedReviewView.Listener mockListener = new ISelectedReviewView.Listener(mockEssay);

        FragmentScenario<SelectedReviewFragment> scenario = FragmentScenario.launchInContainer(
                SelectedReviewFragment.class,
                SelectedReviewFragmentArgs.Builder(mockListener, mockEssay, mockReview).build().toBundle(),
                R.style.AppTheme,
                null
        );

        // Check if the review title and text are displayed correctly
        onView(withId(R.id.selectedReviewTitle)).check(matches(withText(mockReview.getTitle())));
        onView(withId(R.id.selectedReviewText)).check(matches(withText(mockReview.getText())));

        onView(withId(R.id.backToSelectedEssay)).perform(click());

    }

    private static class MockListener implements ISelectedReviewView.Listener {
        // Implement the methods of the Listener interface
    }
}


