package com.example.EssayReviewApp;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DashboardsTest {


            private Dashboards dashboards;
            private Essay essay= new Essay("title", "text", "type");;
           @Before
        public void SetUp() {
               dashboards = new Dashboards();
               Dashboards.userEssayList.clear(); // Clear the list before each test

                   dashboards.userEssayList = new ArrayList<>();

               }


            @Test
           public void testAddToEssayList() {
               SetUp();
                // Check that the essay list is initially empty
                assertTrue("List should be empty before adding an essay", dashboards.userEssayList.isEmpty());

                // Add the essay to the list
                dashboards.addToUserEssayList(essay);

                // Check that the essay is added
                assertFalse("List should not be empty after adding an essay", dashboards.userEssayList.isEmpty());
                assertEquals("There should be exactly one essay in the list", 1, dashboards.userEssayList.size());
                assertTrue("The list should contain the added essay", dashboards.userEssayList.contains(essay));
            }




  /** private Dashboards dashboard = new Dashboards();

    @Before
    public void setUp() {

        // Resetting the static lists to a known state before each test
        Dashboards.userEssayList.clear();
        Dashboards.allEssaysList.clear();

        // Adding some dummy essays for testing
        dashboard.addToUserEssayList("Essay1", "Text1", "Type1");
        dashboard.addToUserEssayList("Essay2", "Text2", "Type2");
        dashboard.addToUserEssayList("Essay3", "Text3", "Type3");
    }

    @Test
    public void testRemoveFromEssayList_NormalCase() {
        setUp();
        // Remove the second essay
        dashboard.removeFromEssayList(1);
        // Assertions to check if the essay is removed
        assertEquals("List size should be reduced by 1", 2, Dashboards.userEssayList.size());
        assertEquals("First essay should remain", "Essay1", Dashboards.userEssayList.get(0).getTitle());
        assertEquals("Third essay should shift up", "Essay3", Dashboards.userEssayList.get(1).getTitle());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEssayList_InvalidPosition() {
        // Remove an essay from an invalid position
        dashboard.removeFromEssayList(5);
    }

    @Test
    public void testRemoveFromEssayList_EmptyList() {
        // Clear the list
        Dashboards.userEssayList.clear();

        // Attempt to remove an item from an empty list
        try {
            dashboard.removeFromEssayList(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // This is expected
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEssayList_NegativeIndex() {
        dashboard.removeFromEssayList(-1);
    }

}
 */

private Dashboards dashboard = new Dashboards();

    private Essay essay1;
    private Essay essay2;

    @Before
    public void setUp() {
        dashboard = new Dashboards();
        essay1 = new Essay("essay1", "text1", "type1"); // Assuming the Essay class has a constructor
        essay2 = new Essay("essay2", "text2", "type2"); // Create another Essay for testing

        // Initialize userEssayList with some essays
        dashboard.userEssayList = new ArrayList<>();
        dashboard.userEssayList.add(essay1);
        dashboard.userEssayList.add(essay2);
    }

    @Test
    public void testRemoveFromEssayList_NormalCase() {
        setUp();
        dashboard.removeFromEssayList(essay1);

        assertFalse("List should not contain the removed essay",
                dashboard.userEssayList.contains(essay1));
        assertTrue("List should contain essays not removed",
                dashboard.userEssayList.contains(essay2));
    }

    @Test
    public void testRemoveFromEssayList_NonExistentEssay() {
        Essay nonExistentEssay = new Essay("non existent title", "non existent text", "non existent type");
        dashboard.removeFromEssayList(nonExistentEssay);

        assertFalse("List should not contain the non-existent essay",
                dashboard.userEssayList.contains(nonExistentEssay));
        assertEquals("List size should remain unchanged", 1,
                dashboard.userEssayList.size());
    }
    private Dashboards dash;

    @Before
    public void SEtUp() {
        dash = new Dashboards();
        essay = new Essay("title", "text", "type");

        // Initialize the lists
        dash.userEssayList = new ArrayList<>();
        dash.allEssaysList = new ArrayList<>();

        // Add the essay to userEssayList for testing
        dash.userEssayList.add(essay);
    }

    @Test
    public void testSubmitToAllEssays() {
        SEtUp();
        dash.submitToAllEssays(essay);

        assertTrue("Essay should be added to allEssaysList",
                dash.allEssaysList.contains(essay));
        assertFalse("Essay should be removed from userEssayList",
                dash.userEssayList.contains(essay));
        assertTrue("Essay's inAllEssays flag should be set to true",
                essay.inAllEssays);
    }

    @Test
    public void testSubmitNonExistentEssay() {
        SEtUp();
        Essay nonExistentEssay = new Essay("", "", "");

        dash.submitToAllEssays(nonExistentEssay);

        assertTrue("Non-existent essay should not be added to allEssaysList",
                dash.allEssaysList.contains(nonExistentEssay));
    }

}





