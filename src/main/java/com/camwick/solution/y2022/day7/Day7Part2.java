package com.camwick.solution.y2022.day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day7Part2 extends ProblemSolution{

    public Day7Part2(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "7", "2", test, fileName, currentDay);
    }

   @Override
    public void solve() {
        this.timer.startTimer();

        List<Folder> directories = new ArrayList<>();

        Folder homeDir = new Folder("/");
        directories.add(homeDir);
        this.sc.nextLine();

        Folder currentFolder = homeDir;
        do{
            String line = this.sc.nextLine();
            String[] lineParts = line.split(" ");

            switch(lineParts[0]){
                case "$":
                    switch(lineParts[1]){
                        case "cd":
                            switch(lineParts[2]){
                                case "..":
                                    currentFolder = currentFolder.getParentFolder();
                                    break;
                                case "/":
                                    currentFolder = homeDir;
                                    break;
                                default:
                                    currentFolder = currentFolder.getSubFolder(lineParts[2]);
                                    break;
                            }
                            break;
                        case "ls":
                            continue;
                    }
                    break;
                case "dir":
                    Folder newFolder = new Folder(lineParts[1], currentFolder);
                    currentFolder.addSubFolder(newFolder);
                    directories.add(newFolder);
                    break;
                default:
                    File newFile = new File(lineParts[1], Integer.parseInt(lineParts[0]));
                    currentFolder.addFile(newFile);
                    break;
            }
        } while(this.sc.hasNextLine());

        int spaceNeeded = 30000000 - (70000000 - homeDir.sumAllSubFolders());
        
        List<Integer> dirSums = new ArrayList<>();
        for(Folder folder : directories)
            dirSums.add(folder.sumAllSubFolders());
        Collections.sort(dirSums);

        int deletedDirectorySize = 0;
        boolean skip = true;
        for(int sum : dirSums){
            if(sum > spaceNeeded && skip){
                deletedDirectorySize = sum;
                break;
            }
        }

        this.timer.endTimer();

        System.out.println("Size of directory to delete: " + deletedDirectorySize);
        this.timer.printElapsedTime();
    }

    public class Folder{
        private final String name;
        private final Folder parentFolder;
        private List<Folder> subFolders;
        private List<File> files;

        public Folder(String name){
            this.name = name;
            this.parentFolder = null;
            this.subFolders = new ArrayList<>();
            this.files = new ArrayList<>();
        }

        public Folder(String name, Folder parent){
            this.name = name;
            this.parentFolder = parent;
            this.subFolders = new ArrayList<>();
            this.files = new ArrayList<>();
        }

        public void addSubFolder(Folder folder){
            this.subFolders.add(folder);
        }

        public void addFile(File file){
            this.files.add(file);
        }

        public Folder getParentFolder(){
            return this.parentFolder;
        }

        public Folder getSubFolder(String name){
            Folder folder = null;
            for(Folder x : this.subFolders){
                if(x.name.equals(name)){
                    folder = x;
                    break;
                }
            }
            return folder;
        }

        public List<Folder> getSubFolders(){
            return this.subFolders;
        }

        public List<File> getFiles(){
            return this.files;
        }

        public int sumAllSubFolders(){
            int sum = 0;

            sum += this.sumFileSizes();

            for(Folder subFolder : subFolders)
                sum += subFolder.sumAllSubFolders();

            return sum;
        }

        public int sumFileSizes(){
            int sum = 0;
            for(File file : this.files){
                sum += file.getSize();
            }
            return sum;
        }

        public String getName(){
            return this.name;
        }

        @Override
        public String toString(){
            StringBuilder structure = new StringBuilder();

            structure.append("Files in " + this.name + " (dir)\n");
            for(File file : this.files)
                structure.append("\t" + file + "(in " + this.name + ")\n");
            for(Folder folder : this.subFolders)
                structure.append("\t(parent=" + this.name + ")" + folder + "\n");
            return structure.toString();
        }
    }

    public class File{
        private final String name;
        private final int size;

        public File(String name, int size){
            this.name = name;
            this.size = size;
        }

        public String getName(){
            return this.name;
        }

        public int getSize(){
            return this.size;
        }

        @Override
        public String toString(){
            return this.name + " (file, size=" + this.size + ")"; 
        }
    } 
}
