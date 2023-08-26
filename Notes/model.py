from datetime import datetime
import os


class Notes:

    def __init__(self, path: str):
        self._notes: list[dict[str, str]] = []
        self._path = path
        self._last_id = 0


    #open file with notes
    def open(self):

        self._notes = []# otherwise re-open of notes file will add new (same) lines to already opened data
        try:
            with open(self._path, 'r', encoding='UTF-8') as file:
                data = file.readlines()  # as data lines in file are sep by '\n'
            for note in data:
                note = note.strip().split(';')
                new = {'id': note[0],'title': note[1], 'body': note[2], 'date': note[3]}
                self._notes.append(new)
        except FileNotFoundError:
            return False
        else:
            return True


    #saves the notes
    def save(self):
        data = []
        for note in self._notes:
            data.append(';'.join([value for value in note.values()]))
        data = '\n'.join(data)
        with open(self._path, 'w', encoding='UTF-8') as file:
            file.write(data)


    #load the notes
    def load(self):
        return self._notes


    #adding new note
    def add(self, new: dict) -> str:
        if len(self._notes) == 0:
            self._last_id = 1
        else:
            self._last_id = int(self._notes[len(self._notes)-1]['id']) + 1

        new['id'] = str(self._last_id)
        new['date'] = str(datetime.now().replace(microsecond=0))
        self._notes.append(new)
        return new['title']

 
    #search for notes by the date or any of its consequent part
    def search(self, date_cur: str) -> list[dict[str, str]]:
        res: list[dict[str, str]] = []
        for note in self._notes:
            if date_cur in note.get('date'):
                res.append(note)
                
        return res


    #modification of the note chosen
    def modify(self, new: dict, index: int):
        for note in self._notes:
            if index == note.get('id'):
                note['title'] = new.get('title', note.get('title'))
                note['body'] = new.get('body', note.get('body'))
                note['date'] = str(datetime.now().replace(microsecond=0))
                return note.get('title')
            

    #deletion of the note chosen
    def delete(self, index: int) -> str:
        for i in range(len(self._notes)):
            if index == self._notes[i].get('id'):
                title = self._notes[i].get('title')
                del self._notes[i]
                return title
            

    #return a number of items in the list        
    def length(self) -> int:
        return len(self._notes)
