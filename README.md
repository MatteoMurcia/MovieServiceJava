# MovieServiceJava



## Description

movie information service that allows you to register, log in, view saved public and private movies.

## How to run it?

first install [Java 17](https://jdk.java.net/17/), then clone the repository and run int in your favorite IDE, I recomend Intellij.


## Calling the endpoints

### Registration

This service will let you create a user using a email and a password, it use the post method, is called using the link http://127.0.0.1:8000/register and you have to send a json like this:
```json
{
    "email": "test@email.com",
    "password": "password you choose"
}
```

### Login

This service let you log in and get a jwt token, it use a post method, is called using the link http://127.0.0.1:8000/login/ and you have to send a json like this:

```json
{
    "email": "test@email.com",
    "password": "password you choose"
}
```

if the user is already registered you would get a response linke this:

```json
{
    "jwt": "JWT Token"
}
```

### Get Public list 

this service will let a user read all the movies that are public, it use the get method and is called using the link http://127.0.0.1:8000/movie/public. You shoud get a json response like this one:

```json
[movie list]
```

### Get Private list 

This service will let a user read all the movies that are private of the user, it use the get method and is called using the link http://127.0.0.1:8000/movie/private,
you have to send tthe email of the user in a json. You shoud get a json response like this one:

```json
 [list of private movies]
```
