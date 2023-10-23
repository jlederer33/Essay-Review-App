import java.util.*;
public class DashController
{
    private Map<String, Essay> essays = new HashMap<>();
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
        Object[] collegeKeys = colleges.keySet().toArray();
        if (collegeKeys.length == 0){
            System.out.println("No colleges in dashboard");
        }else{
            for (int i = 0; i < collegeKeys.length; i++){
                String collegeName = (String) collegeKeys[i];
                System.out.println(i+1 +". " + collegeName);
                System.out.println("________________");
            }
        }
    }

    public void uploadEssay(String title, String text, String essayType){
        if (essayType.equalsIgnoreCase("Personal")){
            PersonalEssay essay = new PersonalEssay(title, text);
            essays.put(title, essay);
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            SupplementEssay essay = new SupplementEssay(title, text);
        }
        else {
            System.out.println("Invalid Essay type. Please use 'Personal' or 'Supplement'.");
        }
        System.out.println("Essay uploaded successfully");
    }
    public void start() { //this method carries out the operations. It uses a switch case to carry out the logic. The int scanner should be replaced with a string scanner
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS: ");
            System.out.println("Add college, Remove college, View dashboard");


            String choice = scanner.next().toLowerCase();
            scanner.nextLine();

            switch (choice) {
                case "add college":
                    System.out.print("Enter the name of the college: ");
                    String collegeToAdd = scanner.nextLine();
                    addCollege(collegeToAdd);
                    break;

                case "remove college":
                    System.out.print("Enter the name of the college: ");
                    String collegeToRemove = scanner.nextLine();
                    removeCollege(collegeToRemove);
                    break;

                case "view dashboard":
                    viewDashboard();
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }
    }
}
