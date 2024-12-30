package org.contact.contact.repository;

import java.util.List;
import java.util.Optional;

import org.contact.contact.dto.contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepository extends JpaRepository<contact, Integer>{

    boolean existsByName(String name);

    Optional<contact> findByName(String name);

    Optional<contact> findByPhoneNumber(long phoneNumber);

    List<contact> findByAddress(String address);

}
