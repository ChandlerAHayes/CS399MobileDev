package educs399.nau.anagram;

/**
 * Created by Chandler on 10/14/2017.
 *
 * In a MVC concept, this the model of the anagram.
 */


public class Anagram {
    private int textResId;
    private String[] answer;

    //Constructor
    public Anagram(int textResId, String[] answer)
    {
        this.textResId = textResId;
        this.answer = answer;
    }

    //Getters & Setters for the TextID
    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    //Getters & Setters for the Answers
    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }
}
