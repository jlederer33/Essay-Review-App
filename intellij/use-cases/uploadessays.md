````plantuml

title Upload Essay
|#lightblue|Applicant| 
|#pink|System|

|Applicant|
start
if (Essay completed?) then (Yes)
:Review and submit;
switch (Type of essay?)
case (Personal essay)
:Add personal tags;
case (Supplement)
:Add college tags;
endswitch
:Uploads essay to forum;
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
