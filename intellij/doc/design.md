
**Editing and Uploading Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
Controller -> IEssaysView : onEssaysClicked()
Controller -> IEssaysView : submitEssayClicked( title,text, type, view)
Controller <- IMenuView : onEssaysClicked()
IEssaysView <- Dashboards : addToUserEssayList(title,text,type)
IEssaysView -> Dashboards : onSubmitEssayClicked(title,text, type, view)
Dashboards -> IEssaysView : updatesView()
Dashboards <- Essays : addToUserEssayList(title,text,type)
```
**Delete Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment(fragment, reversible, name)
applicant <- IMainView : displays
Controller -> IEssaysView : onEssaysClicked(essay)
Controller <- IMenuView : onEssaysClicked(essay)
IEssaysView <- Dashboards : removeFromEssaysList(essay)
Dashboards -> Essays : removeFromEssaysList(essay)

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
int date
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
allEssaysList<Essay>
--
+addToEssayList(String title, String text, String type)
+removeFromEssayList(int position)
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
class allEssaysList{
String collegeName
int numOfReviews
--
+getCollegeName()
+getNumOfReviews
+addEssayToCollege(Essay essay)
+removeEssayFromCollege(Essay essay)
}

class Review{
string Title
string Text
--

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
Controller <-- Dashboard

Dashboard *- "(0..*)\nEssays" Essay: \t\t
IMainView *- "mainView(1 - 1)\nColleges" Controller : \t\t\t


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

interface IEssayView.Listener{

}
interface IMenuView.Listener{

}

interface ICollegeView.Listener{
}

interface IReviewerView.Listener{

}
class EssayDashboardFragment {}
class MenuDashboardFragment {}
class CollegeDashboardFragment {}
class ReviewerDashboardFragment {}

IEssayView <|-- EssayDashboardFragment
IMenuView <|-- MenuDashboardFragment
ICollegeView <|-- CollegeDashboardFragment
IReviewerView <|-- ReviewerDashboardFragment
IEssayView.Listener <-- IEssayView
IMenuView.Listener <-- IMenuView
ICollegeView.Listener <-- ICollegeView
IReviewerView.Listener <-- IReviewerView




```


