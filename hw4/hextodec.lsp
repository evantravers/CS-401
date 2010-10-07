(defun hextodec(a)
	(hex (reverse a) 0)
)

(defun hex(a n)
	(cond
	((null a) 0)	
	(t (+ (* (num (car a)) (expt 16 n)) (hex (cdr a) (+ n 1))))
	)
)

(defun num(n)
	(cond
	((eq n 'a) 10)
	((eq n 'b) 11)
	((eq n 'c) 12)
	((eq n 'd) 13)
	((eq n 'e) 14)
	((eq n 'f) 15)
	(t n)
	)
)
