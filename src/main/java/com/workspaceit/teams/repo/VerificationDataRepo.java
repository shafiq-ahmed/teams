package com.workspaceit.teams.repo;

import com.workspaceit.teams.entity.VerificationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDataRepo extends JpaRepository<VerificationData,String> {
}
