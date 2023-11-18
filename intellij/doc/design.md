
**Adding Colleges:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
IMenuView -> Controller : onCollegesClicked()
Controller -> ICollegeView: displayFragment()
Controller -> ICollegeView: onAddClicked()
ICollegeView -> Controller : updateView()
Dashboards-> College : addCollege()
Dashboards -> ICollegeView: addCollege() 

```
**Removing Colleges:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
IMenuView -> Controller : onCollegesClicked()
Controller -> ICollegeView: displayFragment()
Controller -> ICollegeView: onRemoveClicked()
ICollegeView -> Controller : updateView()
Dashboards-> College : removeCollege()
Dashboards -> ICollegeView: removeCollege() 





```
**Editing and Uploading Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
Controller -> IEssaysView : onEssaysClicked()
Controller -> IEssaysView : submitEssayClicked()
Controller <- IMenuView : onEssaysClicked()
IEssaysView <- Dashboards : addToEssaysList()
IEssaysView -> Dashboards : onSubmitEssayClicked()
Dashboards -> IEssaysView : updatesView()
Dashboards <- Essays : addToEssaysList()
```
**Delete Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
Controller -> IEssaysView : onEssaysClicked()
Controller <- IMenuView : onEssaysClicked()
IEssaysView <- Dashboards : removeFromEssaysList()
Dashboards -> Essays : removeFromEssaysList()

```

**Adding and Editing Reviews**
```plantuml
actor Reviewer as reviewer
reviewer-> IMainView : views
IMainView -> IMenuView : displayFragment()
reviewer <- IMainView : displays
Controller -> IReviewerView : onReviewsClicked()
Controller <- IReviewerView : updateView()
IReviewerView -> Dashboards : onEditReviews()  
Dashboards -> Essays : onEditReviews() 
Controller <- IMenuView : onReviewsClicked()
Controller -> IMenuView: onBack()
IReviewerView -> Dashboards : addReviewsToEssay()
Dashboards -> Essays : addReviewsToEssay()

```
**Class Diagram:**

```plantuml

class Essay{
String title
String text
String type
reviewList<Review>
...
--
+getTitle()
+getText()
+getType()
+seeReviews()
}


class Dashboard{
essayList<Essay>
collegeList<College>
reviewerEssayList<Essay>
--
+addToEssayList(String title, String text, String type)
+removeFromEssayList(int position)
+addToCollegeList(String name)
+removeCollegeFromList(int position)
+addReview()
+deleteReview()
+editReview
}

class Controller{
IMainView mainView
--
+onEssaysClicked()
+onCollegesClicked()
+onReviewsClicked()
+onBack()

}
class College{
essaysInCollegeList<Essay>
String collegeName
int numOfReviews
--
+getCollegeName()
+getNumOfReviews
+addEssayToCollege(Essay essay)
+removeEssayFromCollege(Essay essay)
}

class Review extends Essay{
}

Interface IMainView{
...
--
+getRootView()
+displayFragment(Fragment fragment, boolean reversible, String name)
}

Class MainView{
...
--
...
}



package "view" as View{
}


Controller <-- MainView
View --> MainView
IMainView <|-- MainView
College <. Essay
Controller <-- Dashboard
Dashboard <. College

College *- "(0..*)\nColleges" Dashboard : \t\t
Essay *- "(0..*)\nEssays" Dashboard: \t\t

```
**View diagrams:**

```plantuml

interface IMenuView{
...
+onEssaysClicked()
+onCollegesClicked()
+onReviewerClicked()
}

interface IEssayView{
...
+onBack()
+onSubmitEssayClicked()
+onDeleteEssayClicked()
}

interface ICollegeView{
...
+onBack()
+onAddCollegesClicked()
+onRemoveCollegesClicked()
+onAddEssayToCollege()
+onRemoveEssayToCollege()
}

interface IReviewerView{
...
+onBack()
+onAddReview()
+onRemoveReview()
}

class EssayDashboardFragment {}
class MenuDashboardFragment {}
class CollegeDashboardFragment {}
class ReviewerDashboardFragment {}

IEssayView <|-- EssayDashboardFragment
IMenuView <|-- MenuDashboardFragment
ICollegeView <|-- CollegeDashboardFragment
IReviewerView <|-- ReviewerDashboardFragment

```


