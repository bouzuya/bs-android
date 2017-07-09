package net.bouzuya.bs.model.repository;

import net.bouzuya.bs.model.entity.BsList;

import io.reactivex.Single;

public interface BsRepository {
    Single<BsList> loadAll();
}
