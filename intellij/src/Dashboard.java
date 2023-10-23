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



    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS: ");
            System.out.println("Add college, Remove college, View dashboard");


            String choice = scanner.nextLine();

            switch (choice) {
                case "Add college":
                    System.out.print("Enter the name of the college: ");
                    String collegeToAdd = scanner.nextLine();
                    addCollege(collegeToAdd);
                    break;

                case "Remove college":
                    System.out.print("Enter the name of the college: ");
                    String collegeToRemove = scanner.nextLine();
                    removeCollege(collegeToRemove);
                    break;

                case "View dashboard":
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
