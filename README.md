#### GET /data/users
returneaza lista de useri

#### POST /data/users/add
Body - json cu user (e nevoie doar de nume si facebook id din obiect)
Daca nu exista, il creeaza. Returneaza userul de pe server.

#### GET /stories
returneaza lista de story (cu tot cu quests)

#### POST /stories/add
body - json cu story, adauga story , il si returneaza dupa ce a fost adaugat. (cu tot cu id)

#### PUT /stories/update
body - json cu storyul deja editat, va fi inlocuit cu cel actual, il si returneaza.


#### POST /quests/add
adauga questul, bodyul e questul in json

#### PUT /quests/update
face update, bodyul e jsonul deja editat cu questul

#### POST /quizes/add
adauga quizul

#### PUT /quizes/update
actualizeaza quizul

#### GET /quiz , parametru hash
returneaza quizul cu hashul din parametru, daca nu exista, un mesaj "not found"
ex: /quiz?hash=abcbdef

