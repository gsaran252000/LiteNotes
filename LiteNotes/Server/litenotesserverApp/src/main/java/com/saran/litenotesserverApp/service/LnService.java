package com.saran.litenotesserverApp.service;

import com.saran.litenotesserverApp.model.Note;
import com.saran.litenotesserverApp.model.NoteResponse;
import com.saran.litenotesserverApp.model.User;
import com.saran.litenotesserverApp.model.UserResponse;
import com.saran.litenotesserverApp.repo.NoteRepo;
import com.saran.litenotesserverApp.repo.UserRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LnService {
    @Autowired
    private UserRepo uRepo;
    @Autowired
    private NoteRepo nRepo;
    @Autowired
    private UserResponse uRes;
    @Autowired
    private NoteResponse nRes;

    public boolean isExistingUser(String email){
        if(uRepo.existsNoteByemail(email)){
            System.out.println("User Already Exists");
            return true;
        }

        System.out.println("User do not exists");
        return false;
    }

    public UserResponse createUser(User user){

        if(isExistingUser(user.getEmail())){
            uRes.setAuthtoken("");
            uRes.setStatus(false);
        }
        else {
            uRepo.save(user);

            if(user.getUserid() != 0){
                uRes.setAuthtoken(String.valueOf(user.getUserid()));

                uRes.setStatus(true);
            } else {
                uRes.setAuthtoken("");
                uRes.setStatus(false);
            }
        }

        return uRes;
    }

    public UserResponse logInUser(User user){
        if(isExistingUser(user.getEmail())){
            uRes.setAuthtoken("");
            uRes.setStatus(true);
        } else{
            uRes.setAuthtoken("");
            uRes.setStatus(false);
        }

        return uRes;
    }

    public NoteResponse AddNote(Note note){
        nRepo.save(note);
        nRes.setStatus("Success");

        return nRes;
    }

    public List<Note> getAllNotes(int userid){
        System.out.println("userid : "+userid);
        return nRepo.findAllByUserId(userid);
    }

    public void putNote(Note note, int noteid){
        note.setNoteid(noteid);
        nRepo.save(note);
    }

    public void deleteNote(int noteid){
        nRepo.deleteById(noteid);
    }
}
