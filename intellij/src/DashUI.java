// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.im\\\\

import java.util.*;

public class DashUI extends DashLogic {
    public void start() { //this method carries out the operations. It uses a switch case to carry out the logic. The int scanner should be replaced with a string scanner
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS: ");
            System.out.println("1.Add college, 2.Remove college, 3.Upload essay, 4.Delete essay, 5.View dashboard, 6.Exit app");

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
                    System.out.println("Enter title of Essay: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter the text of the Essay");
                    String text = scanner.nextLine();
                    System.out.println("Enter essay type (Personal/Supplement)");
                    String essayType = scanner.nextLine();
                    System.out.println("Which college will it be added to?");
                    String collegeName = scanner.nextLine();
                    submitEssay(title, text, essayType, collegeName);
                    break;

                case 4:
                    System.out.println("Enter the title of essay to be deleted");
                    String essayTitle = scanner.nextLine();
                    deleteEssay(essayTitle);

                case 5:
                    viewDashboard();
                    break;

                case 6:
                    System.out.println("Exiting the app");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again");
            }

        }
    }

    public void startUI() {
        DashUI dashUI = new DashUI();
        dashUI.start();
    }
}


