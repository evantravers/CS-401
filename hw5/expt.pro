expt(N,0,1).

expt(N,M,E) :-
	M > 0,
	X is M-1,
	expt(N,X,F),
	E is N*F.
