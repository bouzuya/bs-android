package net.bouzuya.bs.model.view;

import net.bouzuya.bs.model.entity.BsList;

public interface BsView {
    void showBsList(BsList bsList);

    void showLoadException(Throwable throwable);
}
