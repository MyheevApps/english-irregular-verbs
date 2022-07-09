package ru.max.irvefree.ui.search;

public class Verbs {
    int id;
    String transfer;
    String firstFormElementary;
    String secondFormElementary;
    String thirdFormElementary;

    public Verbs(int id, String transfer, String firstFormElementary, String secondFormElementary, String thirdFormElementary) {
        this.id = id;
        this.transfer = transfer;
        this.firstFormElementary = firstFormElementary;
        this.secondFormElementary = secondFormElementary;
        this.thirdFormElementary = thirdFormElementary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getFirstFormElementary() {
        return firstFormElementary;
    }

    public void setFirstFormElementary(String firstFormElementary) {
        this.firstFormElementary = firstFormElementary;
    }

    public String getSecondFormElementary() {
        return secondFormElementary;
    }

    public void setSecondFormElementary(String secondFormElementary) {
        this.secondFormElementary = secondFormElementary;
    }

    public String getThirdFormElementary() {
        return thirdFormElementary;
    }

    public void setThirdFormElementary(String thirdFormElementary) {
        this.thirdFormElementary = thirdFormElementary;
    }
}
