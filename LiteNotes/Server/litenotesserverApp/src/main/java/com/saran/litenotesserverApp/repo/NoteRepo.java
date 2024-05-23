package com.saran.litenotesserverApp.repo;

import com.saran.litenotesserverApp.model.Note;
import com.saran.litenotesserverApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
    @Query("SELECT u FROM Note u WHERE u.userid = ?1")
    List<Note> findAllByUserId(int id);
    void deleteBynoteid(int noteid);

//    UPDATE employees
//    SET name = 'John Doe', salary = 60000
//    WHERE id = 5;
//
//    @Query("UPDATE Employee e SET e.name = :name, e.salary = :salary WHERE e.id = :id")
//    int updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("salary") Double salary);

    @Query("UPDATE Note e SET e.title = :title, e.description = :description, e.tag = :tag WHERE e.noteid = :noteid")
    void updateByNoteId(@Param("noteid") int noteid,@Param("title") String title,@Param("description") String description,@Param("tag") String tag);
}
