# Upload Essays:
**Primary Actor**
1. **Applicant:** wants to upload essay to app. Wants option to save as draft in case of incompletion

**Other Stakeholders:**
1. **Reviewer:** Want system to display essay after its uploaded

**Preconditions:**
* Applicant has not completed essays in checklist, or wants to submit more

**Postconditions**
* Essay is saved in app
* Essay is uploaded to respective forum

````plantuml

title Upload Essay (Fully Dressed)
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
|Applicant|
while (More edits to add?) is (Yes)
:Adds feedback/personal edits;
|System|
:Essay is updated with edits;
endwhile (No)
:Essay is saved;
stop
else (No)
|Applicant|
if (Save as draft?) then (Yes)
|System|
:Draft is saved;
stop
else (No) 
|System|
:Draft is deleted;
|System|
stop
````
