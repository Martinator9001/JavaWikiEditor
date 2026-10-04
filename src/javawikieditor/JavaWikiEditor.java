/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javawikieditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kosta
 */
public class JavaWikiEditor {
        public static String templatePage = """
{{Template:Objectives
|title=
|image=
|caption=

|Type=

|In Universe=

|In=
|During Objective=

|Reward=

|Name=
|ID=

|Planets=In; From; To
|Items=During Objective; Reward
|Internal Info=Name; ID
}}
== Objective ==

== Description ==

== Hints ==

== Guide ==
== Reward ==

== Gallery ==

----
== History ==
* Version [[1.0]]:
** Introduced
""";                                                                             
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner inp = new Scanner(new File("C:\\Users\\kosta\\Downloads\\objectives.md"));
        PrintWriter pageWriter = new PrintWriter(new FileWriter("pages.txt", false));
        while (inp.hasNextLine())
        {
            String titleString = inp.nextLine();

            if(titleString.startsWith("MISSION_NAME:"))
            {
                String title = inp.nextLine();
                inp.nextLine();
                String availableItems = inp.nextLine();
                inp.nextLine();
                String rewards = inp.nextLine();
                StringBuilder page = new StringBuilder("{{-start-}}\n");
                page.append(templatePage);
                page.insert(page.indexOf("|title=")+"|title=".length(), "'''"+title+"'''");
                page.insert(page.indexOf("|During Objective=")+"|During Objective=".length(), availableItems);
                page.insert(page.indexOf("|Reward=")+"|Reward=".length(), rewards);
                page.insert(page.indexOf("== Reward ==")+"== Reward ==".length()+1, rewards.replaceAll("<\br>", "\n"));
                page.append("{{-stop-}}\n\n");
                
                //System.out.println(new wikiContent(title, availableItems, rewards).toString());
                pageWriter.append(page.toString());
            }
        }
        Scanner missionsInp = new Scanner(new File("C:\\Users\\kosta\\Downloads\\neshto.txt"));
        missionsInp.useDelimiter(";");
        List<missionInfo> missionInfoList = new ArrayList<>();
        while (missionsInp.hasNextLine())
        {
           //System.out.println("DO");
           
           missionsInp.next();
           String title= missionsInp.next();
           missionsInp.nextLine();

           missionsInp.next();
           String obj= missionsInp.next();
           missionsInp.nextLine();
           
           missionsInp.next();
           String desc= missionsInp.next();
           missionsInp.nextLine();

           missionsInp.next();
           String hints= missionsInp.next();
           missionsInp.nextLine();
          
           missionInfoList.add(new missionInfo(title, obj, desc.toString(), hints));
        }
        for(missionInfo m: missionInfoList)
        {
            //System.out.println(m.toString());
        }
        pageWriter.flush();
        Scanner pagesInp = new Scanner(new File("pages.txt"));
        String pageTitle = "";
        while(pagesInp.hasNextLine())
        {
            String checkLine = pagesInp.nextLine();
            System.out.println(checkLine);
            if(checkLine.contains("|title="))
            {
                pageTitle=checkLine.substring(10, checkLine.length()-3);
            }
            for(missionInfo m: missionInfoList)
            {
                if(m.getTitle().equals(pageTitle))
                {
                    //permaM = m;
                    //System.out.println("HIT");
                if(checkLine.contains("== Objective =="))
                {
                    //System.out.println("HIT2");
                    System.out.println(m.getObj());
                }
                else if(checkLine.contains("== Description =="))
                {
                    System.out.println(m.getDesc());
                }
                else if(checkLine.contains("== Hints =="))
                {
                    System.out.println(m.getHints());
                }
                }
                
            }

        }
        missionsInp.close();
        inp.close();
        
    }
    
    
}
    