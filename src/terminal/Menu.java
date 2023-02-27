package terminal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String[][] selectAction = {
            { "", "Выберите действие:" },
            { "1.", "Добавить животное" },
            { "2.", "Удалить животное" },
    };

    private String[][] animalKinds = {
            { "", "Выберите вид животного:" },
            { "1.", "Львы" }
    };
    private String[][] enterDataAboutLion = {
            { "", "Введите данные животного:" },
            { "1.", "Имя:" },
            { "2.", "Дата рождения:" },
            { "3.", "Количество конечностей:" },
            { "4.", "Вес:" },
            { "5.", "Длина гривы:" }
    };

    Scanner iScanner = new Scanner(System.in);

    private String printMenu(String[][] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i][0]);
            System.out.print(" ");
            System.out.println(menu[i][1]);
        }
        String result = iScanner.nextLine();
        return result;
    }

    private ArrayList<String> inputData(String[][] menu) {
        ArrayList<String> outString = new ArrayList<>();

        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i][0]);
            System.out.print(" ");
            System.out.print(menu[i][1]);
            System.out.print(" ");

            if (i != 0) {
                outString.add(iScanner.nextLine());
            } else {
                System.out.println();
            }
        }
        return outString;
    }

    private void incorrectInput() {
        System.out.println("Неверный выбор пункта меню");
        view();
    }

    public String[] view() {

        ArrayList<String> result = new ArrayList<>();
        switch (printMenu(selectAction)) {
            case "1":
                result.add("add");
                switch (printMenu(animalKinds)) {
                    case "1":
                        result.add("lion");
                        result.addAll(inputData(enterDataAboutLion));
                        break;
                    default:

                        break;
                }
                break;

            case "2":
                result.add("delete");
                switch (printMenu(animalKinds)) {
                    case "1":
                        result.add("lion");
                        // System.err.println("You have deleted the animal");
                        break;
                    default:

                        break;
                }
                break;
            default:

                break;
        }

        return result.toArray(new String[result.size()]);
    }

}
