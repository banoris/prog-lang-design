{-# LANGUAGE PatternSynonyms #-}

module Main where

import System.IO  (stdout, hSetBuffering, pattern NoBuffering)

import Calc.Abs   (Exp(..))         -- abstract syntax
import Calc.Par   (pExp, myLexer)   -- parser
import Calc.ErrM  (pattern Ok)      -- parse error monad

-- | Evaluate an expression.

eval :: Exp -> Integer
eval = _

-- | Parse and evaluate.

calc :: String -> String
calc = _

-- | Read-Eval-Print-Loop.

repl :: String -> (String -> String) -> IO ()
repl prompt interpret = loop where
  loop = do
    putStr prompt
    s <- getLine
    if null s then return () else do
      putStrLn (interpret s)
      loop

-- | Entrypoint.

main :: IO ()
main = do
  hSetBuffering stdout NoBuffering
  repl "calc> " calc
