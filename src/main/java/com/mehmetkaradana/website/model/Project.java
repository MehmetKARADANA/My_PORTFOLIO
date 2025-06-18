package com.mehmetkaradana.website.model;

public class Project {
    private String title;
    private String description;
    private String techStack;
    private String githubUrl;

    public Project(String title, String description, String techStack, String githubUrl) {
        this.title = title;
        this.description = description;
        this.techStack = techStack;
        this.githubUrl = githubUrl;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTechStack() {
        return techStack;
    }

    public String getGithubUrl() {
        return githubUrl;
    }
} 