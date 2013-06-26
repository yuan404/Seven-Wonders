copy Doxygen_configure_zh-CN "../src/Doxygen_configure_zh-CN" 
copy DoxygenMainPage_zh-CN.java "../src/DoxygenMainPage.java"

cd ../src

doxygen Doxygen_configure_zh-CN

start ../doc/zh_CN/index.html

del DoxygenMainPage.java
del Doxygen_configure_zh-CN