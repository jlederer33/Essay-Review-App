
```plantuml
title Applicant Navigate Screen (Fully Dressed)
|#lightblue|Applicant| 
|#pink|System|

|Applicant|
start
:opens Main Menu;
Switch(choose options)
case (essays)
:Executes uploadEssays;
|System|
:Dashboard updates based on choices in uploadEssays;
stop
case (colleges)
|Applicant|
:Executes applicantDashboard;
while (Tasks remaining?) is (Yes)
Switch(Choices)
case (colleges)
:Chooses to add and remove colleges;
Case (checklist)
:Chooses which tasks to set completed;
endswitch
|Applicant|
:execute prepareApplication;
|System| 
:updates based on user choices;
endwhile(no)
endswitch
stop

```