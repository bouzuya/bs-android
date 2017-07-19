package net.bouzuya.bs.model.repository;

import net.bouzuya.bs.model.entity.User;

import io.reactivex.Single;

public interface UserRepository {
    Single<User> loadOrCreate();
}
