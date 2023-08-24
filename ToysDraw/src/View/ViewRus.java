package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.iGetView;

public class ViewRus implements iGetView {

    private List<String> menu = new ArrayList<>();
    String lineSep = "\n=============================================";

    public ViewRus() {
        menu.add("Провести розыгрыш игрушки");
        menu.add("Добавить новую игрушку в список для розыгрыша");
        menu.add("Измененить вес (частоту выпадения) игрушки");
        menu.add("Выдать игрушку (по очереди)");
        menu.add("Показать список игрушек для розыгрыша");
        menu.add("Показать очередь игрушек на выдачу");
        menu.add("Показать список выданных игрушек");
        menu.add("Выход");
    }

    /**
     * @apiNote printing main menu into console with consequent numbering of its
     *          items
     * @return the number of items in the menu - for future checking of user's input
     *         choice
     */
    @Override
    public int printMenu() {
        String res = "\nГЛАВНОЕ МЕНЮ:" + lineSep;
        int cnt = 0;
        if (menu != null) {
            for (String item : menu) {
                cnt++;
                res = res + "\n" + cnt + ". " + item;
            }
            res += lineSep;
            System.out.println(res);
        } else {
            System.out.println("Главное меню не загружено!");
        }

        return cnt;
    }

    /**
     * method to prompt from user by invitation
     * 
     * @param msg - message to print, invite user
     * @see ViewRus#prompt(String)
     */
    @Override
    public String prompt(String msg) {
        Scanner iScan = new Scanner(System.in);
        System.out.print(msg);
        return iScan.nextLine();
    }

    /**
     * method to return Russian invitation message
     * 
     * @see ViewRus#msgOnInvite()
     */
    @Override
    public String msgOnInvite() {
        return "Введите номер команды из меню для выполнения: ";
    }

    /**
     * method to return Russian message on bad command
     * 
     * @see ViewRus#msgOnBadCommand()
     */
    @Override
    public String msgOnBadCommand() {
        return "Такой команды нет!";
    }

    /**
     * method to return Russian message on empty list
     * 
     * @see ViewRus#msgEmptyToyList()
     */
    @Override
    public String msgEmptyToyList() {
        return "\nСписок игрушек пуст!";
    }

    
    /**
     * @apiNote method to return Russian message on the toy won
     * @param toyName - name of the toy
     * @see ViewRus#msgToyWon()
     */
    @Override
    public String msgToyWon(String toyName) {
        return "\nВыиграна игрушка: " + toyName + "!";
    }

    /**
     * method to return Russian message on out-of-stock toy
     * 
     * @see ViewRus#msgOutOfStock()
     */
    @Override
    public String msgOutOfStock() {
        return "Этой игрушки пока нет в наличии!";
    }

    /**
     * method to return Russian message on toys list to participate in the draw
     * 
     * @see ViewRus#msgOnListToDraw()
     */
    @Override
    public String msgOnListToDraw() {
        return "\nСписок игрушек для участия в розыгрыше: ";
    }

    /**
     * method to return Russian message on toys list to participate in the draw
     * 
     * @see ViewRus#msgOnListToDraw()
     */
    @Override
    public String msgOnListToPresent() {
        return "\nОчередь выигранных игрушек на выдачу:\n";
    }

     /**
     * @apiNote method to return Russian message on presenting the toy won
     * @param toyName - name of the toy
     * @see ViewRus#msgOnPresentedToy(String)
     */
    @Override
    public String msgOnPresentedToy(String toyName) {
        return "\nИгрушка '" + toyName + "' выдана и сохранена в файл!";
    }

    
    /**
     * @apiNote method to return Russian message on toys already presented (loaded from .txt file)
     * 
     * @see ViewRus#msgOnLoadedToys()
     */
    @Override
    public String msgOnLoadedToys() {
        return "\nСписок названий выданных игрушек (из файла):";
    }
    
}
