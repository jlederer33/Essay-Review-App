# INTELLIJ:
**Functionality:**
-
The functionality implemented in this was adding and removing colleges to a dashboard, and uploading and deleting essays for each college.
The current limitations are that you can only add one personal essay and one supplement essay to each college. 
In the future, we will try to make it so that students can add as many personal or supplement essays to the colleges. 
Moreover, the current iteration covers only the applicant dashboard. While the navigation will be the same, reviewer dashboard
will look a little different.


**Instructions:**
- 
Currently, there are 7 commands. They are:
1. Add College
2. Remove College
3. Upload Essay
4. Delete Essay 
5. View Dashboard
6. View essay 
7. Exit app

The main method is in DashUI. In order to execute each command, type in the corresponding integer. From there, the user will be prompted to enter the specific information depending on the command. 
Command 7, Exit app, will quit the program. Otherwise, the program will continue to loop, even in the event of an improper input. 


# ANDROID STUDIO:

**Functionality:**
- 
Due to poor time management, the only functionality we were able to was the Main Menu and the Essays dashboard screen. Within Essays, we have only added the add essays functionality. Within the begininng of the next iteration, we plan to have remove essays done. We also plan to add the review essays functionality added. If time permits (this will be expanded in the iteration plan), we will add college and checklist
functionality. Moreover, we plan to the submit functionality into a submit essay screen fragment, in order to make 
more room for the recycler view. 

**Instructions**
- 
When the app opens up, the user will be presented with the main menu. Currently, the only option is the Essays screen. When the Essays button is clicked, the screen will switch to the Essays dashboard screen. From here, the User will be presented with two text editables called title and text, a spinner containing the types of essay (Personal and Supplement)
a button called submit, and a button called back. If both or either field is blank when submit essay is clicked, the user will be presented with an error message. 
If both fields are filled and submit is clicked, the essay will be added to the view. When the back button is clicked, the screen will switch back to the main menu

