# Phase 1:

**useChecklist**

Criticality: Helps the applicant to be  organised and prepare everything they need for college application.

Risk: Too much information at once.

Coverage: Will be heavily used for dashboard.

Rank: Low

**reviewEssays**

Criticality: Proof reads the applicant's essays

Risk: it will be hard to implement this code wise. 

Coverage: Not many other part of the app will have to interact with review essay.

Rank: Medium

**uploadEssays**

Criticality: Helps the applicant to post their essay online or save it as a draft.

Risk: either save it on central database or server leading to more complexities to infrastructure.

Coverage: Review essay and dashboard will use it.

Rank: Medium

**useDashboard**

Criticality: to look up colleges and add it to the dashboard.

Risk: too much information at once.

Coverage: It will be used by the dashboard.

Rank: High

# Phase 2:

**useChecklist**
Criticality: Helps the applicant to be  organised and prepare everything they need for college application.

Risk: Too much information at once.

Coverage: Will be heavily used for dashboard.

Rank: Low

**reviewEssays**

Criticality: Proof reads the applicant's essays

Risk: it will be hard to implement this code wise.

Coverage: Not many other part of the app will have to interact with review essay.

Rank: High

**displayEssays**

Criticality: displays the essays in separate dashboard from the colleges

Risk: Similar to useChecklist, it will be easy for this to clog the UI

Coverage: Both the applicantDashboard and reviewerDashboard will use this

rank: High


# PHASE 3:

**reviewEssays**

Criticality: Proof reads the applicant's essays. In all honesty, this is perhaps one of the most vital parts of the app
in terms of user functionality, and will be a priority to implement for the next phase.

Risk: It will be hard to implement this code wise. Moreover, it will have to work with the essays dashboard to provide a clear
view of the applicants essays, as well as any edits they receive

Coverage: Not many other part of the app will have to interact with review essay, that said,
this functionality will reuse the view code from the others.

Rank: High

**prepareApplication**

Criticality: Helps the applicant to be  organised and prepare everything they need for college application.
While having this functionality would be good for user organization, in all honesty we can omit this functionality in order to get reviewEssay implemented

Risk: Too much information at once.

Coverage: Will need to be accessed by the Essays dashboard and the checklist.

Rank: Medium



