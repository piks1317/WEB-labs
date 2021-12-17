package com.example.lab9_2.repositories;

import com.example.lab9_2.models.Latter;
import com.example.lab9_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LatterRepo extends JpaRepository<Latter, Integer> {
    List<Latter> findAllByRecipient(User user);
    List<Latter> findAllBySender(User user);
}
