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


            dashboard.addToEssayList(title, text, type);

            assertFalse("The essay list should not be empty", Dashboards.essayList.isEmpty());
            assertEquals("Essay list should have one essay", 1, Dashboards.essayList.size());

            Essay addedEssay = Dashboards.essayList.get(0);
            assertEquals("Essay list should match", title, addedEssay.getTitle());
            assertEquals("Essay list should match", text, addedEssay.getText());
            assertEquals("Essay list should match", type, addedEssay.getType());

        }
    }


