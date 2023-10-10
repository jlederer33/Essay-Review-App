
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
:Exeute uploadEssays;
:submit essay;
|System| 
:System adds essay to dashboard and forum;
stop

```