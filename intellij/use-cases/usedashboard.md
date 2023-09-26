```plantuml
title Use Dashboard


|#lightblue|Applicant|
|#pink|System|

|Applicant|
start
while(Searches colleges to add to dashboard) is (Adding more colleges)
:Add colleges to dashboard;
|System|
:Adds colleges to dashboard;
:Updates dashboard based on colleges added;
endwhile (No colleges to add)
|System|
:returns to dashboard;
stop



```