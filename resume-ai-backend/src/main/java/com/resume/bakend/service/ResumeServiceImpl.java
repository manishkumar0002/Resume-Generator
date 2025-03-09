package com.resume.bakend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
@Component
public class ResumeServiceImpl implements ResumeService {

    private ChatClient chatClient;

    public  ResumeServiceImpl(ChatClient.Builder builder){
        this.chatClient=builder.build();

    }
    @Override
    public String generateResumeResponse(String userResumeDescription) throws IOException {


        String promptString = this.loadPromptFromFile("resume_prompt.txt");
        String promptContent = this.putValuesToTemplateString(promptString, Map.of(
               "userDescription",userResumeDescription

        ));

        Prompt prompt=new Prompt(userResumeDescription);

        String response = chatClient.prompt(prompt).call().content();

        //modify:
        return "";
    }

    String loadPromptFromFile(String filename)throws IOException{
        Path path = new ClassPathResource(filename).getFile().toPath();
        return Files.readString(path);
    }
    String putValuesToTemplateString(String template, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            template = template.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return template;
    }


}
