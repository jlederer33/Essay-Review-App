
**Adding Colleges:**

```plantuml
actor Applicant as applicant
participant " : IMainMenuView " as IMainMenuView
Controller -> CollegeLibrary : edit
CollegeLibrary <- College : addCollege()
applicant -> IMainMenuView : StartUI()
applicant <- IMainMenuView : viewDashboard()
IMainMenuView-> controller : informs

```
**Removing Colleges:**

```plantuml
actor Applicant as applicant
participant " : IMainMenuView " as IMainMenuView
Controller -> CollegeLibrary : edit
CollegeLibrary <- College : removeCollege()
applicant -> IMainMenuView : StartUI()
applicant <- IMainMenuView : viewDashboard()
IMainMenuView-> CONTROLLER : informs


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
participant " : IMainMenuView " as IMainMenuView
applicant-> IMainMenuView : StartUI()
Controller -> Essay : edits
Controller -> IMainMenuView : return
applicant <- IMainMenuView : viewDashboard()
applicant <- IMainMenuView : viewEssay()
IMainMenuView-> Controller : update
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

class IEssayView{
...
--
+getEssay()
}


class CollegeLibrary{
...
--
+getCollege()
}
CollegeLibrary <. College


class Controller{
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
class IMainMenuView{
...
--
+main()
+start()
+viewDashboard()
+startUI()
}
Controller <-- IMainMenuView
Essay .> College
IMainMenuView .> Essay
College *- "(0..*)\nColleges" CollegeLibrary : \t\t
Essay *- "(0..*)\nEssays" College: \t\t

```


