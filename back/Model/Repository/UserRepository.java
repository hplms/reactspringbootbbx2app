package com.example.practicaBBX2.Model.Repository;

import com.example.practicaBBX2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {}
