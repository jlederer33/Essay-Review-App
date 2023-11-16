```plantuml

title Upload Essay (Fully Dressed)
|#lightblue|Applicant| 
|#pink|System|

|System|
start
:Displays;
|Applicant|
switch (essay)
case (edits)
:make edits to essay;
case(add)
:add new essay;
case (remove)
:delete essay;
endswitch

|Applicant|
while (save as draft) is (Yes)
:Yes;
|System|
:Updates essay;
endwhile (No)
:DONE;


```