# 🚀 autodemo  
**Step-by-Step Automation Project Testing with Sauce Demo**

---

## 📦 Project Setup

This project uses Maven to scaffold a basic Java project using the `maven-archetype-quickstart` template.

---

## 🛠️ Generate the Project

Run the following command in your terminal:

```bash
mvn archetype:generate \
  -DgroupId=com.saucedemo \
  -DartifactId=autodemo \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

🔍 Command Breakdown

| **Component**                     | **Explanation**                                                                 |
|----------------------------------|---------------------------------------------------------------------------------|
| `mvn`                            | Invokes the Maven CLI tool                                                     |
| `archetype:generate`             | Uses the Maven Archetype plugin to generate a new project                      |
| `-DgroupId=com.saucedemo`        | Sets the base package structure (`com/saucedemo`)                              |
| `-DartifactId=autodemo`          | Names your project folder and artifact as `autodemo`                           |
| `-DarchetypeArtifactId=...`      | Specifies the use of the `maven-archetype-quickstart` template                 |
| `-DinteractiveMode=false`        | Runs the command without prompting for user input                              |


💡 The result: a folder named autodemo containing a basic Java app structure with:

    src/main/java/com/saucedemo/App.java

    src/test/java/com/saucedemo/AppTest.java

    pom.xml

    🔄 Reload Dependencies

If you need to resolve and reload all Maven dependencies, run:

mvn dependency:resolve
