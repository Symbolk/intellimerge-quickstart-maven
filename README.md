# Quickstart for Using IntelliMerge API

## Requirments
- Windows/Linux/macOS
- Java 8
- Maven 3.6.1

## Setup
1. Clone the repo and run the following command under the root directory of the cloned repo to import dependencies:
```bash
mvn initialize
```
2. Clone the sample input data from: https://github.com/Symbolk/intellimerge-sample-input.

3. Checkout the two local branches to be merged:

```bash
git checkout ours
git checkout theirs
git checkout master
```

4. Edit the file `Main.java` to replace the `repoPath` to the path where you cloned the sample input.
 
5. Run `Main.main()` to start merging.