package com.analyser.resumeanalyzer.service.analysersupport;

import java.util.Arrays;
import java.util.List;

public class SkillLibrary {
    public static List<String> getMasterSkillList() {
        return Arrays.asList(
            // Programming Languages
            "java", "python", "javascript", "typescript", "c", "c++", "c#", "go", "ruby", "php", "kotlin", "scala", "swift", "r", "dart", "bash", "shell",

            // Frontend
            "html", "css", "javascript", "react", "angular", "vue", "svelte", "next.js", "nuxt.js", "bootstrap", "tailwind css", "jquery",

            // Backend Frameworks
            "spring", "spring boot", "hibernate", "struts", "express", "django", "flask", "laravel", "ruby on rails", "asp.net", "nestjs", "fastapi",

            // Databases
            "mysql", "postgresql", "sql", "mongodb", "oracle", "mariadb", "cassandra", "redis", "elasticsearch", "sqlite", "dynamodb", "neo4j",

            // DevOps & CI/CD
            "docker", "kubernetes", "k87", "jenkins", "gitlab ci", "github actions", "travis ci", "circleci", "terraform", "ansible", "helm", "prometheus", "grafana",

            // Cloud Platforms
            "aws", "azure", "google cloud", "gcp", "ibm cloud", "oracle cloud", "digitalocean", "cloudflare", "heroku", "netlify", "vercel",

            // Version Control
            "git", "github", "bitbucket", "svn", "gitlab",

            // Testing
            "junit", "testng", "selenium", "cypress", "jest", "mocha", "chai", "pytest", "robot framework", "postman", "soapui",

            // Build Tools
            "maven", "gradle", "npm", "yarn", "webpack", "vite", "gulp", "grunt",

            // API
            "rest", "rest api", "graphql", "soap",

            // Container & Orchestration
            "docker", "kubernetes", "k8s", "k87", "openshift", "podman", "minikube",

            // Monitoring & Logging
            "prometheus", "grafana", "elk stack", "logstash", "kibana", "datadog", "splunk", "new relic",

            // Message Brokers & Streaming
            "kafka", "rabbitmq", "active mq", "apache pulsar", "mqtt",

            // Other Tools & Skills
            "jira", "confluence", "slack", "notion", "airflow", "hadoop", "spark", "hive", "tableau", "power bi", "matplotlib", "pandas", "numpy", "opencv", "tensorflow", "pytorch", "mlflow", "scikit-learn", "hugging face", "llm", "chatgpt", "langchain",

            // OS & Environment
            "linux", "ubuntu", "windows", "macos", "zsh", "terminal", "shell scripting",

            // Misc Tech
            "oauth", "jwt", "sso", "saml", "ssl", "tls", "websockets", "pwa", "microservices", "monolith", "serverless", "api gateway"
        );
    }
}

