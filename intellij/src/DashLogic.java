import java.util.*;
public class DashLogic
{ /*
    This is the controller class for the app. The
  */
    public Map<String, College> colleges = new HashMap<>();


    public String addCollege(String collegeName) {//adds a college to the dashboard based on its name(case matches)
        if(!colleges.containsKey(collegeName)){
            colleges.put(collegeName, new College(collegeName));
            return collegeName +" added successfully";
        }
        else{return collegeName + " already in dashboard";
        }
    }


    public String removeCollege (String collegeName) { //method to remove a college from the dashboard(case matches)
       College college = colleges.remove(collegeName);
       if(college != null){
           return collegeName + " removed successfully";
       }else{
           return collegeName + " is not in Dashboard";
       }
       }



    public String submitEssay(String title, String content, String essayType, String collegeName){//method to submit an essay, and is stored in respective college
        College college = colleges.get(collegeName);
        Essay essay;
        if(!colleges.containsKey(collegeName)){
            return collegeName +  " is not in dashboard, unable to upload Essay";
        }
        if (essayType.equalsIgnoreCase("Personal")){
            essay = new PersonalEssay(title, content);
            college.uploadPersonalEssay((PersonalEssay) essay);
            return "Essay submitted successfully to " + collegeName;
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            essay = new SupplementEssay(title, content);
            college.uploadSupplementEssay((SupplementEssay) essay);
            return "Essay submitted successfully to " + collegeName;
        }else{
            return "Essay type wasn't specified, unable to upload to college";
        }
    }

    public String deleteEssay(String collegeName, String essayType) {//deletes an essay based on college and the type
        College college = colleges.get(collegeName);
        if(!colleges.containsKey(collegeName)){
            return collegeName +  " is not in dashboard, unable to delete Essay";}
        if (college.getEssay(essayType) != null) {
            if (essayType.equalsIgnoreCase("Personal")) {
                college.uploadPersonalEssay(null);
            }
            if (college.getEssay("Supplement") != null) {
                college.uploadSupplementEssay(null);
            }
            return collegeName + essayType + " successfully deleted!";
        }
        else{
            return "Essay is not in college";
        }
    }



    public String viewEssay(String collegeName, String essayType){ // similar logic to deleteEssay, except it will return the text
        College college = colleges.get(collegeName);

        if(college == null){
            return "College not found. Unable to view the essay.";
        }
        Essay essay = college.getEssay(essayType);
        if(essay == null){
            return "No " + essayType + " found in " + collegeName;
        }else{
            return "Text: " + "\n" + essay.getText();
        }
    }
}


