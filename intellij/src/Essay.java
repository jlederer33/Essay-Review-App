public abstract class Essay {
    private String title;
    private String text;

    public Essay(String title, String text){
        this.title = title;
        this.text = text;
    }

    public String getTitle(){
         return title;
    }
    public String getText(){
        return text;
    }

}
