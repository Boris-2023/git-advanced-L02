package Controller;

import java.util.LinkedList;
import java.util.Queue;

import Model.Toy;

public class Controller {

    private iGetModel model;
    private iGetView view;

    Queue<String> toPresent = new LinkedList<>();

    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {

        boolean getNewIteration = true;
        while (getNewIteration) {

            int chosen = getGoodCommand(view.printMenu());

            switch (chosen) {
                case 1:
                    Toy prize = model.toysDraw();

                    if (prize != null) {
                        System.out.println(view.msgToyWon(prize.getName()));
                        if (prize.getQuantity() > 0) {
                            prize.setQuantity(prize.getQuantity() - 1);
                            toPresent.add(prize.getName());
                        } else {
                            System.out.println(view.msgOutOfStock());
                        }
                    } else {
                        System.out.println(view.msgEmptyToyList());
                    }
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(view.msgOnListToDraw() + model);
                    break;
                case 4:
                    String toyPresentName = toPresent.poll();
                    if (toyPresentName != null) {
                        model.savePresentedToy(toyPresentName);
                        System.out.println(view.msgOnPresentedToy(toyPresentName));
                    } else {
                        System.out.println(view.msgEmptyToyList());
                    }
                    break;
                case 5:
                    System.out.println(view.msgOnListToDraw() + model);
                    break;
                case 6:
                    System.out.println(view.msgOnListToPresent() + toPresent);
                    break;
                case 7:
                    System.out.println(view.msgOnLoadedToys());
                    System.out.println(model.getToysPresented());
                    break;
                case 8:
                    getNewIteration = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @apiNote getting from user a number of command until the input is within a
     *          range of Main menu
     * @param menuSize - size of Main menu (to verify the input)
     * @return user's choice - command number within Main Menu
     */
    private int getGoodCommand(int menuSize) {
        int chosen = 0;
        boolean goodCommand = false;
        while (!goodCommand) {
            String inStr = view.prompt(view.msgOnInvite());
            try {
                int input = Integer.parseInt(inStr);
                if (input > 0 && input <= menuSize) {
                    chosen = input;
                    goodCommand = true;
                } else {
                    System.out.println(view.msgOnBadCommand());
                }
            } catch (Exception e) {
                System.out.println(view.msgOnBadCommand());
            }
        }
        return chosen;
    }

}
