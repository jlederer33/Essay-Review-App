**DOMAIN MODEL:**

```plantuml
hide circle
hide empty methods
 
 class Applicant{
 username
 }
 
 class Essay{
 personalTags
 text
 }
 
 class supEssay{
 text
 }
 
 class College{
 collegeName
 }
 
 class appDashboard{
 }
 Applicant "1" - "1" appDashboard : \tViews\t
 appDashboard "1" -- "*" Essay : Contains\t\t
 supEssay "*" - "1" College : \tContains\t\t
 Essay "1" -- "*" supEssay : Inherits
 Applicant "1" -- "1" Essay : Edits
 

 

```