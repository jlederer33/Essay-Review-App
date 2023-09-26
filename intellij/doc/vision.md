# Vison Doc:
**Introduction:** Our app will act as a checklist for students applying to college.They will be able to personally track what documents they have completed. There will also be a forum for them to share their essays with dedicated editors

**Target audience:** Students who are applying to US college.

**Value proposition:** The app will work like a checklist and allows to be reviewed by people
who went through the process.

**Main feature and constraint:** It will have a spreadsheet that will allow people to leave review on the respective college.
The app will have a dashboard with college wise checklist.It will also include an explore page that will show other people's post regarding College applications.
The reviewers need to verify that they have already been through the college application process by either through their active @collegename.edu and graduate students can verify through their old college transcript or any form of old college ID.
The app allows students to filter out colleges by location, deadline, application fee, if there is any essay requirement, standardized test policy and if they need a letter of recommendation.

**Actors:**
1. **Applicants:** The college students who are applying to college, and are using the app to edit their essays and view other peoples essays
2. **Reviewers:** Current/Former college students who review and give feedback for essays.
3. **College Checklist/Reviewer:** The app that applicants and reviewers will use to edit and view essays. Both will be able to view a "spreadsheet" dashboard that has all favorited colleges, and a personal checklist so people can mark what essays they are finished with.

```plantuml

actor "Applicant" as applicant
actor "Reviewer" as reviewer


package "College Checklist/Reviewer" {
    usecase "review essays" as revEssay
    usecase "upload essays" as upEssay
    usecase "use checklist" as useChecklist
    usecase "use dashboard" as useDashboard
}

applicant --> revEssay
applicant --> upEssay
applicant --> useDashboard  
applicant --> useChecklist
reviewer --> revEssay

````



