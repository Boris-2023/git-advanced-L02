package Controller;

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
}
