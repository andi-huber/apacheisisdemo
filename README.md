# Demo
## Steps to reproduce issue
- mvn clean install
- mvn -pl webapp spring-boot:run
- Browse to http://localhost:8080
- Login to using:
  - username: sven
  - password: pass
- Click menu bar
  - Simple Object
  - List All Test
  - Select any of the objects
  - Click "Download Selected"
  - The checkboxes are not reset(they would be reset in 2.0.0.M6)
  - Uncheck any of the check box