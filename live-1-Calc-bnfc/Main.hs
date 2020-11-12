{-# LANGUAGE LambdaCase #-}

import Calc.Abs  ( Exp(..) )
import Calc.Par  ( pExp, myLexer )
import Calc.ErrM ( Err(..) )

eval :: Exp -> Integer
eval = \case
  EInt i -> i
  EPlus  e1 e2 -> eval e1 + eval e2
  EMinus e1 e2 -> eval e1 - eval e2
  ETimes e1 e2 -> eval e1 * eval e2
  EDiv   e1 e2 -> eval e1 `div` eval e2

main :: IO ()
main = do
  -- Read from stdin, lex, parse
  res <- pExp . myLexer <$> getContents
  case res of
    Bad err -> putStrLn err
    Ok  e   -> print $ eval e
