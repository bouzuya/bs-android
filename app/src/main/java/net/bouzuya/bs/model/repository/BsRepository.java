package net.bouzuya.bs.model.repository;

import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.entity.User;

import io.reactivex.Single;

public interface BsRepository {
    Single<BsList> loadAllOfUser(User user);
}
