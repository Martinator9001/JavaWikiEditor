/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javawikieditor;

/**
 *
 * @author kosta
 */
public class wikiContent {
    private String title;
    private String availableItems;
    private String rewards;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(String availableItems) {
        this.availableItems = availableItems;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public wikiContent(String title, String availableItems, String rewards) {
        this.title = title;
        this.availableItems = availableItems;
        this.rewards = rewards;
    }
    @Override
    public String toString()
    {
        return "["+title+"\n"+availableItems+"\n"+rewards+"]";
    }
}
