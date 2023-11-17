```plantuml

title Upload Essay (Fully Dressed)
|#lightblue|Applicant| 
|#pink|System|

|System|
start
:Displays essay dashboard;
|Applicant|
switch (Work on essays)
case (edits)
:Choose existing essay to edit;
:Make edits to essay;
case(add)
:Fill out title, text, and type;
:submit essay;
case (remove)
:Delete essay;
endswitch

|Applicant|
while (save as draft) is (Yes)
:Yes;
|System|
:Essay saved as draft;
endwhile (No)
:Essay deleted;


```