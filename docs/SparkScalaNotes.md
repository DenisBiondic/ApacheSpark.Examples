Some notes about Spark in general...

## General

- operator (orchestrator) & workers (multiple)
- spark-shell, which is a nice tool for experimenting, can also be loaded with custom jars (e.g. our code we are developing, so that we can experiment directly against a big data store). `spark-shell --jar "path-to.jar"`

## Batching

- works based on RDDs
- most operators are lazy, so that an execution plan can be built before the job is split among workers
- transformations (filter, map etc.) are lazy, and return other RDDs. 
- actions (collect etc.) force the execution
- `collect` is an interesting action which forces the results to be returned to the operator, e.g. for debugging `.collect.forEach(println)`. Similar action is `takeSample(...)`