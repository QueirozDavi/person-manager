package com.personmanager.manager.repository;

import com.personmanager.manager.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByCpf(String cpf);

    Page<Person> findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
