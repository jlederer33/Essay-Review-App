# Review Essays:
**Primary Actor**
1. **Reviewer:** wants to add feedback to essay. Wants ease of use, and clarity in where their edits are added

**Other Stakeholders:**
1. **Applicants:** want to receive essay feedback once it has been given. Want to view edits.

**Preconditions:**
* Applicant has already uploaded an essay
* Essay keywords exist, i.e college or other search terms

**Postconditions**
* System updates essay with edits 

```plantuml
title Review and Edit (Fully Dressed)

|#palegreen|Reviewer|
|#pink|System|

|System|
start
:Displays previously edited essays;
|Reviewer|
while (Apply more feedback?) is (Yes)
:Give feedback and edit;
|System|
:Apply edits to essay;
endwhile (No)
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