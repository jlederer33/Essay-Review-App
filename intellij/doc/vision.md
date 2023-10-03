# Vison Doc:
**Target audience:** Students who are applying to US college.

**Value proposition:** The app will work like a checklist and allows applicants to have their essays be reviewed by people
who went through the process.

**Main feature and constraint:** It will have a dashboard that will allow people to leave review on the respective college.
The app will have a checklist with all the documents the college requires.It will also include an explore page that will show other people's post regarding College applications.
The reviewers need to verify that they have already been through the college application process by either through their active @collegename.edu and graduate students can verify through their old college transcript or any form of old college ID.
The app allows students to filter out colleges by location, deadline, application fee, if there is any essay requirement, standardized test policy and if they need a letter of recommendation.

**Stakeholder goals**
1. **Applicants:** The college students who are applying to college, and are using the app to edit their essays and view other peoples essays
2. **Reviewers:** Current/Former college students who review and give feedback for essays.

**Key Functionality:**
1. **The checklist:** where applicants can see what tasks they have completed and have remaining
2. **The dashboard:** the main menu where applicants can view colleges
3. **the forum:** where applicants can upload and view essays

**Business goals:**

**there is not many services that combine the checklist, and not
any services that provide college essay feedback.**
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



