package Controller;

import Model.Toy;

public interface iGetView {

    public int printMenu();

    public String prompt(String msg);

    public String msgOnInvite();

    public String msgOnBadCommand();

    public String msgEmptyToyList();

    public String msgToyWon(String toyName);

    public String msgOutOfStock();

    public String msgOnListToDraw();

    public String msgOnListToPresent();

    public String msgOnPresentedToy(String toyName);

    public String msgOnLoadedToys();

    public String msgOnEmptyGiftedList();

    public String msgOnAddingNewToy();

    public String msgOnAddingRoutine(int field);

    public String msgOnNotANumber();

    public String msgOnEmptyInput();

    public String msgOnNeedPositiveNumber();

    public String msgOnNeedNumberInRange(int min, int max);

    public String msgOnNewToyAdded(Toy toy);

    public String msgOnWeightChange(Toy toy, int msgType);

    public String msgOnExit();
}
