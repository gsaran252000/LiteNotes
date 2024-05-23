package com.saran.litenotesserverApp.repo;

import com.saran.litenotesserverApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, InternalError> {
    boolean existsNoteByemail(String email);
}
