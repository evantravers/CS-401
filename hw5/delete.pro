del(Atom, [], []).

del(Atom, [Car|Cdr], R) :-
	atom(Car),
	\+ Car = Atom,
	del(Atom, Cdr, A),
	append2(Car, A, R).

del(Atom, [Car|Cdr], R) :-
	atom(Car),
	Atom = Car,
	del(Atom, Cdr, R).

del(Atom, [Car|Cdr], R) :-
	list(Car),
	del(Atom, Car, A),
	E = [A],
	del(Atom, Cdr, B),
	append(E, B, R).	

list(X) :- \+ atom(X).

append2(X, A, R) :-
	B = [X],
	append(B, A, R).

