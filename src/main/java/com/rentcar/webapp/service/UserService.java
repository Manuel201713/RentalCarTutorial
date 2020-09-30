package com.rentcar.webapp.service;

import com.rentcar.webapp.Exception.InvalidJSONException;
import com.rentcar.webapp.Exception.MasterException;
import com.rentcar.webapp.Exception.NoContentException;
import com.rentcar.webapp.Exception.ServiceException;
import com.rentcar.webapp.entity.User;
import com.rentcar.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(User user) {
        try {
            if (user.getUserId() != null || user.getLastName() == null || user.getEmail() == null ||
                    user.getFirstName()==null || user.getFiscalCode()==null || user.getBirthDate()==null)
                throw new InvalidJSONException("Errore nei dati inviati");

            return userRepository.saveAndFlush(user);

        } catch (EntityExistsException eee) {
            throw new ServiceException("User già presente nel database");
        } catch (IllegalStateException | PersistenceException e) {
            throw new ServiceException("Al momento non è possibile soddisfare la richiesta");
        } catch (MasterException e) {
            throw e;
        }
    }

    @Transactional
    public User update(User userData) {

            Optional<User> user = userRepository.findById(userData.getUserId());

            if(!user.isPresent())
                throw new NoContentException("Non è stato trovato un utente con l'id selezionato o i dati potrebbero essere corrotti");

            if (userData.getFirstName() != null) user.get().setFirstName(userData.getFirstName());
            if (userData.getLastName() != null) user.get().setLastName(userData.getLastName());
            if (userData.getEmail() != null) user.get().setEmail(userData.getEmail());
            if (userData.getPassword() != null) user.get().setPassword(userData.getPassword());
            if (userData.getPhone() != null) user.get().setPhone(userData.getPhone());
            if (userData.getFiscalCode() != null) user.get().setFiscalCode(userData.getFiscalCode());
            if (userData.getBirthDate() != null) user.get().setBirthDate(userData.getBirthDate());
            if(userData.getAdmin() != null) user.get().setAdmin(userData.getAdmin());
            return userRepository.saveAndFlush(user.get());
    }

    @Transactional
    public void delete(User user) {
        try {
            if (user.getUserId() == null || user.getLastName() == null || user.getEmail() == null ||
                    user.getFirstName()==null || user.getFiscalCode()==null || user.getBirthDate()==null)
                throw new InvalidJSONException("Errore nei dati inviati");

            userRepository.delete(user);

        } catch (IllegalStateException | PersistenceException e) {
            throw new ServiceException("Al momento non è possibile soddisfare la richiesta");
        } catch (MasterException e) {
            throw e;
        }
    }

    public List<User> all() {
        return userRepository.findAll();
    }

}
