```plantuml

title Upload Essay (Fully Dressed)
|#lightblue|Applicant| 
|#pink|System|

|System|
start
:Displays;
|Applicant|
switch (Essay)
case (edits)
:Make edits to essay;
case(add)
:Add new essay;
case (remove)
:Delete essay;
endswitch

|Applicant|
while (save as draft) is (Yes)
:Yes;
|System|
:Updates essay;
endwhile (No)
:Essay deleted;


```