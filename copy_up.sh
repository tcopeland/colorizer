#!/bin/bash


cd classes/production/colorizer/
jar -cvf ../../../colorizer.jar *.class
cd -
jarsigner -keystore ~/myKeyStore -storepass password colorizer.jar myself
scp index.html colorizer.jnlp colorizer.jar tom@infoether.com:public_html/colorizer/
