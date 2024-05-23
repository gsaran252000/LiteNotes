package com.saran.litenotesserverApp;

import com.saran.litenotesserverApp.model.Note;
import com.saran.litenotesserverApp.model.NoteResponse;
import com.saran.litenotesserverApp.model.User;
import com.saran.litenotesserverApp.model.UserResponse;
import com.saran.litenotesserverApp.service.LnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class LnController {
    @Autowired
    private LnService service;

    @PostMapping("createuser")
    public UserResponse createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PostMapping("api/notes/addnote")
    public NoteResponse addNote(@RequestBody Note note){
        return service.AddNote(note);
    }

    @GetMapping("api/notes/fetchallnotes")
    public List<Note> getAllNotes(@RequestHeader("auth-token") String authtoken){
        System.out.println("AuthToken Recieved is : "+authtoken);
        return service.getAllNotes(Integer.parseInt(authtoken));
    }

    @PutMapping("/api/notes/updatenote/{id}")
    public void putNote(@PathVariable("id") int noteid,@RequestBody Note note){
        service.putNote(note, noteid);
    }

    @DeleteMapping("/api/notes/deletenote/{id}")
    public void deleteNote(@PathVariable("id") int noteid){
        System.out.println("NoteId : " + noteid);
        service.deleteNote(noteid);
    }
}
