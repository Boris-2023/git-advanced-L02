import text_rus

#operating main menu
def main_menu() -> int:
    print(text_rus.main_menu)
    while True:
        choice = input(text_rus.input_choice)
        if choice.isdigit() and 0 < int(choice) < 9:
            return int(choice)

#printing input message enframed with '===' lines of the same length
def print_msg(msg: str):
    print('\n' + '='*len(msg))
    print(msg)
    print('='*len(msg) + '\n')


#printing all notes, which are input
def print_notes(book: list[dict[str, str]], error: str):
    msg_len = 138

    if book:
        print('\n' + '='*msg_len)
        for note in book:
            print(f'{note.get("id"):>3} | {note.get("title"):^30} | {note.get("body"):<75} | {note.get("date"):<30}')
        print(msg_len*'=' + '\n')
    else:
        print_msg(error)

#creating new note (only fields 'title' and 'body' are user-defined, 'id' and 'date' are assigned automatically)
def input_note(msg: str) -> dict[str, str]:
    new = {}
    print_msg(msg)
    for key, txt in text_rus.new_note.items():
        if(key != 'id' and key != 'date'):
            cur_val = input(txt)
            if cur_val:
                new[key] = cur_val
        else:
            new[key] = '0'

    return new

#search for the note
def input_search(msg: str) -> str:
    return input(msg)

#confirmation for deletion
def confirm_delete(title: str):
    confirm = input(text_rus.delete_confirm(title)).lower()
    if confirm == 'y':
        return True
    else:
        return False
