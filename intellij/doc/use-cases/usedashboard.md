# Use Dashboard
**Primary Actor**
1. **Applicant:** Wants to view all colleges they are interested in. Wants easy to read UI. Does not want to be overwhelmed by dashboard 

**Other Stakeholders:**
1. **None:** 

**Preconditions:**
* Applicant is logged into app 

**Postconditions**
* System updates dasboard with colleges 


```plantuml
title Use Dashboard (Casual)


|#lightblue|Applicant|
|#pink|System|

|Applicant|
start
while(Searches colleges to add to dashboard) is (Adding more colleges)
:Add colleges to dashboard;
|System|
:Adds colleges to dashboard;
:Updates dashboard based on colleges added;
endwhile (No colleges to add)
|System|
:returns to dashboard;
stop



```