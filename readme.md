# Java project

Sample **Java** project with **Maven** for dependency control / build, using **Sruts2** MVC, a little of **Bootstrap**, **Jetty**, **MySQL** as database, and finally **Docker** to put all together.
Just testing some things I learned on [Docker Mastery](https://www.udemy.com/certificate/UC-0UUF4COZ/).

## Deploy

- Maven Install
```
mvn clean install
```

- Use maven to build the *.war*
```
mvn war:war
```

- Now just deploy using the *docker-compose.yml*, it will build an jetty image putting the *.war* inside using the *Dockerfile*, start **MySQL** and **Adminer** *(just to connect directly to the database)*
```
docker-compose up
```

## Endpoints
[Project](http://localhost:8080/exam/browser) 
> This links to **localhost:8080/exam/browser** if that doesn't work you need to replace *localhost* with your *docker ip*.

[Adminer](http://localhost:9090)
> Adminer listens on **localhost:9090**, to connect witht the database -> User: **root**, Password: **example**, Database: **exam_test**.

<p>
    <img src=https://img.shields.io/badge/author-americodubas-blue.svg>
</p>