package Controller;

import java.util.List;

import Model.Toy;

public interface iGetModel {
    public void addToy(Toy toy);
    public Toy toysDraw();
    public List<String> getToysPresented();
     public void savePresentedToy(String toyName);
}
