package com.hr_user.hr_user.repositories;

import com.hr_user.hr_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
