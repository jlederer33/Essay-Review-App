package com.example.EssayReviewApp.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;


public class DashboardsTest extends TestCase {

        private Dashboards dashboard;

        @Before

        public void setUp() {
            dashboard = new Dashboards();
        }

        @Test
        public void testAddToEssayList() {
            String title = "Test Title";
            String text = "Test Text";
            String type = "Test Type";


            dashboard.addToUserEssayList(title, text, type);

            assertFalse("The essay list should not be empty", Dashboards.userEssayList.isEmpty());
            assertEquals("Essay list should have one essay", 1, Dashboards.userEssayList.size());

            Essay addedEssay = Dashboards.userEssayList.get(0);
            assertEquals("Essay list should match", title, addedEssay.getTitle());
            assertEquals("Essay list should match", text, addedEssay.getText());
            assertEquals("Essay list should match", type, addedEssay.getType());

        }
    }


