/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javawikieditor;

/**
 *
 * @author kosta
 */
public class missionInfo {
    private String title;
    private String obj;
    private String desc;
    private String hints;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public missionInfo(String title, String obj, String desc, String hints) {
        this.title = title;
        this.obj = obj;
        this.desc = desc;
        this.hints = hints;
    }
    
    public String toString()
    {
        return "Title: "+title+"\nObjective: "+obj+"\nDesc: "+desc+"\nHints: "+hints+"\n\n";
    }
}
