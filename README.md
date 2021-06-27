Cache REST API
==============

The purpose of this exercise is to implement a non-blocking REST API that provides access and other operations to cached values by their key.

The "skeleton" code, as part of the exercise, provides the bare minimum to import the required libs and Scala project, but it lacks implementation details.

The basic expected use cases are for the Cache API to expose the cache operations (HTTP methods - GET, PUT, DELETE) to manipulate and manage a caching layer.

Note:

The persistence store can be anything really (in-memory data structure, in-memory DB, external caching layer (e.g. Redis), and so on).

Unit testing should be provided to cover all implemented uses cases.

# Running the com.sky.service

```shell
sbt run
```

Using the API:

```shell
curl localhost:9000/get/ping | jq .
```
```json
{
  "value": "pong"
}
```

# Running the tests

```shell
sbt test
```
