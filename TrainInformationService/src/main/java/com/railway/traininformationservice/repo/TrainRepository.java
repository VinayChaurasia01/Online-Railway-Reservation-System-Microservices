package com.railway.traininformationservice.repo;

import com.railway.traininformationservice.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, String> {
    List<Train> findByNameContaining(String name); // Search by train name
    List<Train> findBySourceAndDestination(String source, String destination); // Search by routes
    Train findByPnr(String pnr);
}
