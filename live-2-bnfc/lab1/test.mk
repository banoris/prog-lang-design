parser=CPP/Test

default : test1

.PHONY : test%
test% :
	$(parser) testsuite/good/$*-*.cc

# test1:
# 	$(parser) testsuite/good/1-hello.cc
# 	$(parser) testsuite/good/2-greet.cc
# 	$(parser) testsuite/good/3-med.cc
# 	$(parser) testsuite/good/4-grade.cc
# 	$(parser) testsuite/good/5-palin.cc
# 	$(parser) testsuite/good/6-grammar.cc

# EOF
