import edu.pku.intellimerge.client.IntelliMerge;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Change repoPath to the path where you clone https://github.com/Symbolk/intellimerge-sample-input
    private static String repoPath = "D:\\github\\intellimerge-sample-input";

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        mergeBranches();
        mergeDirectories();
    }

    /**
     * Merge two branches of a git repository
     */
    private static void mergeBranches() {
        System.out.println("--------merging branches---------");

        IntelliMerge merger = new IntelliMerge();

        String outputPath = repoPath + "/results1";
        boolean hasSubModule = false;
        List<String> branchNames = new ArrayList<>();
        branchNames.add("ours");
        branchNames.add("theirs");

        try {
            List<String> resultFilePaths = merger.mergeBranches(repoPath, branchNames, outputPath, hasSubModule);
            System.out.println("Merging results:");
            for (String path : resultFilePaths) {
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Merge three directories that contains Java files
     */
    private static void mergeDirectories() {
        System.out.println("--------merging directories---------");

        IntelliMerge merger = new IntelliMerge();

        List<String> directoryPaths = new ArrayList<>();
        String outputPath = repoPath + "/results2";

        directoryPaths.add(repoPath + "/src/main/java/bad/robot/refactoring/left");
        directoryPaths.add(repoPath + "/src/main/java/bad/robot/refactoring/base");
        directoryPaths.add(repoPath + "/src/main/java/bad/robot/refactoring/right");
        try {
            List<String> resultFilePaths = merger.mergeDirectories(directoryPaths, outputPath);
            System.out.println("Merging results:");
            for (String path : resultFilePaths) {
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}