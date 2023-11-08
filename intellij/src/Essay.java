public abstract class Essay {
    /*
    Abstract class representing an essay. The two essay sub-types are personal essay and supplement essay
     */
    private String title;
    private String text;

    public Essay(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        {//returns the title of an essay
            return title;
        }


    }
}
