```plantuml
title Navigate Screen (Casual)
|#lightblue|Applicant| 
|#pink|System|

|Applicant|
start
:opens dashboard;
while(Searches colleges to add to dashboard) is (Adding more colleges)
:Add colleges to dashboard;
|System|
:Adds colleges to dashboard;
:Updates dashboard based on colleges added;
endwhile (No colleges to add)
|Applicant|
:checks checklist;
while (Tasks remaining?) is (Yes)
:complete tasks;
|System|
:System updates checklist;
endwhile(no)
|Applicant|
:upload essay to college dashboard;
switch (Type of essay?)
case (Personal essay)
:Add personal tags;
case (Supplement)
:Add college tags;
endswitch
:submit essay;
|System| 
:System adds essay to dashboard and forum;
stop

```