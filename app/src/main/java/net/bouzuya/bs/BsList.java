package net.bouzuya.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BsList {
    private final List<Bs> bsList;

    private BsList(List<Bs> bsList) {
        this.bsList = new ArrayList<>(bsList);
    }

    static BsList from(Bs... bsArray) {
        return new BsList(Arrays.asList(bsArray));
    }

    List<Bs> toList() {
        return new ArrayList<>(bsList);
    }
}
