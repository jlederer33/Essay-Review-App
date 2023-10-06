
```plantuml
title Applicant Navigate Screen (Fully Dressed)
|#lightblue|Applicant| 
|#pink|System|

|Applicant|
start
:opens dashboard;
:executes applicantDashboard;
|Applicant|
:checks checklist;
while (Tasks remaining?) is (Yes)
:execute prepareApplication;
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