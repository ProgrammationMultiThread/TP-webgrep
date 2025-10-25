# Concurrent Multithreaded Programming – WebGrep (TP)

This repository contains the **starter code** for one of the hands-on sessions (*Travaux Pratiques*) of the *[Programmation Concurrente en Multi-Threads](https://github.com/ProgrammationMultiThread/)* course at **Nantes Université**.

---

## Overview

The goal of this practical session is to **parallelize a simple web crawler**, inspired by the Unix command `grep`.  The program recursively explores web pages, searching for occurrences of a given regular expression.

Students are asked to:
- Split the exploration between a configurable number of threads.
- Ensure **atomic access** to shared data structures.
- Make the output **thread-safe**.
- Evaluate different approaches to coordination (locks, concurrent collections, thread pools…).

All the required classes are already provided in the `src/main/java/webgrep/` package. The `WebGrep` class contains a working **sequential version**, which must be parallelized.

---

## Notes for students

- The provided code is **intentionally sequential** and not thread-safe.  
- The `TODO` comments indicate the sections that must be modified or extended.  
- You are expected to **preserve the overall structure** of the program and document your design choices.  
- The code can be run either on the real Web or in **offline mode** using `--offline`, which generates synthetic pages for testing.

Example (offline mode, 8 threads):

```bash
mvn -q -DskipTests exec:java     -Dexec.mainClass="webgrep.WebGrep"     -Dexec.args="-cetO --threads=8 Nantes https://fr.wikipedia.org/wiki/Nantes"
```

---

## How to open and run the project

Clone the repository:

```bash
git clone git@github.com:ProgrammationMultiThread/TP-WebGrep.git
```

Then import it as a **Maven project** in your IDE:
- **Eclipse** → *File → Import → Existing Maven Project*  
- **IntelliJ IDEA** → *Open → pom.xml*  
- **VS Code** → install the *Extension Pack for Java* and open the folder.

To compile and run manually from the command line:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="webgrep.WebGrep" -Dexec.args="--threads=1 Nantes https://fr.wikipedia.org/wiki/Nantes"
```

---

## Network Courtesy

This project includes a simple Web crawler designed **for educational purposes only**.  
If you run it on real websites (e.g., Wikipedia), please follow basic **network courtesy** rules:

- Always check the site's [`robots.txt`](https://en.wikipedia.org/wiki/Robots_exclusion_standard).  
- Limit the crawling rate (throttling) to avoid overloading servers.  
- Avoid launching too many threads on the same domain.  
- Never use this program for data collection or stress testing.  
- The goal of this lab is to experiment with **parallelization**, not to crawl the Web extensively.

---

## License

All **Java source code and related project files** in this repository are distributed under the **MIT License**.

- The full license text is available in [`LICENSE.txt`](LICENSE.txt).  
- Organization-wide licensing details are provided in the  [main license file](https://github.com/ProgrammationMultiThread/.github/blob/main/LICENSE.md).

This license applies only to the **original Java code** provided as part of the *Concurrent Multithreaded Programming* course at Nantes Université.
External libraries (e.g. [JSoup](https://jsoup.org/), [JUnit](https://junit.org/junit5/)) are distributed under their own respective licenses.

### Suggested attribution

> "Source code from the course *Programmation Concurrente en Multi-Threads* —  
> © 2025 Matthieu Perrin, licensed under the MIT License."
