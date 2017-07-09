package net.bouzuya.bs.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BsList {
    private final List<Bs> bsList;

    private BsList(List<Bs> bsList) {
        this.bsList = new ArrayList<>(bsList);
    }

    public static BsList from(Bs... bsArray) {
        return new BsList(Arrays.asList(bsArray));
    }

    List<Bs> toList() {
        return new ArrayList<>(bsList);
    }
}
