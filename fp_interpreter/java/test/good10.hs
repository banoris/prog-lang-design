-- 2016-12-08
-- This one can go wrong under call-by-value with mutable environments

main = print ((\ x -> (\ y -> x) ((\ x -> x) 0)) 1) ;

-- Expected output: 1
--
-- CBV-evaluation:
-- ⊢ (λx → (λy→x) ((λx→x) 0)) 1
-- x=1 ⊢ (λy→x) ((λx→x) 0)
-- - fun: ⟨λy→x;x=1⟩
-- - arg: x=1 ⊢ (λx→x) 0
--   - fun: ⟨λx→x; x=1⟩
--   - arg: 0
--   - app: x=1, x=0 ⊢ x ⇓ 0
-- - app: x=1, y=0 ⊢ x ⇓ 1
-- 1
