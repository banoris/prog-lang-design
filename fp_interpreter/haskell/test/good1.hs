x         = \ x -> 600 ;  -- pointless but syntactically correct
id x      = x ;
twice f x = f (f x) ;
fst x y   = x ;
fst1      = (\ x -> \ y -> x) ;
snd x     = \ x -> x ;
snd2      = \ x -> \ x -> x ;
main      = print (twice (\ x -> x) 7) ; -- result 7
-- main   = print (fst (twice (\x -> x)) 6 7) ; -- result 7

-- Example where dynamic binding gives different result:
-- n = 5
-- f = \ m -> n + m
-- g = \ n -> f n
-- main = print (g 0)
--   - static  binding of n: 5 + 0 = 5
--   - dynamic binding of n: 0 + 0 = 0
