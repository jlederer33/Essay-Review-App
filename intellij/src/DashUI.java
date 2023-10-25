// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.im\\\\

import java.util.*;

public class DashUI extends DashLogic {

    public void viewDashboard(){//The toString() of these methods, in order to reflect the central function the dashboard will have in the app
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
    public void startUI() { //this method carries out the operations. It uses a switch case to carry out the logic. The int scanner should be replaced with a string scanner
        while (true) {
            int choice = 0;
            try {
                while (true) {
                    System.out.println("OPTIONS: ");
                    System.out.println("1.Add college, 2.Remove college, 3.Upload essay, 4.Delete essay, 5.View dashboard, 6.View essay, 7.Exit app");
                    Scanner scanner = new Scanner(System.in);

                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e) {
                    System.out.println("Invalid input, please use ints 1-7 for the commands");
                }
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the college to be added: ");
                    String collegeToAdd = scanner.nextLine();
                    System.out.println(addCollege(collegeToAdd));
                    boolean addMore = true;
                    while (addMore) {
                        System.out.println("Add another college? (Yes/No): ");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("No")) {
                            addMore = false;
                        } else if (response.equalsIgnoreCase("Yes")) {
                            System.out.print("Enter the name of the college to be added: ");
                            String collegeToAdd2 = scanner.nextLine();
                            System.out.println(addCollege(collegeToAdd2));
                        } else {
                            System.out.println("Invalid input, please try again");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter the name of the college to be removed: ");
                    String collegeToRemove = scanner.nextLine();
                    System.out.println(removeCollege(collegeToRemove));
                    boolean removeMore = true;
                    while (removeMore) {
                        System.out.println("Remove another college? (Yes/No): ");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("No")) {
                            removeMore = false;
                        } else if (response.equalsIgnoreCase("Yes")) {
                            System.out.print("Enter the name of the college to be removed: ");
                            String collegeToRemove2 = scanner.nextLine();
                            System.out.println(removeCollege(collegeToRemove2));
                        } else {
                            System.out.println("Invalid input, please try again");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter title of Essay: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter the text of the Essay");
                    String text = scanner.nextLine();
                    System.out.println("Enter essay type (Personal/Supplement)");
                    String essayType = scanner.nextLine();
                    System.out.println("Which college will it be added to?");
                    String collegeName = scanner.nextLine();
                    System.out.println(submitEssay(title, text, essayType, collegeName));
                    break;

                case 4:
                    System.out.println("Enter college: ");
                    String collegeName2 = scanner.nextLine(); //I know its not good code practice but the name works and I couldn't think of a better one
                    System.out.println("Enter essay type to delete");
                    String essayType2 = scanner.nextLine();
                    System.out.println(deleteEssay(collegeName2, essayType2));
                    break;

                case 5:
                    viewDashboard();
                    break;

                case 6:
                    System.out.println("Enter College: ");
                    String collegeName3 = scanner.nextLine();
                    System.out.println("Choose which essay to access (Personal/Supplement: ");
                    String essayType3 = scanner.nextLine();
                    System.out.println(viewEssay(collegeName3, essayType3));
                    break;

                case 7:
                    System.out.println("Exiting the app");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }
    }


    public static void main(String[] args) {
        DashUI dashUI = new DashUI();
        dashUI.startUI();
        }

}


