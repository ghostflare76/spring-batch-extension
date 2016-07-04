#  Spring Batch Extension Examples

Collection of Spring Batch Examples, covering the basics
readers, processor, writers, and complex usecases.
(ex : multi resource Job)

## OpenSource Requirement
* Spring Batch
* Spring Boot
* Spring Data Jpa
* Java Configuration

Consider following batch jobs :

로컬개발환경
```
* READ XML to DB
** A : Read XML files from folder
** B : process it
** C : Write into Database
* READ DB to DB

```
스테이징 및 LIVE
```
* A : Read Http XML files from Api Server
* B : process it
* C : Write into Database
```
## General Informations

All Spring Batch Examples:

* are tested with:
  * Spring Batch 3.0.7.RELEASE
  * Spring Framework 4.2.6.RELEASE
* are provided "as is", no guarantees :-)
* work with H2 database [127.0.0.1],

Overview for the project setup.

### Maven Configuration

The test modules are:

* need profiles
** JVM --Dspring.profile.actve=loc
* spring batch test
    * XXXxmlToDbJob

