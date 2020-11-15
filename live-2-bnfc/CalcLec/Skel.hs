-- Haskell module generated by the BNF converter

module CalcLec.Skel where

import qualified CalcLec.Abs

type Err = Either String
type Result = Err String

failure :: Show a => a -> Result
failure x = Left $ "Undefined case: " ++ show x

transExp :: CalcLec.Abs.Exp -> Result
transExp x = case x of
  CalcLec.Abs.EAdd exp1 exp2 -> failure x
  CalcLec.Abs.ESub exp1 exp2 -> failure x
  CalcLec.Abs.EMul exp1 exp2 -> failure x
  CalcLec.Abs.EDiv exp1 exp2 -> failure x
  CalcLec.Abs.EInt integer -> failure x
