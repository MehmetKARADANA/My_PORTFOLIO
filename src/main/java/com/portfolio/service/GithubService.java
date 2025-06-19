package com.portfolio.service;

import com.portfolio.model.GithubPinnedRepo;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubService {
    private static final String GITHUB_API_URL = "https://api.github.com/graphql";
    private static final String GITHUB_TOKEN = "YOUR_GITHUB_TOKEN_HERE";

    public List<GithubPinnedRepo> getPinnedRepos(String username) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(GITHUB_TOKEN);

        String graphqlQuery = """
        {\n  user(login: \"" + username + "\") {\n    pinnedItems(first: 6, types: REPOSITORY) {\n      nodes {\n        ... on Repository {\n          name\n          description\n          url\n          stargazerCount\n          primaryLanguage {\n            name\n            color\n          }\n        }\n      }\n    }\n  }\n}\n""";

        JSONObject body = new JSONObject();
        body.put("query", graphqlQuery);

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(GITHUB_API_URL, HttpMethod.POST, entity, String.class);

        List<GithubPinnedRepo> repos = new ArrayList<>();
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject data = new JSONObject(response.getBody()).getJSONObject("data");
            JSONObject user = data.getJSONObject("user");
            JSONArray nodes = user.getJSONObject("pinnedItems").getJSONArray("nodes");
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject repo = nodes.getJSONObject(i);
                String name = repo.getString("name");
                String description = repo.optString("description", "");
                int stargazerCount = repo.getInt("stargazerCount");
                String url = repo.getString("url");
                String languageName = "";
                String languageColor = "#888";
                if (!repo.isNull("primaryLanguage")) {
                    JSONObject lang = repo.getJSONObject("primaryLanguage");
                    languageName = lang.optString("name", "");
                    languageColor = lang.optString("color", "#888");
                }
                repos.add(new GithubPinnedRepo(name, description, stargazerCount, url, languageName, languageColor));
            }
        }
        return repos;
    }
} 