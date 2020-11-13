JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=${JAVA} ${JAVA_FLAGS} JLex.Main
LEXER_FLAGS=
all : test

test : absyn cpp/Yylex.class cpp/PrettyPrinter.class cpp/Test.class cpp/VisitSkel.class cpp/ComposVisitor.class cpp/AbstractVisitor.class cpp/FoldVisitor.class cpp/AllVisitor.class cpp/parser.class cpp/sym.class cpp/Test.class

.PHONY : absyn

%.class : %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn : cpp/Absyn/Program.java cpp/Absyn/PDefs.java cpp/Absyn/Def.java cpp/Absyn/DFun.java cpp/Absyn/ListDef.java cpp/Absyn/Arg.java cpp/Absyn/ADecl.java cpp/Absyn/ListArg.java cpp/Absyn/Stm.java cpp/Absyn/SExp.java cpp/Absyn/SDecls.java cpp/Absyn/SInit.java cpp/Absyn/SReturn.java cpp/Absyn/SReturnVoid.java cpp/Absyn/SWhile.java cpp/Absyn/SBlock.java cpp/Absyn/SIfElse.java cpp/Absyn/ListStm.java cpp/Absyn/Exp.java cpp/Absyn/ETrue.java cpp/Absyn/EFalse.java cpp/Absyn/EInt.java cpp/Absyn/EDouble.java cpp/Absyn/EString.java cpp/Absyn/EId.java cpp/Absyn/EApp.java cpp/Absyn/EPIncr.java cpp/Absyn/EPDecr.java cpp/Absyn/EIncr.java cpp/Absyn/EDecr.java cpp/Absyn/ETimes.java cpp/Absyn/EDiv.java cpp/Absyn/EPlus.java cpp/Absyn/EMinus.java cpp/Absyn/ELt.java cpp/Absyn/EGt.java cpp/Absyn/ELtEq.java cpp/Absyn/EGtEq.java cpp/Absyn/EEq.java cpp/Absyn/ENEq.java cpp/Absyn/EAnd.java cpp/Absyn/EOr.java cpp/Absyn/EAss.java cpp/Absyn/ETyped.java cpp/Absyn/ListExp.java cpp/Absyn/Type.java cpp/Absyn/Type_bool.java cpp/Absyn/Type_int.java cpp/Absyn/Type_double.java cpp/Absyn/Type_void.java cpp/Absyn/Type_string.java cpp/Absyn/ListId.java
	${JAVAC} ${JAVAC_FLAGS} $^

cpp/Yylex.java : cpp/Yylex
	${LEXER} ${LEXER_FLAGS} cpp/Yylex

cpp/parser.java cpp/sym.java : cpp/_cup.cup
	${PARSER} ${PARSER_FLAGS} cpp/_cup.cup
	mv parser.java sym.java cpp/

cpp/Yylex.class : cpp/Yylex.java cpp/parser.java cpp/sym.java

cpp/sym.class : cpp/sym.java

cpp/parser.class : cpp/parser.java cpp/sym.java

cpp/PrettyPrinter.class : cpp/PrettyPrinter.java

clean :
	rm -f cpp/Absyn/*.class cpp/*.class

distclean : vclean

vclean :
	 rm -f cpp/Absyn/Program.java cpp/Absyn/PDefs.java cpp/Absyn/Def.java cpp/Absyn/DFun.java cpp/Absyn/ListDef.java cpp/Absyn/Arg.java cpp/Absyn/ADecl.java cpp/Absyn/ListArg.java cpp/Absyn/Stm.java cpp/Absyn/SExp.java cpp/Absyn/SDecls.java cpp/Absyn/SInit.java cpp/Absyn/SReturn.java cpp/Absyn/SReturnVoid.java cpp/Absyn/SWhile.java cpp/Absyn/SBlock.java cpp/Absyn/SIfElse.java cpp/Absyn/ListStm.java cpp/Absyn/Exp.java cpp/Absyn/ETrue.java cpp/Absyn/EFalse.java cpp/Absyn/EInt.java cpp/Absyn/EDouble.java cpp/Absyn/EString.java cpp/Absyn/EId.java cpp/Absyn/EApp.java cpp/Absyn/EPIncr.java cpp/Absyn/EPDecr.java cpp/Absyn/EIncr.java cpp/Absyn/EDecr.java cpp/Absyn/ETimes.java cpp/Absyn/EDiv.java cpp/Absyn/EPlus.java cpp/Absyn/EMinus.java cpp/Absyn/ELt.java cpp/Absyn/EGt.java cpp/Absyn/ELtEq.java cpp/Absyn/EGtEq.java cpp/Absyn/EEq.java cpp/Absyn/ENEq.java cpp/Absyn/EAnd.java cpp/Absyn/EOr.java cpp/Absyn/EAss.java cpp/Absyn/ETyped.java cpp/Absyn/ListExp.java cpp/Absyn/Type.java cpp/Absyn/Type_bool.java cpp/Absyn/Type_int.java cpp/Absyn/Type_double.java cpp/Absyn/Type_void.java cpp/Absyn/Type_string.java cpp/Absyn/ListId.java cpp/Absyn/Program.class cpp/Absyn/PDefs.class cpp/Absyn/Def.class cpp/Absyn/DFun.class cpp/Absyn/ListDef.class cpp/Absyn/Arg.class cpp/Absyn/ADecl.class cpp/Absyn/ListArg.class cpp/Absyn/Stm.class cpp/Absyn/SExp.class cpp/Absyn/SDecls.class cpp/Absyn/SInit.class cpp/Absyn/SReturn.class cpp/Absyn/SReturnVoid.class cpp/Absyn/SWhile.class cpp/Absyn/SBlock.class cpp/Absyn/SIfElse.class cpp/Absyn/ListStm.class cpp/Absyn/Exp.class cpp/Absyn/ETrue.class cpp/Absyn/EFalse.class cpp/Absyn/EInt.class cpp/Absyn/EDouble.class cpp/Absyn/EString.class cpp/Absyn/EId.class cpp/Absyn/EApp.class cpp/Absyn/EPIncr.class cpp/Absyn/EPDecr.class cpp/Absyn/EIncr.class cpp/Absyn/EDecr.class cpp/Absyn/ETimes.class cpp/Absyn/EDiv.class cpp/Absyn/EPlus.class cpp/Absyn/EMinus.class cpp/Absyn/ELt.class cpp/Absyn/EGt.class cpp/Absyn/ELtEq.class cpp/Absyn/EGtEq.class cpp/Absyn/EEq.class cpp/Absyn/ENEq.class cpp/Absyn/EAnd.class cpp/Absyn/EOr.class cpp/Absyn/EAss.class cpp/Absyn/ETyped.class cpp/Absyn/ListExp.class cpp/Absyn/Type.class cpp/Absyn/Type_bool.class cpp/Absyn/Type_int.class cpp/Absyn/Type_double.class cpp/Absyn/Type_void.class cpp/Absyn/Type_string.class cpp/Absyn/ListId.class
	 rm -f cpp/Absyn/*.class
	 rmdir cpp/Absyn/
	 rm -f cpp/Yylex cpp/_cup.cup cpp/Yylex.java cpp/VisitSkel.java cpp/ComposVisitor.java cpp/AbstractVisitor.java cpp/FoldVisitor.java cpp/AllVisitor.java cpp/PrettyPrinter.java cpp/Skeleton.java cpp/Test.java cpp/parser.java cpp/sym.java cpp/*.class
	 rm -f Makefile
	 rmdir -p cpp/
