(defun delete(elem in)
	(cond
		((eq(length (cdr in))0) (if (not (eq elem (car in)))(cons (car in) '())))
		((atom (car in))
			(if (not (eq (length (cdr in)) 0))(if (not (eq elem (car in)))(cons (car in) (delete elem (cdr in)))(delete elem (cdr in))))
		)
		((listp (car in))
			(if (not (eq (length (cdr in)) 0))(cons (delete elem (car in)) (delete elem (cdr in))))
		)	
	)
)

