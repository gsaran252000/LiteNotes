import React, { useContext } from 'react'
import notecontext from '../context/notes/noteContext';

const NoteItem = (props) => {
  const context = useContext(notecontext);
  const notes = context.notes;
  const setNotes = context.setNotes;
  const addNote = context.addNote;
  const deleteNote = context.deleteNote;
  const editNote = context.editNote;

  const note = props.note;
  const updateNote = props.updateNote;
  return (
    <div className='col-md-3'>
      <div className="card">
        <div className="card-body">
          <h5 className="card-title"> {note.title}</h5>
          <p className="card-text">{note.description}</p>
          <i className="far fa-trash-alt mx-2" onClick={() => { deleteNote(note._id) }}></i>
          <i className="far fa-edit mx-2" onClick={() => { updateNote(note) }}></i>
        </div>
      </div>


    </div>
  )
}

export default NoteItem
