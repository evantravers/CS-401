(defun perfect(x)
	(cond 
		((= (reduce '+ (factor x x)) x) (factor x x))
		(t nil)
	)
)

(defun factor(x n)
	(cond	
		((= n 1) nil)
		((not (= (mod x n)0)) (factor x (- n 1)))
		((= (mod x n)0) (cons (/ x n) (factor x (- n 1) )))
	)
)
