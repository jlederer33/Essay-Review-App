```plantuml
title Reviewer Navigate Screen (Casual)

|#palegreen|Reviewer|
|#pink|System|

|System|
Start
|Reviewer|
:Searches colleges/keywords for essays;
|System|
:Match keywords to relevant essays;
:Display relevant essays;
|Reviewer|
:Apply edits and feedback;
if (Done with feedback?) then (Yes)
|System|
:Adds feedback;
|Reviewer|
:Upload edited essay;
|System|
:Feedback is added to essay;
stop
else(No)
Switch (Save edits as draft?)
Case(Don't Save)
|System|
:Edits are Deleted;
stop
Case(Save)
:Edits are saved for later;
Stop




```