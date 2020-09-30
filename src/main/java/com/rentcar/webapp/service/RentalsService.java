package com.rentcar.webapp.service;

import com.rentcar.webapp.Exception.InvalidJSONException;
import com.rentcar.webapp.Exception.MasterException;
import com.rentcar.webapp.Exception.NotExistVehicleException;
import com.rentcar.webapp.Exception.ServiceException;
import com.rentcar.webapp.entity.Rentals;
import com.rentcar.webapp.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class RentalsService {

    private final RentalsRepository rentalsRepository;

    public RentalsService(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }


    @Transactional
    public Rentals create(Rentals rental)
    {
        return rentalsRepository.save(rental);
    }
//---------------------------------------------------------------------------------------------------------------
    @Transactional
    public Rentals update(Rentals rental)
    {
        Optional<Rentals> re = rentalsRepository.findById(rental.getRentalId());
        if (!re.isPresent())
            throw new NotExistVehicleException("Il noleggio non è presente nel database");
        if (!Objects.isNull(rental.getUserId())) re.get().setUserId(rental.getUserId());
        if (!Objects.isNull(rental.getVehicleId())) re.get().setVehicleId(rental.getVehicleId());
        if (!Objects.isNull(rental.getEndDate())) re.get().setEndDate(rental.getEndDate());
        if (!Objects.isNull(rental.getStartDate())) re.get().setStartDate(rental.getStartDate());
        rentalsRepository.save(re.get());
        return re.get();
    }

    @Transactional
    public void delete(Rentals rental) {
        try {

            rentalsRepository.delete(rental);

        } catch (IllegalStateException | PersistenceException e) {
            throw new ServiceException("Al momento non è possibile soddisfare la richiesta");
        } catch (MasterException e) {
            throw e;
        }
    }
//----------------------------------------------------------------------------------------------------------------
    public List<Rentals> all() {
        return rentalsRepository.findAll();
    }

    public Rentals find(Long id) {
        return rentalsRepository.getOne(id);
    }

}
