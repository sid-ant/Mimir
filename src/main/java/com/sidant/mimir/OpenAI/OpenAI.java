package com.sidant.mimir.OpenAI;

import com.sidant.mimir.OpenAI.Types.Choices;
import com.sidant.mimir.OpenAI.Types.TextCompletionRequest;
import com.sidant.mimir.OpenAI.Types.TextCompletionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class OpenAI {

    Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${openai.key}")
    private String authKey;


    public String sendTextPrompt(String prompt) {

        logger.info("sendTextPrompt start");
        String promptResponse = "Oops Error Occurred, it must be a trick by Odin!";


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization" , "Bearer "+authKey);

        TextCompletionRequest requestBody = new TextCompletionRequest(
                "text-davinci-003", prompt, 0.9, 100);

        HttpEntity<TextCompletionRequest> request = new HttpEntity<>(requestBody, headers);

        try {
            String resourceUrl = "https://api.openai.com/v1/completions";

            logger.info("url formed {}",resourceUrl);

            ResponseEntity<TextCompletionResponse> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.POST,
                    request,
                    TextCompletionResponse.class);

            TextCompletionResponse resp = response.getBody();

            assert resp != null;

            Choices[] choices = resp.getChoices();
            promptResponse = "GPT3 says: " + choices[0].getText();

            logger.info("sendTextPrompt resp {}",promptResponse);
            logger.info("sendTextPrompt status {}",response.getStatusCode());
        }  catch (Exception e) {
            logger.error("Error in sendTextPrompt {}", e.getMessage());
        }

        logger.info("sendTextPrompt end");
        return promptResponse;
    }


}
