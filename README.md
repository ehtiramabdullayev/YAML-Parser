# Speed Java Challenge

Write a simple YAML parser as standalone Java command line program to find
values in given path pattern.

Expected time: Around 1 hour and 30 minutes.

Good quality code is expected.

## Allowed Libraries / Tools

- Your IDE
- Java 8+
- No other libraries, but only standard JDK classes.
- Maven

## Input File

This is static for the test. No other input will be used to verify your program.

```yaml
version: 3.3

services:
  db:
    image: mysql:5.7
    volumes:
      0: db_data:/var/lib/mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: somewordpress
      MYSQL_DATABASE: wordpress
      MYSQL_USER: wordpress
      MYSQL_PASSWORD: wordpress

  wordpress:
    depends_on:
      0: db
    image: wordpress:latest
    ports:
      0: 8000:80
    restart: always
    environment:
      WORDPRESS_DB_HOST: db:3306
      WORDPRESS_DB_USER: wordpress
      WORDPRESS_DB_PASSWORD: wordpress
      WORDPRESS_DB_NAME: wordpress
volumes:
  db_data:
```

## CLI Parameters

Examples:

- `.version`
- `.services.db.volumes.0`
- `.services.wordpress.environment.WORDPRESS_DB_HOST`

## Output

Examples:

- `3.3`
- `db_data:/var/lib/mysql`
- `db:3306`

## The YAML format

For the test, it is simplefied:

- Indents are always 2 spaces.
- After the colon there is always exactly one space.
- No bullet point or arrays.
- Between key and colon is never a space.
- Empty lines are allowed, but will have no whitespaces.
- All values are strings.
- All values starts with the first character after the trailing space of the
  colon to the new line character of the line
- No quotes. No escape characters.
