file="log.txt"
if [ -f $file ] ; then
			rm $file
		fi
		javac q1.java
		java q1
		
	echo 
	echo "Log file is :" 
	echo 

	cat "1.log"
