// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.im\\\\
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Dashboard {
    private Map<String, Essay> essays = new HashMap<>();
    private Map<String, College> colleges = new HashMap<>();
    private String username;


    public void addCollege(String collegeName){ //Include looping function either here or in scanner, keep doing this choice
        if(!colleges.containsKey(collegeName)){
            College college = new College(collegeName);
            colleges.put(collegeName, college);
            System.out.println("College added");
        }else{
            System.out.println("College is already added to dashboard");
        }
    }

    public void removeCollege(String collegeName){ //Include looping function either here or in scanner, keep doing this choice
        if(colleges.containsKey(collegeName)){
            colleges.remove(collegeName);
            System.out.println("College removed successfully");
        }else{
            System.out.println("College is not in dashboard or doesn't exist");
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
            SupEssay essay = new SupEssay(title, text);
        }
        else {
            System.out.println("Invalid Essay type. Please use 'Personal' or 'Supplement'.");
        }
        System.out.println("Essay uploaded successfully");
    }



    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS: ");
            System.out.println("1. Add college" + "\n" + "2. Remove college" + "\n" + "3. View dashboard");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                        System.out.print("Enter the name of the college: ");
                        String collegeToAdd = scanner.nextLine();
                        addCollege(collegeToAdd);
                        System.out.println("Add more colleges?");

                case 2:
                    System.out.print("Enter the name of the college: ");
                    String collegeToRemove = scanner.nextLine();
                    removeCollege(collegeToRemove);


                case 3:
                    viewDashboard();
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }
    }



    public static void main(String[] args) {
    Dashboard dashboard = new Dashboard();
    dashboard.start();
        }
    }
