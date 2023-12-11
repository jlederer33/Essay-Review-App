
**Uploading Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment()
applicant <- IMainView : displays
Controller <- IEssaysView : onEssaysClicked()
Controller <- IEssaysView : submitEssayClicked( title,text, type, view)
Controller <- IMenuView : onEssaysClicked()
IEssaysView <- Dashboards : addToUserEssayList(title,text,type)
IEssaysView -> Dashboards : onSubmitEssayClicked(title,text, type, view)
Dashboards -> IEssaysView : updatesView()
Dashboards -> Essays : addToUserEssayList(title,text,type)
```
**Delete Essays:**

```plantuml
actor Applicant as applicant
applicant-> IMainView : views
IMainView -> IMenuView : displayFragment(fragment, reversible, name)
applicant <- IMainView : displays
IEssaysView -> Controller : onEssaysClicked(essay)
IEssaysView -> IMenuView : onEssaysClicked(essay)
IEssaysView <- Dashboards : removeFromEssaysList(essay)
Dashboards -> Essays : removeFromEssaysList(essay)

```

**Adding Reviews**
```plantuml
actor Reviewer as reviewer
reviewer-> IMainView : views
IMainView -> IMenuView : displayFragment()
reviewer <- IMainView : displays
Controller <- IReviewerView : onReviewsClicked()
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
+numOfReviews()
+addReview()
}


class Dashboard{
essayList<Essay>
allEssaysList<Essay>
--
+addToUserEssayList(title,text, type)
+removeFromEssayList(int position)
+submitToAllEssays(essay)
}

interface IPersistenceFacade{
__
+saveUserEssay(@NonNull Essay Essay);
+saveAllEssay(Essay essay);
+removeUserEssay(Essay essay);
}

class PersistenceFacade{}

class Controller{
IMainView mainView
IPersistenceFacade persFacade
--
+onEssaysClicked()
+onAllEssaysClicked()
+onSubmitEssayClicked(title,text.type, View)
+onDeleteEssayClicked(essay, view)
+onUserEssayClicked(essay)
+onAddReviewClicked(essay) 
+onSelectedReviewClicked(essay, review)
+onSubmitReviewClicked(essay, title, text)
+backToSelectedEssay(essay)
+onBack()

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
+displayFragment(fragment,reversible, name)
}

Class MainView{
...
--
+getRootView()
+displayFragment(fragment,reversible, name)
}



package "view" as View{
}


Controller <-- MainView
View --> MainView
IMainView <|-- MainView
IPersistenceFacade <|-- PersistenceFacade
Controller <-- Dashboard
Controller <-- PersistenceFacade

Dashboard *- "(0..*)\nEssays" Essay: \t\t
Essay *- "(0..*)\nReviews" Review: \t\t
IMainView *- "mainView(1 - 1)\n" Controller : \t\t\t
IPersistenceFacade *-- "persistenceFacade(1 - 1)\n" Controller : \t\t\t

```
**View diagrams:**

```plantuml

interface IMenuView{
...
+onUserEssaysClicked()
+onAllEssaysClicked()
}

interface ISelectedReviewView{
...
--
+backToSelectedEssay()
}
interface IUserEssaysView{
...
--
+onBack()
+onSubmitEssayClicked()
+onDeleteEssayClicked()
+onEssayClicked()
+updateEssaysDisplay()
}

interface IAllEssaysView{
...
--
+onBack()
+onEssayClicked()
}

interface IAddReviewsView{
...
+onSubmitReviewClicked()
}

interface ISelectedEssayView{
...
--
+onUserEssaysClicked()
+onAllEssaysClicked()
+onAddReviewClicked()
+onSubmitToAllEssaysClicked()
+onSelectReviewClicked()
}

interface IMenuView.Listener{

}

interface IAllEssaysView.Listener{
}

interface IAddReviewsView.Listener{

}

interface ISelectedEssayView.Listener{

}

interface ISelectedReviewView.Listener{

}

interface IUserEssaysView.Listener{

}
class MainMenuFragment {}
class SelectedReviewFragment {}
class AddReviewsFragment {}
class SelectedUserFragment{}


IMenuView <|-- MainMenuFragment
IMenuView.Listener <-- IMenuView
ISelectedEssayView.Listener <-- ISelectedEssayView
ISelectedEssayView <|-- SelectedUserFragment
ISelectedReviewView.Listener <-- ISelectedReviewView
ISelectedReviewView <|-- SelectedReviewFragment
IAddReviewsView.Listener <|-- IAddReviewsView
IAddReviewsView <|-- AddReviewsFragment
IUserEssaysView.Listener <|-- IUserEssaysView
IUserEssaysView <|-- UserEssaysFragment
IAllEssaysView.Listener <|-- IAllEssaysView
IAllEssaysView <|-- AllEssaysFragment








```


