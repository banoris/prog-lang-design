class Eval {

  static class EvalVisitor implements calc.Absyn.Exp.Visitor <Integer,Void> {

    public EvalVisitor () {}

    public Integer visit (calc.Absyn.EInt p, Void arg) {
      return p.integer_;
    }
    public Integer visit (calc.Absyn.EAdd p, Void arg) {
      return p.exp_1.accept (this, null)
           + p.exp_2.accept (this, null);
    }
    public Integer visit (calc.Absyn.EMul p, Void arg) {
      return p.exp_1.accept (this, null)
           * p.exp_2.accept (this, null);
    }
    public Integer visit (calc.Absyn.ESub p, Void arg) {
      return p.exp_1.accept (this, null)
           - p.exp_2.accept (this, null);
    }
    public Integer visit (calc.Absyn.EDiv p, Void arg) {
      return p.exp_1.accept (this, null)
           / p.exp_2.accept (this, null);
    }
  }

  public static void main (String[] args) {

    calc.Absyn.Exp e =
      new calc.Absyn.EAdd
        ( new calc.Absyn.EInt (5)
        , new calc.Absyn.EMul
          ( new calc.Absyn.EInt (6)
          , new calc.Absyn.EInt (7)));

    Eval eval = new Eval();
    Integer value = e.accept (new EvalVisitor(), null);

    System.out.print (value);

  }

/*

  e5 = EInt (5)
  e6 = EInt (6)
  e7 = EInt (7)
  e67  = EMul (e6, e7)
  e567 = EAdd (e5, e67)
  v = EvalVisitor()
  e567.accept (v)
  ---> v.visit (e567)
  ---> e567.exp_1.accept (v) + e567.exp_2.accept (v)
  ---> e5.accept (v) + e67.accept (v)
  ---> v.visit (e5)  + v.visit (e67)
  ---> 5 + e67.exp_1.accept (v) * e67.exp_2.accept (v)
  ---> 5 + v.visit (e6) * v.visit (e7)
  ---> 5 + 6 * 7

*/

}
