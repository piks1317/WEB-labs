package com.example.site.repositories;

import com.example.site.models.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer> {
}
