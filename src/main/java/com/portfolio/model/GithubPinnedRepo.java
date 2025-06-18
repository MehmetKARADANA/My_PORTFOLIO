package com.portfolio.model;

public class GithubPinnedRepo {
    private String name;
    private String description;
    private int stargazerCount;
    private String url;
    private String languageName;
    private String languageColor;

    public GithubPinnedRepo(String name, String description, int stargazerCount, String url, String languageName, String languageColor) {
        this.name = name;
        this.description = description;
        this.stargazerCount = stargazerCount;
        this.url = url;
        this.languageName = languageName;
        this.languageColor = languageColor;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getStargazerCount() { return stargazerCount; }
    public String getUrl() { return url; }
    public String getLanguageName() { return languageName; }
    public String getLanguageColor() { return languageColor; }
} 