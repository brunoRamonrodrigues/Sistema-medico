package com.limamed.bra.repositories;

import com.limamed.bra.models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
}
