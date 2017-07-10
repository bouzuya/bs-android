package net.bouzuya.bs.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BsList {
    private final List<Bs> bsList;

    private BsList(List<Bs> bsList) {
        this.bsList = new ArrayList<>(bsList);
    }

    public static BsList empty() {
        return new BsList(new ArrayList<Bs>());
    }

    public static BsList from(Bs... bsArray) {
        return new BsList(Arrays.asList(bsArray));
    }

    public Bs get(int index) {
        return this.bsList.get(index);
    }

    public int size() {
        return this.bsList.size();
    }

    List<Bs> toList() {
        return new ArrayList<>(bsList);
    }
}
