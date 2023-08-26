package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Toy;

public class ViewRus implements iGetView {

    private List<String> menu = new ArrayList<>();
    String lineSep = "\n=============================================";

    public ViewRus() {
        menu.add("Провести розыгрыш игрушки");
        menu.add("Добавить новую игрушку в список для розыгрыша");
        menu.add("Изменить вес (частоту выпадения) игрушки");
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
        String res = "\nГЛАВНОЕ МЕНЮ:";
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
     * method to prompt Integer (in range) from user by invitation
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
        return "\nВыиграна игрушка '" + toyName + "'!";
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
     * @apiNote method to return Russian message on Empty gifted toys
     * @see ViewRus#msgOnEmptyGiftedList()
     */
    @Override
    public String msgOnEmptyGiftedList() {
        return "\nСписок выданных игрушек пуст!";
    }

    /**
     * @apiNote method to return Russian message on toys already presented (loaded
     *          from .txt file)
     * 
     * @see ViewRus#msgOnLoadedToys()
     */
    @Override
    public String msgOnLoadedToys() {
        return "\nСписок названий выданных игрушек (из файла):";
    }

    /**
     * @apiNote method to return Russian message on adding new toy to the list for
     *          draws
     * 
     * @see ViewRus#msgOnAddingNewToy()
     */
    @Override
    public String msgOnAddingNewToy() {
        return "\nДобавление новой игрушки для участия в розыгрыше:";
    }

    /**
     * @apiNote method to return Russian messages for adding new toy to the list for
     *          draws (request for ID, Name, Qty & probability wheight)
     * 
     * @see ViewRus#msgOnAddingRoutine(int)
     */
    @Override
    public String msgOnAddingRoutine(int field) {
        String res = "";
        switch (field) {
            case 0:
                res = "Укажите номер ID новой игрушки: ";
                break;
            case 1:
                res = "Укажите название новой игрушки: ";
                break;
            case 2:
                res = "Укажите количество новой игрушки: ";
                break;
            case 3:
                res = "Укажите вес (частоту выпадения в розыгрыше) новой игрушки: ";
                break;
            case 4:
                res = "\nТакой ID уже есть в списке!";
                break;
            default:
                res = "\nНЕИЗВЕСТНОЕ ПОЛЕ при добавлении новой игрушки!";
                return null;

        }
        return res;
    }

    /**
     * @apiNote method to return Russian message on the input that is not a number
     * 
     * @see ViewRus#msgOnNotANumber()
     */
    @Override
    public String msgOnNotANumber() {
        return "\nВведенное значение не является числом!";
    }

    /**
     * @apiNote method to return Russian message on the empty input
     * 
     * @see ViewRus#msgOnEmptyInput()
     */
    @Override
    public String msgOnEmptyInput() {
        return "\nЗначение не введено!";
    }

    /**
     * @apiNote method to return Russian message on the need positive number only
     * 
     * @see ViewRus#msgOnNeedPositiveNumber()
     */
    @Override
    public String msgOnNeedPositiveNumber() {
        return "\nВведенное значение должно быть больше нуля!";
    }

    /**
     * @apiNote method to return Russian message on the need a number whithin the
     *          range of input
     * 
     * @see ViewRus#msgOnNeedNumberInRange(int, int)
     */
    @Override
    public String msgOnNeedNumberInRange(int min, int max) {
        return "\nВведенное значение должно быть в диапазоне от " + min + " до " + max + "!";
    }

    /**
     * @apiNote method to return Russian message on new toy added successfully
     * 
     * @see ViewRus#msgOnNeedPositiveNumber()
     */
    @Override
    public String msgOnNewToyAdded(Toy toy) {
        return "\nДобавлена новая игрушка: " + toy;
    }

    /**
     * @apiNote method to return Russian messages on wight change
     * @param type - specifies the message: to choose the ID, to input new value, or
     *             successfully changed
     * @see ViewRus#msgOnWeightChange()
     */
    @Override
    public String msgOnWeightChange(Toy toy, int msgType) {
        switch (msgType) {
            case 0:
                return "\nУкажите ID игрушки для изменения веса (частоты выпадения): ";
            case 1:
                return "\nИгрушки с указанным ID в списке нет!";
            case 2:
                return "\nВведите новое значение веса для игрушки '" + toy.getName() + "': ";
            case 3:
                return "\nЗначение веса для игрушки '" + toy.getName() + "' успешно изменено!";
            default:
                return "";
        }
    }

    /**
     * @apiNote method to return Russian message on exit out of the program
     * 
     * @see ViewRus#msgOnExit()
     */
    @Override
    public String msgOnExit() {
        return "\nВыход из приложения...";
    }

}
