package View;

import java.util.Scanner;

public class GeneralMenu {
    public void show() {
        System.out.println("\n\n");
        System.out.println("[ 1 ] show all tables");
        System.out.println("[ 2 ] show one table ");
        System.out.println("[ 3 ] add new row");
        System.out.println("[ 4 ] update row");
        System.out.println("[ 5 ] delete row");
        System.out.println("[ 0 ] << back");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number");

        String number = myObj.nextLine();

        if (number.equals("1")){
            AllTablesView allTables = new AllTablesView();
            allTables.show();
        }
        if (number.equals("2")){
            OneTableView oneTable = new OneTableView();
            oneTable.show();
        }
        if (number.equals("3")){
            AddView addView = new AddView();
            addView.show();
        }
        if (number.equals("4")){
            UpdateView updateView = new UpdateView();
            updateView.show();
        }
        if (number.equals("5")){
            DeleteView deleteView = new DeleteView();
            deleteView.show();
        }
        if (number.equals("0")){
            MainView mainView = new MainView();
            mainView.show();
        }
    }
}
