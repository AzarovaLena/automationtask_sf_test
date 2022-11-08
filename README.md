# automationtask_sf
## Configuration

### Clone

- Clone this repo to you local machine using: https://github.com/AzarovaLena/automationtask_sf_test.git

### Setup

On your local PC you should have installed:
- JDK >= 1.8.0
- Maven 3.6.0 (or upper version)
- Selenium Web Driver should be installed on your PC
- Allure 2.18.1 (or upper version)

## Execution (local)
- Open project in IDE or through Terminal
- Run next command for setting all dependencies
> mvn clean install -Dmaven.test.skip=true
- Run next commands for generation allure report:
> mvn allure:report

> mvn allure:serve
> 

<img width="804" alt="Screenshot 2022-11-08 at 16 07 39" src="https://user-images.githubusercontent.com/86263702/200597972-5625b7c3-c207-4338-9c1a-6d1b2d082531.png">
