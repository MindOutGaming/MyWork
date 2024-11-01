/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forexample;

/**
 *
 * @author sohel1
 */
public class AbstractExample2 {
    public static void main(String[] args) {        
        // Android Developer
        Button btn = new Button();
        btn.setText("I am a button");
        // click => You have clicked the button
        ClickHandler clickHandler = new ClickHandler();
        btn.addListener(clickHandler);
        // suppose user click kiya.
        btn.whenTouch();  
    }
}
class ClickHandler extends ClickListener {
    @Override
    public void onClick() {
        System.out.println("You have clicked the button");
    }
}
// android SDK developer
class Button {
    String text;
    ClickListener listener;
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
    public void addListener(ClickListener devListener) {
        this.listener = devListener;
    }
    // os developer
    public void whenTouch() {
        listener.onClick();
    }
}
abstract class ClickListener {
    public abstract void onClick(); // definition would be by Developer.
}