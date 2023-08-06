import view
import model
import text_rus

my_notes = model.Notes(text_rus.file_name)

def run():
    while True:

        #user's choice from main menu
        choice = view.main_menu()

        #no operations with empty list besides loading notes from file, adding new note and exit
        if my_notes.length() or choice == 1 or choice == 4 or choice == 8:

            match choice:
                #opening csv file with notes saved
                case 1:
                    my_notes.open()

                    if my_notes.length():
                        view.print_msg(text_rus.load_success)
                    else:
                        view.print_msg(text_rus.empty_file(text_rus.file_name))

                #saving current set of notes to csv file 
                case 2:
                    my_notes.save()
                    view.print_msg(text_rus.save_success)

                #loading notes from file into the list
                case 3:
                    notes = my_notes.load()
                    view.print_notes(notes, text_rus.notes_empty)

                #adding new note to the list    
                case 4:
                    note = view.input_note(text_rus.input_new_note)
                    title_cur = my_notes.add(note)
                    view.print_msg(text_rus.new_note_success(title_cur))

                #search the list for notes by specific date/time (or just their part)
                case 5:
                    date_search = view.input_search(text_rus.input_search)
                    res = my_notes.search(date_search)
                    view.print_notes(res, text_rus.empty_search(date_search))
                    
                #modification of the note specified & found
                case 6:
                    date_search = view.input_search(text_rus.input_modify)
                    res = my_notes.search(date_search)
                    if res:
                        if len(res) != 1:
                            view.print_notes(res, '')
                            cur_id = view.input_search(text_rus.input_index_modify)
                        else:
                            cur_id = res[0].get('id')

                        note = view.input_note(text_rus.modify_note)
                        title_cur = my_notes.modify(note, cur_id)
                        view.print_msg(text_rus.modify_success(title_cur))
                    else:
                        view.print_msg(text_rus.empty_search(date_search))
                 
                #deletion of the note specified & found
                case 7:
                    date_search = view.input_search(text_rus.input_delete)
                    res = my_notes.search(date_search)
                    if res:
                        if len(res) != 1:
                            view.print_notes(res, '')
                            del_id = view.input_search(text_rus.input_index_delete)
                        else:
                            del_id = res[0].get('id')

                        #asking for confirmation on deletion
                        if view.confirm_delete(res[0].get('title')):
                            title = my_notes.delete(del_id)
                            view.print_msg(text_rus.delete_success(title))
                    else:
                        view.print_msg(text_rus.empty_search(date_search))
                
                #exit out of the application
                case 8:
                    break
        #for empty list        
        else:
            view.print_msg(text_rus.notes_empty)
