hextodec(A,D) :-	
	reverse(A,E),
	hex(E,0,D).

% if A is null/empty, then return 0
hex([],N,D) :- D is 0.

hex([HEAD|TAIL],N,D) :-
	num(HEAD,C),
	hex(TAIL, N+1,E),
	D is C*16**N+E.
	

num('a',10).
num('b',11).
num('c',12).
num('d',13).
num('e',14).
num('f',15).
num(X,X).
