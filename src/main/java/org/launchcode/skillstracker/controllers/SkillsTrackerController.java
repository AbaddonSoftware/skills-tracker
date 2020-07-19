package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class SkillsTrackerController {
    List languages = Arrays.asList("6502 Assembler", "C", "C++", "C#", "Chip8", "Haxe", "Java", "JavaScript", "Python");

    @GetMapping("/")
    public String myFavoredLanguages() {
        int[] myChoices = {1, 2, 3};
        String header1 = "Skills Tracker";
        String header2 = "Best stuff right here";
        StringBuilder completeText = new StringBuilder();
        completeText.append("<h1>" +header1+ "</h1>\n" +"<h2>" +header2+ "<h2>\n<ol>");
        for  (int choice : myChoices){
            completeText.append("<li>" + languages.get(choice) + "</li>\n");
        }
        completeText.append("</ol>");
        return completeText.toString();
    }



    @GetMapping("form")
    public String aForm() {
        return "<form action='form' method='post'>" +
                "<input type='text' name = 'usersName'>" +
                "<input type='submit' value='test'>";
    }

    @PostMapping("form")
    public String testForm(@RequestParam String usersName, String selectionOne, String selectionTwo, String selectionThree) {
        return usersName;
    }
}
