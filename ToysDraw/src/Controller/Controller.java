package Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Model.Toy;
import View.ViewRus;

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
                    System.out.println(view.msgOnAddingNewToy().toUpperCase());

                    Toy newToy = addNewToy();

                    if (newToy.getId() != 0) {
                        model.addToy(newToy);
                        System.out.println(view.msgOnNewToyAdded(newToy));
                    }

                    break;
                case 3:
                    System.out.println(view.msgOnListToDraw() + model);

                    boolean newTry = true;
                    Toy toyToChange = new Toy();

                    // getting input ID from user and corresponding toy from basic list
                    while (newTry) {
                        String str = view.prompt(view.msgOnWeightChange(toyToChange, 0));
                        if (isInteger(str)) {
                            int id = Integer.parseInt(str);
                            toyToChange = model.findToyById(id);
                            if (toyToChange != null) {
                                newTry = false;
                            } else {
                                System.out.println(view.msgOnWeightChange(toyToChange, 1));
                                break;
                            }
                        } else {
                            System.out.println(view.msgOnNotANumber());
                        }
                    }
                    if (toyToChange.getId() == 0)
                        break;

                    // getting input new value from user and adjust corresponding toy in basic list
                    newTry = true;
                    while (newTry) {
                        String str = view.prompt(view.msgOnWeightChange(toyToChange, 2));
                        if (isInteger(str)) {
                            int wgt = Integer.parseInt(str);
                            if (wgt > 1 && wgt < 100) {
                                toyToChange.setWeight(wgt);
                                System.out.println(view.msgOnWeightChange(toyToChange, 3).toUpperCase());
                                newTry = false;
                            } else {
                                System.out.println(view.msgOnNeedNumberInRange(1, 100));
                            }
                        } else {
                            System.out.println(view.msgOnNotANumber());
                        }
                    }
                    break;
                case 4:
                    String toyPresentName = toPresent.poll();
                    if (toyPresentName != null) {
                        model.savePresentedToy(toyPresentName);
                        System.out.println(view.msgOnPresentedToy(toyPresentName).toUpperCase());
                    } else {
                        System.out.println(view.msgEmptyToyList().toUpperCase());
                    }
                    break;
                case 5:
                    System.out.println(view.msgOnListToDraw().toUpperCase() + model);
                    break;
                case 6:
                    if (toPresent.size() != 0) {
                        System.out.println(view.msgOnListToPresent().toUpperCase() + toPresent);
                    } else {
                        System.out.println(view.msgEmptyToyList().toUpperCase());
                    }
                    break;
                case 7:

                    List<String> toysGifted = model.getToysPresented();
                    if (toysGifted != null) {
                        System.out.println(view.msgOnLoadedToys().toUpperCase());
                        System.out.println(toysGifted);
                    } else {
                        System.out.println(view.msgOnEmptyGiftedList().toUpperCase());
                    }
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
            if (isInteger(inStr)) {
                int input = Integer.parseInt(inStr);
                if (input > 0 && input <= menuSize) {
                    chosen = input;
                    goodCommand = true;
                } else {
                    System.out.println(view.msgOnBadCommand());
                }
            } else {
                System.out.println(view.msgOnBadCommand());
            }
        }
        return chosen;
    }

    /**
     * @apiNote method to check if the input string can be parsed into integer
     * @param str - string to check
     * @return boolean if the string can be parsed into integer
     */
    private boolean isInteger(String str) {
        boolean isInt;
        try {
            Integer.parseInt(str);
            isInt = true;
        } catch (Exception e) {
            isInt = false;
        }
        return isInt;
    }

    /**
     * @apiNote initializing new toy, requests fields values and composes a new toy
     * @return new toy with all fields filled in or empty toy (if input ID already
     *         in the toys list)
     * @see Controller#addNewToy()
     */
    private Toy addNewToy() {

        Toy newToy = new Toy();

        // Id of the new toy
        boolean newTry = true;
        while (newTry) {
            String str = view.prompt(view.msgOnAddingRoutine(0));
            if (isInteger(str)) {
                int id = Integer.parseInt(str);
                if (id < 1) {
                    System.out.println(view.msgOnNeedPositiveNumber());
                } else {
                    List<Integer> ids = model.getAllToysID();
                    if (ids.indexOf(id) == -1) {
                        newToy.setId(id);
                        newTry = false;
                    } else {
                        System.out.println(view.msgOnAddingRoutine(4).toUpperCase());
                        break;
                    }
                }
            } else {
                System.out.println(view.msgOnNotANumber());
            }
        }
        if (newToy.getId() == 0)
            return newToy;

        // Name of the toy
        newTry = true;
        while (newTry) {
            String str = view.prompt(view.msgOnAddingRoutine(1));
            if (str != "") {
                newToy.setName(str);
                newTry = false;
            } else {
                System.out.println(view.msgOnEmptyInput());
            }
        }

        // Quantity of the new toy
        newTry = true;
        while (newTry) {
            String str = view.prompt(view.msgOnAddingRoutine(2));
            if (isInteger(str)) {
                int input = Integer.parseInt(str);
                if (input < 1) {
                    System.out.println(view.msgOnNeedPositiveNumber());
                } else {
                    newToy.setQuantity(input);
                    newTry = false;
                }
            } else {
                System.out.println(view.msgOnNotANumber());
            }
        }

        // Weight of the new toy
        newTry = true;
        while (newTry) {
            String str = view.prompt(view.msgOnAddingRoutine(3));
            if (isInteger(str)) {
                int input = Integer.parseInt(str);
                if (input < 1 || input > 100) {
                    System.out.println(view.msgOnNeedNumberInRange(1, 100));
                } else {
                    newToy.setWeight(input);
                    newTry = false;
                }
            } else {
                System.out.println(view.msgOnNotANumber());
            }
        }

        return newToy;
    }

    /**
     * @apiNote method to prompt from user by invitation expecting Integer in range
     * 
     * @param msg - message to print, invite user
     * @param min - minimum of range the input value must fall to
     * @param max - maximum of range the input value must fall to
     * @see Controller#promptIntegerInRange(String, int, int)
     */
    public Integer promptIntegerInRange(String msg, int min, int max) {
        boolean newTry = true;
        Integer res = null;

        String badMessage;
        if (min > Integer.MIN_VALUE && max < Integer.MAX_VALUE) {
            badMessage = view.msgOnNeedNumberInRange(min, max);
        } else {
            badMessage = view.msgOnNeedPositiveNumber();
        }

        // getting input ID from user and corresponding toy from basic list
        while (newTry) {
            String str = view.prompt(msg);
            if (isInteger(str)) {
                res = Integer.parseInt(str);
                if (res >= min && res <= max) {
                    return res;
                } else {
                    System.out.println(badMessage);
                }
            } else {
                System.out.println(view.msgOnNotANumber());
            }
        }

        return res;
    }

}
