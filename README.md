poc-zio-play
============

THIS IS WORK IN PROGRESS

Demonstrates how [ZIO](http://zio.dev) can be integrated with [Play Framework](https://playframework.com/).

> Note: At the moment, we provide a [simple in-memory cache](http://github.com/frgomes/lru-cache). In future we will allow a secondary persistence storage.


# Running unit tests

Unit tests pass at the moment:

```bash
sbt test
```

# Running the application

> Running the application is still work in progress.

```shell
sbt run
```

Using the API:

```shell
curl -X POST localhost:9000/set/1/one | jq .
```
```json
{
  "1": "one"
}
```

```shell
curl localhost:9000/get/1 | jq .
```
```json
{
  "1": "one"
}
```
