(dribble "output")
(print "testing hextodec")
(load "hextodec")
(print (hextodec '(a)))
(print (hextodec '(1 f)))
(print (hextodec '(5 a 6 b 7 c 8 d 9 e)))
(print "testing perfect")
(load "perfect")
(print (perfect 6))
(print (perfect 298))
(print (perfect 496))
(print "testing delete")
(load "delete")
(print (delete 'a '(a b r a c a d a b r a)))
(print (delete 'b '(no bs here)))
(print (delete 'nest '(nest (second nest level) (third (nest) level) (((big nest))))))
(dribble)
