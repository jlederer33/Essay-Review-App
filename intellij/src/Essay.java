public abstract class Essay {
    /*
    Abstract class representing an essay. The two essay sub-types are personal essay and supplement essay
     */
    private String title;
    private String text;

    public Essay(String title, String text){
        this.title = title;
        this.text = text;
    }

<<<<<<< HEAD
    public String getTitle(){
         return title;
    }
    public String getText(){
=======
    public String getTitle() {//returns the title of an essay
        return title;
    }
    public String getText() {//returns the text of an essay
>>>>>>> 1822f511cba1b3dc716294739dc2efd2f591c884
        return text;
    }

}
