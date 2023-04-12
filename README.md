Change below property as per data source details in application.properties
```
spring.datasource.url=<URL>
spring.datasource.username=<DB_USERNAME>
spring.datasource.password=<PASSWORD>
```
**Software used**
* JAVA 19
* MAVEN (used 3.8.6)
* Postgres
* COMMAND : mvn clean install spring-boot:run
BASE URL TO ACCESS :
````
http://localhost:9111/ev/
````

URL WITH PAGINATION AND SORTING
````
http://localhost:9111/ev/?limit=5&sort=desc&param=stationName
````

**A minor change**

Use camel case for sorting by property name.
As per spring-docs, it is recommended to use camelCase for Java POJO property.
Underscore character is reserved for resolving ambiguity while querying nested properties.
Refer: https://docs.spring.io/spring-data/commons/docs/3.1.x/reference/html/
4.4.3. Property Expressions

***nginx***
* install nginx > `brew install nginx`
* run nginx > `nginx` or `brew services start nginx`
* change file /opt/homebrew/etc/nginx/nginx.conf to below
---

    http {
        upstream backendserver {
            server 127.0.0.1:9000;
            server 127.0.0.1:9001;
        }
        include mime.types;

        server {
            listen 8080;
            #root /Users/ashishkarn/Downloads/codes/htmljsexp;

            location / {
                proxy_pass http://backendserver/;
                proxy_redirect http://backendserver /*;
            }
        }
    }
    events {}

---

stop nginx> `nginx -s stop` or `brew services stop nginx`
reload nginx> `nginx -s reload` or `brew services restart nginx`
