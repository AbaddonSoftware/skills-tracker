package org.launchcode.skillstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SkillsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsTrackerApplication.class, args);
	}

}

@RestController
@ResponseBody
class SkillsTrackerController {
	List languages = Arrays.asList("6502 Assembler", "C", "C++", "C#", "Chip8", "Haxe", "Java", "JavaScript", "Python");

	@GetMapping("/")
	public String myFavoredLanguages() {
		int[] myChoices = {1, 2, 3};
		String header1 = "Skills Tracker";
		String header2 = "Best stuff right here";
		StringBuilder completeText = new StringBuilder();
		completeText.append("<h1>" + header1 + "</h1>\n" + "<h2>" + header2 + "<h2>\n<ol>");
		for (int choice : myChoices) {
			completeText.append("<li>" + languages.get(choice) + "</li>\n");
		}
		completeText.append("</ol>");
		return completeText.toString();
	}
}
