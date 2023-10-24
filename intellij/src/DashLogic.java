import java.util.*;
public class DashLogic
{
    public Map<String, College> colleges = new HashMap<>();


    public String addCollege(String collegeName) {
        if(!colleges.containsKey(collegeName)){
            colleges.put(collegeName, new College(collegeName));
            return collegeName +" added successfully";
        }
        else{return collegeName + " already in dashboard";
        }
    }


    public String removeCollege (String collegeName) { //method to remove a college from the dashboard
       College college = colleges.remove(collegeName);
       if(college != null){
           return collegeName + " removed successfully";
       }else{
           return collegeName + " is not in Dashboard";
       }
       }



    public void submitEssay(String title, String content, String essayType, String collegeName){
        College college = colleges.get(collegeName);

        if (college == null){
            System.out.println("College not found, essay is not submitted");
        }
        Essay essay;
        if (essayType.equalsIgnoreCase("Personal")){
            essay = new PersonalEssay(title, content);
            college.uploadPersonalEssay((PersonalEssay) essay);
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            essay = new SupplementEssay(title, content);
            college.uploadSupplementEssay((SupplementEssay) essay);
        }else{
            System.out.println("Essay submitted successfully to " + collegeName);
        }
    }

    public void deleteEssay(String title){
    for(College college: colleges.values())
    {
        if (college.getEssay("Personal") != null && college.getEssay("Personal").getTitle().equalsIgnoreCase(title)
        ) {
            college.uploadPersonalEssay(null);
        }
        if (college.getEssay("Supplement") != null && college.getEssay("Supplement").getTitle().equalsIgnoreCase(title)) {
            college.uploadSupplementEssay(null);
    }
        }
    }

    public String viewEssay(String collegeName, String essayType){
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


