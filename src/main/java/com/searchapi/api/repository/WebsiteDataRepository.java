package com.searchapi.api.repository;

import com.searchapi.api.model.Website_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteDataRepository extends JpaRepository<Website_Data,Integer> {

    List<Website_Data> findByCategory_id(int Category_id);

}
