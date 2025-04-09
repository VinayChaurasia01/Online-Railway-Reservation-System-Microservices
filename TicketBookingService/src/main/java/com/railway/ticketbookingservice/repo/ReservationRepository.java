package com.railway.ticketbookingservice.repo;

import com.railway.ticketbookingservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long> {

    Reservation findByPassengerId(Long passengerId);

}
