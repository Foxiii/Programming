% a
pflanze(baum).
pflanze(getreide).
tier(elefant).
tier(schwein).
tier(wolf).
tier(mensch).

isst(elefant, baum).
isst(schwein, Nahrung) :- tier(Nahrung); pflanze(Nahrung). % Schwein frisst Tiere und Pflanzen
isst(mensch, schwein).
isst(mensch, getreide).
isst(wolf, schwein).
isst(wolf, mensch).

% b
werIsstSchwein(X) :- isst(X, schwein).

% c
fleischfresser(X) :- isst(X, Nahrung), tier(Nahrung).

% d
fressfeinde(X,Y) :- tier(X), tier(Y),         % X und Y sind Tiere 
                    (isst(X, A), isst(Y, A)). % X und Y fressen das gleiche

% e
nimmtZuSich(X,Y) :- isst(X, Y).
nimmtZuSich(X,Y) :- isst(X, Nahrung), tier(X), tier(Nahrung), nimmtZuSich(Nahrung, Y).

