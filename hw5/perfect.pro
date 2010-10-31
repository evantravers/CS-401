perfect(X, R) :-
	B is X-1,	
	listFromTo(1,B,L),
	removeMultiples(L, X, R),
	reduce(R,A),	
	A=X.	

multiple(N, M) :- M > 0, Mod is N mod M, Mod = 0.

reduce([], 0).
reduce([Head | Tail], TotalSum) :-
	reduce(Tail, Sum1),
	TotalSum is Head + Sum1.

listFromTo(M, N, []) :- M > N.
listFromTo(M, M, [M]).
listFromTo(M, N, [M | M_Rest]) :- 
  M < N, M1 is M + 1, listFromTo(M1, N, M_Rest).

removeMultiples([], N, []).
removeMultiples([List1_Head | List1_Tail], N, List2) :-
  \+ multiple(N, List1_Head), removeMultiples(List1_Tail, N, List2).
removeMultiples([List1_Head | List1_Tail], N, [List1_Head | List2_Tail]) :-
  multiple(N, List1_Head), removeMultiples(List1_Tail, N, List2_Tail).
