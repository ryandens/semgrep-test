package com.ryadens.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.HashSet;
import java.nio.file.Files;

public class ScriptRunner {

    public void create(Path script) throws IOException {
        Set<PosixFilePermission> filePermissions = new HashSet<PosixFilePermission>();
        filePermissions.add(PosixFilePermission.OTHERS_WRITE);
        filePermissions.add(PosixFilePermission.OTHERS_EXECUTE);
        Files.setPosixFilePermissions(script,filePermissions);
        System.out.println(script.getFileName().toString());
    }

    public void updateNewScript(Path startupScript, Path shutdownScript) throws IOException {
        // why not have anybody be able to execute?
        Files.setPosixFilePermissions(startupScript, PosixFilePermissions.fromString("rwxrwx---"));

        // same for script
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwx---");
        Files.setPosixFilePermissions(shutdownScript, permissions);
    }

}
