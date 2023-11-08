
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
participant " : DashUI " as DashUI
applicant-> DashUI : StartUI()
DashLogic -> Essay : edits
DashLogic -> DashUI : return
applicant <- DashUI : viewDashboard()
applicant <- DashUI : viewEssay()
DashUI-> DashLogic : update
Essay -> College : submitEssay()

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
+main()
+start()
+startUI()
}
DashLogic <|-- DashUI
College .> Essay
Essay .> College
DashUI .> Essay


```


