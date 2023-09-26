````plantuml

title Upload Essay
|#lightblue|Applicant| 
|#pink|System|

|Applicant|
start
if (Essay completed?) then (Yes)
:Add college tags;
:Upload essay to forum;
|System|
:Adds essay to college forum;
stop
else (No)
if (Save as draft?) then (Yes)
:Saves the draft;
else (No) 
:Deletes the draft;
endif
stop
````
