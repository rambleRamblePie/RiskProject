JCLOC = "compiled classes/"
JFLAGS = -source 8 -d $(JCLOC)
JC = javac

default:
	mkdir $(JCLOC)
	$(JC) $(JFLAGS) *.java
	
clean:
	$(RM) $(JCLOC)*.class
