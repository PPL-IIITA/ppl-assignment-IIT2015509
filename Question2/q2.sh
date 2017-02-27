file="2.log"
if [ -f $file ] ; then
	rm $file
fi
javac q2.java
java q2

echo 
echo "Log file is :" 
echo 

cat "2.log"

