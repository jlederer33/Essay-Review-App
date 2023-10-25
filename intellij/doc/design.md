
**Adding and Removing Colleges:**

```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
DashLogic -> College : edit
applicant-> DashUI : input
DashUI ->  applicant : display
DashUI-> DashLogic : informs
DashLogic-> DashUI : add college
DashLogic-> DashUI : remove college


```
**Editing and Uploading Essays:**

```plantuml
actor Applicant as applicant
participant " : DashUI " as DashUI
applicant-> DashUI : view
DashLogic -> Essay : updates
DashLogic -> Essay : edits
Essay -> DashLogic : returns
DashLogic -> DashUI : return
DashUI-> DashLogic : update

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


