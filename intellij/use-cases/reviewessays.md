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
title Review and Edit (Brief)

|#palegreen|Reviewer|
|#pink|System|

|Reviewer|
start
:Search for essays on college forum;
|System|
:Displays essays based on search criteria
(college,keyword,etc);
|Reviewer|
:Edit essay and give feedback;
|System|
:Adds feedback;
stop
```