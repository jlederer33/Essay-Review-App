# Use Checklist:
**Primary Actor**
1. **Applicant:** wants to view remainging and completed tasks. Wants to be able to manually check tasks off 

**Other Stakeholders:**
1. **None**

**Preconditions:**
* Applicant has accessed college dashboard

**Postconditions**
* System updates checklist with completed tasks

```plantuml
|#lightblue|Applicant|
|#pink|System|

|System|
start
:Display checklist;
|Applicant|
:Your list of college;
|System|
while (Personal essay) is (Yes)
|Applicant|
:draft;
|System|
endwhile(no)
while (supplement essay) is (Yes)
|Applicant|
:draft;
|System|
endwhile(no)
while (other materials like SAT score, letter of rec.) is (Yes)
|Applicant|
:make another list of college from your first list that requires these;
|System|
endwhile(no)
:more tasks;
:stop;





```

```plantuml
title Use Checklist (Brief)
start
:check College requirements;
:check if requires personal and/or supplement essays;
:check if requires other material (Standard test, letters of recommendation);
:check if FAFSA, CSS and/or anything else needed to be submitted(based on citizenship for financial aid) is done;
stop
```
