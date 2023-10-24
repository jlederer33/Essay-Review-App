import java.util.*;
public class DashLogic
{
    private Map<String, College> colleges = new HashMap<>();


    public void addCollege(String collegeName) { //Include looping function either here or in scanner, keep doing this choice
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                if (!colleges.containsKey(collegeName)) {
                    College college = new College(collegeName);
                    colleges.put(collegeName, college);
                    System.out.println("College added");
                } else {
                    System.out.println("College is already added to dashboard");
                }
                System.out.println("Do you want to add another college?");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("No")) {
                    break;
                } else if (response.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter the name of the college: ");
                    collegeName = scanner.nextLine();
                } else {
                    System.out.println("Invalid input, please try again");
                    scanner.nextLine();
                }
            }
        }catch(Exception e){
            System.out.println("Invalid input, please try again");
            scanner.nextLine();
        }
    }


    public void removeCollege (String collegeName) { //Include looping function either here or in scanner, keep doing this choice
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                if (colleges.containsKey(collegeName)) {
                    colleges.remove(collegeName);
                    System.out.println("College removed successfully");
                } else {
                    System.out.println("College is not in dashboard or doesn't exist");
                }
                System.out.println("Do you want to remove another college?");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("No")) {
                    break;
                } else {
                    System.out.println("Enter the name of the college: ");
                    collegeName = scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please try again");
            scanner.nextLine();
        }
    }

    public void viewDashboard(){
        System.out.println("DASHBOARD: ");
        List<String> collegeNames = new ArrayList<>(colleges.keySet());
        if (collegeNames.size() == 0){
            System.out.println("No colleges in dashboard");
        }else{
            for (int i = 0; i < collegeNames.size(); i++){
                String collegeName = collegeNames.get(i);
                College college = colleges.get(collegeName);
                System.out.println(i+1 +". " + college.getName());
                Essay perEssay = college.getEssay("Personal");
                Essay supEssay = college.getEssay("Supplement");
                if(perEssay != null){
                    System.out.println("Personal Essay: " + perEssay.getTitle());
                }
                else{System.out.println("Personal Essay: No essay assigned");}

                if(supEssay != null){
                    System.out.println("Supplement Essay: " + supEssay.getTitle());
                }else{System.out.println("Supplement Essay: no essay assigned");}
                System.out.println("________________");
            }
        }
    }
    public void submitEssay(String title, String content, String essayType){
        Essay essay;
        if (essayType.equalsIgnoreCase("Personal")){
            essay = new PersonalEssay(title, content);
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            essay = new SupplementEssay(title, content);

        }else{
            System.out.println("Essay submitted successfully");
        }
    }

    public void deleteEssay(String title){
    for(College college: colleges.values())
    {
        if (college.getEssay("Personal") != null && college.getEssay("Personal").getTitle().equalsIgnoreCase(title)
        ) {
            college.uploadPersonalEssay(null);
            System.out.println("Personal essay " + title + " has been successfully deleted");
        }
        if (college.getEssay("Supplement") != null && college.getEssay("Supplement").getTitle().equalsIgnoreCase(title)) {
            college.uploadSupplementEssay(null);
            System.out.println("Supplement essay " + title + " has been successfully deleted");
    }
        }
    }

    public void start() { //this method carries out the operations. It uses a switch case to carry out the logic. The int scanner should be replaced with a string scanner
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS: ");
            System.out.println("1.Add college, 2.Remove college, 3.View dashboard");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the college: ");
                    String collegeToAdd = scanner.nextLine();
                    addCollege(collegeToAdd);
                    break;

                case 2:
                    System.out.print("Enter the name of the college: ");
                    String collegeToRemove = scanner.nextLine();
                    removeCollege(collegeToRemove);
                    break;

                case 3:
                    viewDashboard();
                    break;

                case 4:
                    System.out.println("Exiting the app");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }
    }
}


