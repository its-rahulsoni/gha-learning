Ques: How do I add jacoco to my project ?

Ans: To add **JaCoCo** (Java Code Coverage) to your **Maven** project, follow these steps:

---

### ✅ 1. **Add JaCoCo Plugin to `pom.xml`**

Insert the following inside the `<build><plugins>` section of your `pom.xml`:

```xml
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.10</version> <!-- use latest stable version -->
  <executions>
    <!-- Bind JaCoCo to Maven test phase -->
    <execution>
      <id>prepare-agent</id>
      <goals>
        <goal>prepare-agent</goal>
      </goals>
    </execution>
    <!-- Generate coverage report after tests -->
    <execution>
      <id>report</id>
      <phase>verify</phase>
      <goals>
        <goal>report</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

---

### ✅ 2. **Ensure You Have This Plugin Block**

Make sure your `pom.xml` has a `<build><plugins>` section. If not, create one like this:

```xml
<build>
  <plugins>
    <!-- JaCoCo plugin here -->
  </plugins>
</build>
```

---

### ✅ 3. **Run Tests and Generate Report**

Use this Maven command to run tests and generate the report:

```bash
mvn clean verify
```

This will:

* Run unit tests
* Generate code coverage reports in:
  `target/site/jacoco/index.html` and
  `target/site/jacoco/jacoco.xml`

---

### 📁 Directory Structure After Running

```
target/
└── site/
    └── jacoco/
        ├── index.html       <- human-readable HTML report
        └── jacoco.xml       <- used by CI tools
```

---

### ✅ 4. (Optional) **Add XML report for CI tools**

If you're integrating with GitHub Actions or coverage reporters, make sure `jacoco.xml` is being generated. The above setup already handles it.

---

Would you like me to show a complete `pom.xml` snippet or GitHub Actions integration for uploading this report?
