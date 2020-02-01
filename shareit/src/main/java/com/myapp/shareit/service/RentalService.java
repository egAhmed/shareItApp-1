package com.myapp.shareit.service;

import com.myapp.shareit.domain.Rental;
import com.myapp.shareit.exceptions.RentalNotFoundException;
import com.myapp.shareit.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Optional<Rental> getRenta(Long id) {
        return rentalRepository.findById(id);

    }

    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }

    public void createRental(Rental rental) {
        rentalRepository.save(rental);
    }

    public void updateRental(Rental rental) {
        rentalRepository.findById(rental.getId()).orElseThrow(() -> new RentalNotFoundException("Rental notfound"));
        rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RentalNotFoundException("Rental notfound"));
        rentalRepository.delete(rental);
    }

}
