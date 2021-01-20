import java.util.*;
import fun.Absyn.*;

public class Interpreter {

  // Strategy
  final Strategy strategy;

  // Signature
  final Map<String,Exp> sig = new TreeMap();

  // Control debug printing.
  final boolean debug = false;

  // Empty environment
  final Environment EMPTY = new Environment();

  public Interpreter (Strategy strategy) {
    this.strategy = strategy;
  }

  // Entrypoint
  public void interpret(Program p) {
    System.out.println(p.accept(new ProgramVisitor(), null).intValue());
  }

  public class ProgramVisitor implements Program.Visitor<Value,Void>
  {
    public Value visit(fun.Absyn.Prog p, Void arg)
    {
      // build signature
      for (Def d: p.listdef_) d.accept(new DefVisitor(), null);
      // execute main expression
      return p.main_.accept(new MainVisitor(), null);
    }
  }

  // Visit definitions to build the signature

  public class DefVisitor implements Def.Visitor<Void,Void>
  {
    public Void visit(fun.Absyn.DDef p, Void arg)
    {
      Exp e = p.exp_;
      // p.listident_
      // abstract over arguments from right to left
      // f x1 ... xn = e  =====>  f = \ x1 -> ... \ xn -> e
      Collections.reverse(p.listident_);
      for (String x: p.listident_) {
        e = new EAbs(x,e);
      }
      sig.put(p.ident_, e);
      return null;
    }
  }

  // Evaluate main expression

  public class MainVisitor implements Main.Visitor<Value,Void>
  {
    public Value visit(fun.Absyn.DMain p, Void arg)
    {
      return eval(p.exp_, EMPTY);
    }
  }

  // Evaluate an expression
  // gamma |- e ==> v

  public Value eval(Exp e, Environment env) {
    return e.accept(new EvalVisitor(), env);
  }

  public class EvalVisitor implements Exp.Visitor<Value,Environment>
  {
    // variable
    public Value visit(fun.Absyn.EVar p, Environment env)
    {
      // p.ident_
      try {
        return env.lookup(p.ident_);
      } catch (Unbound msg) {
        Exp e = sig.get(p.ident_);
        if (e == null) throw new RuntimeException("Undefined function " + p.ident_);
        return eval(e, EMPTY);
      }
    }

    // literal
    public Value visit(fun.Absyn.EInt p, Environment env)
    {
      return new IntValue (p.integer_);
    }

    // lambda
    public Value visit(fun.Absyn.EAbs p, Environment env)
    {
      return new FunValue (p.ident_, p.exp_, env);
    }

    // application
    public Value visit(fun.Absyn.EApp p, Environment env)
    {
      Value f = eval(p.exp_1, env);
      Entry e;
      if (strategy == Strategy.CallByValue)
         e = new ValEntry(eval(p.exp_2, env));
      // TODO: call-by-name
      else e = null;
      // e = new ClosEntry(p.exp_2, env);
      return f.apply(e);
    }

    // plus
    public Value visit(fun.Absyn.EAdd p, Environment env)
    {
      todo("plus");
      return null;
    }

    // minus
    public Value visit(fun.Absyn.ESub p, Environment env)
    {
      todo("minus");
      return null;
    }

    // less-than
    public Value visit(fun.Absyn.ELt p, Environment env)
    {
      todo("less-than");
      return null;
    }

    // if
    public Value visit(fun.Absyn.EIf p, Environment env)
    {
      todo("if");
      return null;
    }
  }

  // TODOs /////////////////////////////////////////////////////////////

  public void todo(String msg) {
    throw new RuntimeException ("TODO: " + msg);
  }

  // Environment ///////////////////////////////////////////////////////

  class Environment {
    Value lookup (String x) throws Unbound { throw new Unbound(x); }
  }

  class Extend extends Environment {
    final Environment env;
    final String      y;
    final Entry       entry;

    Extend (String y, Entry entry, Environment env) {
      this.env   = env;
      this.y     = y;
      this.entry = entry;
    }

    Value lookup (String x) throws Unbound {
      if (x.equals(y)) return entry.value();
      else return env.lookup(x);
    }

  }

  // Exception for unbound identifier

  class Unbound extends Exception {
    public Unbound(String x) {
      super("Unbound identifier: " + x);
    }
  }

  // Environment entries ////////////////////////////////////////////////

  abstract class Entry {
    abstract public Value value();
  }

  class ValEntry extends Entry {
    final Value v;
    ValEntry (Value v) { this.v = v; }
    public Value value() { return v; }
  }

  // Value /////////////////////////////////////////////////////////////

  class Value {
    public int intValue() {
      throw new RuntimeException ("value is not an integer");
    }
    public Value apply (Entry e) {
      throw new RuntimeException ("value is not a function");
    }
  }

  class IntValue extends Value {
    final int i;
    IntValue (int i) { this.i = i; }
    public int intValue() { return i; }
  }

  // <\x->body; gamma>
  class FunValue extends Value {
    final String x;
    final Exp    body;
    final Environment gamma;

    FunValue (String x, Exp body, Environment gamma) {
      this.x = x;
      this.body = body;
      this.gamma = gamma;
    }

    public Value apply(Entry e) {
      return eval(body, new Extend(x, e, gamma));
    }
  }

}
