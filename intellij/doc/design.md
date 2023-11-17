
**Adding Colleges:**

```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
DashLogic -> CollegeLibrary : edit
CollegeLibrary <- College : addCollege()
applicant -> DashUI : StartUI()
applicant <- DashUI : viewDashboard()
DashUI-> DashLogic : informs

```
**Removing Colleges:**

```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
DashLogic -> CollegeLibrary : edit
CollegeLibrary <- College : removeCollege()
applicant -> DashUI : StartUI()
applicant <- DashUI : viewDashboard()
DashUI-> DashLogic : informs


```
**Editing and Uploading Essays:**

```plantuml
actor Applicant as applicant

applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
Controller -> IEssaysView : onEssaysClicked()
Controller <- IMenuView : onEssaysClicked()
Controller -> IMenuView: onBack()
IEssaysView <- Dashboards : addToEssaysList()
Dashboards <- Essays : addToEssaysList()
IEssaysView -> Controller : onBack()
```
**Delete Essays:**

```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
applicant-> DashUI : StartUI()
DashLogic -> Essay : edits
DashLogic -> DashUI : return
applicant <- DashUI : viewDashboard()
applicant <- DashUI : viewEssay()
DashUI-> DashLogic : update
Essay -> College : deleteEssay()

```
**Class Diagram:**

```plantuml

class Essay{
title
text
type
...
--
+getTitle()
+text()
+personalTags()
+text()
}



class CollegeLibrary{
...
--
+getCollege()
}
CollegeLibrary <. College


class DashLogic{
...
--
+addCollege((String collegeName)
+removeCollege(String collegeName)
+submitEssay(String title, String content, String essayType, String collegeName)
+deleteEssay(String collegeName, String essayType)
+viewEssay(String collegeName, String essayType)
}
class College{
...
--
+collegeName
}
class DashUI{
...
--
+main()
+start()
+viewDashboard()
+startUI()
}
DashLogic <-- DashUI
Essay .> College
DashUI .> Essay
College *- "(0..*)\nColleges" CollegeLibrary : \t\t
Essay *- "(0..*)\nEssays" College: \t\t

```


