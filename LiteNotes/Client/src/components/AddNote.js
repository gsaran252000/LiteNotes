import React, { useContext, useState } from 'react'
import notecontext from '../context/notes/noteContext';

const AddNote = () => {
  const context = useContext(notecontext);
  const notes = context.notes;
  const setNotes = context.setNotes;
  const addNote = context.addNote;

  const [note, setNote] = useState({ title: "", description: "", tag: "general" });

  const handleClick = (e) => {
    e.preventDefault();
    addNote(note.title, note.description, note.tag);
  }

  const onChange = (e) => {
    setNote({ ...note, [e.target.name]: e.target.value });
  }

  return (
    <div>
      <div className="container my-3">
        <h1>Add a Note</h1>
        <form>
          <div className="mb-3">
            <label className="form-label">Title</label>
            <input type="text" className="form-control" id="title" name="title" aria-describedby="emailHelp" onChange={onChange} />
          </div>
          <div className="mb-3">
            <label className="form-label">Description</label>
            <input type="text" className="form-control" name="description" id="desc" onChange={onChange} />
          </div>
          <div className="mb-3">
            <label className="form-label">Tag</label>
            <input type="text" className="form-control" name="tag" id="tag" onChange={onChange} />
          </div>
          <button type="submit" className="btn btn-primary" onClick={handleClick}>Add Note</button>
        </form>
      </div>
    </div>
  )
}

export default AddNote
