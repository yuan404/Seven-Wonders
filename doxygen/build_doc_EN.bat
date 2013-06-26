copy Doxygen_configure_EN "../src/Doxygen_configure_EN" 
copy DoxygenMainPage_EN.java "../src/DoxygenMainPage.java"

cd ../src

doxygen Doxygen_configure_EN

start ../doc/EN/index.html

del DoxygenMainPage.java
del Doxygen_configure_EN