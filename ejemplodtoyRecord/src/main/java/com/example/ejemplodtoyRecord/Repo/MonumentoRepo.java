package com.example.ejemplodtoyRecord.Repo;

import com.example.ejemplodtoyRecord.Model.Moumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepo extends JpaRepository<Moumento,Long> {
}
