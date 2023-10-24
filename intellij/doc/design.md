**DOMAIN MODEL:**

```plantuml
hide circle
hide empty methods
 
 class DashUI{
 username
 }
 
 
 class DashLogic{
 }
 
 class DashController{
 }
 
 class Essay{
 personalTags
 text
 }
 
 class supplementEssay{
 text
 }
 
 class College{
 collegeName
 }
 
 class personalEssay{
 text
 }
 
 DashUI "1" - "1" DashLogic : Contains\t\t
 DashUI "1" - "1" DashController : Contains\t\t
 DashController "1" - "1" DashLogic : Contains\t\t
  DashUI "1" -- "*" College : Contains
  College "1" -- "*" Essay : Contains
 Essay "1" -- "*" supplementEssay : Inherits
  Essay "1" -- "*" personalEssay : Inherits


 

```

```plantuml
actor Applicant as applicant
participant " : appDashboard " as appDashboard
applicant-> appDashboard : view
appDashboard-> applicant : Display Colleges
appDashboard-> Essay : view
appDashboard-> Essay : edit
appDashboard-> Essay : upload


```
```plantuml
actor Applicant as applicant
participant " : DashView " as DashView
applicant-> DashView : view
DashView-> applicant : display
DashView-> DashController : shift
DashController-> DashLogic : shift
DashLogic-> DashController : edit
DashLogic-> DashController : review
DashLogic-> DashController : view






```
```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
DashController -> College : edit
applicant-> DashUI : input
DashUI ->  applicant : display
DashUI-> DashController : informs
DashController-> DashUI : add college
DashController-> DashUI : remove college


```
```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
applicant-> DashUI : view
DashController -> Essay : updates
DashController -> Essay : edits
Essay -> DashController : returns
DashController-> DashUI : return
DashUI-> DashController : update

```
```plantuml

class Essay{
title
text
...
--
+getTitle()
+text()
+personalTags()
+text()
}

class supplementEssay{
title
text
...
--
+collegeName()
+text()
}

class personalEssay{
title
text
...
--
+getTitle()
+getText()
}
Essay <|--  supplementEssay
Essay <|-- personalEssay

class DashController{
...
--
+main()
}

class DashLogic{
...
--
+addCollege()
+removeCollege()
+viewDashboard()
+submitEssay()
+deleteEssay()
}
class College{
...
--
+collegeName
}
class DashUI{
...
--
+start()
+startUI()
}
DashUI <|--  DashController
DashUI <|-- DashLogic
College .> Essay
Essay .> College
DashUI .> Essay


```


