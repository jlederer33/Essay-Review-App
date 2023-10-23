// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.im\\\\
import java.util.*;
public class DashUI{
    public void startUI(){
        DashController dashController = new DashController();
        dashController.start();
    }

    public static void main(String[] args) {
        DashUI dashUI = new DashUI();
        dashUI.startUI();
    }
}