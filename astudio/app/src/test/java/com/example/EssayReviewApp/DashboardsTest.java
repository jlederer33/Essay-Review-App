package com.example.EssayReviewApp;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DashboardsTest {

    //public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);
      //  assertEquals(6, 4 + 2);


            private Dashboards dashboards;

           @Before
        public void SetUp() {
               dashboards = new Dashboards();
               Dashboards.essayList.clear(); // Clear the list before each test
            }

            @Test
           public void testAddToEssayList() {
                String title = "Test Essay";
                String text = "This is a test essay.";
                String type = "Test Type";

        dashboards.addToUserEssayList(title, text, type);

        assertFalse("Essay list should not be empty after adding an essay", Dashboards.essayList.isEmpty());
        assertEquals("Essay list size should be 1 after adding one essay", 1, Dashboards.essayList.size());

        Essay addedEssay = Dashboards.essayList.get(0);
        assertEquals("Added essay should have the correct title", title, addedEssay.getTitle());
        assertEquals("Added essay should have the correct text", text, addedEssay.getText());
        assertEquals("Added essay should have the correct type", type, addedEssay.getType());
            }

            // Test adding multiple essays and check order

           @Test
            public void testAddMultipleEssays() {
               dashboards.addToUserEssayList("Essay 1", "Text 1", "Type 1");
               dashboards.addToUserEssayList("Essay 2", "Text 2", "Type 2");

               assertEquals("Essay list size should be 2 after adding two essays", 2, Dashboards.essayList.size());

               assertEquals("First added essay should be in the first position", "Essay 1", Dashboards.essayList.get(0).getTitle());
               assertEquals("Second added essay should be in the second position", "Essay 2", Dashboards.essayList.get(1).getTitle());


           }

  //  @Test
  //  public void remove_isCorrect() {
     //   assertEquals(2, 3 - 1);
   // }


   private Dashboards dashboard = new Dashboards();

    @Before
    public void setUp() {

        // Resetting the static lists to a known state before each test
        Dashboards.essayList.clear();
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
        assertEquals("List size should be reduced by 1", 2, Dashboards.essayList.size());
        assertEquals("First essay should remain", "Essay1", Dashboards.essayList.get(0).getTitle());
        assertEquals("Third essay should shift up", "Essay3", Dashboards.essayList.get(1).getTitle());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEssayList_InvalidPosition() {
        // Remove an essay from an invalid position
        dashboard.removeFromEssayList(5);
    }

    @Test
    public void testRemoveFromEssayList_EmptyList() {
        // Clear the list
        Dashboards.essayList.clear();

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






