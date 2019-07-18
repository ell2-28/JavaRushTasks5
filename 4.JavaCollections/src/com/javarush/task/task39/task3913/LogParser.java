package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;
    private List<LogObj> logStrings = new ArrayList<>();
    private HashSet<String> IPs = new HashSet<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        initData();
        for (LogObj obj : logStrings) {
            if (inRange(after, before, obj.getDate())) IPs.add(obj.getIP());
        }
        return IPs.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        initData();
        getNumberOfUniqueIPs(after, before);
        return IPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        initData();
        for (LogObj obj : logStrings) {
            if (inRange(after, before, obj.getDate()) && (user.equals(obj.getUser()))) IPs.add(obj.getIP());
        }
        return IPs;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        initData();
        for (LogObj obj : logStrings) {
            if (inRange(after, before, obj.getDate()) && (event.equals(obj.getOperation()))) IPs.add(obj.getIP());
        }
        return IPs;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        initData();
        for (LogObj obj : logStrings) {
            if (inRange(after, before, obj.getDate()) && (status.equals(obj.getOpStatus()))) IPs.add(obj.getIP());
        }
        return IPs;
    }

    private void initData() {
        readDir();
        IPs.clear();
    }

    private boolean inRange(Date after, Date before, Date query) {
        boolean isAfter = after == null;
        boolean isBefore = before == null;

        return (isAfter || query.after(after)) && (isBefore || query.before(before));

    }

    private void readLogFile(Path file) {
        List<String> logEntrys = new ArrayList<>();
        String IP;
        String user;
        Date date;
        Event operation;
        String id;
        Status opStatus;

        try {
            logEntrys = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : logEntrys) {
            String cleanStr = str.trim();
            String[] words = cleanStr.split("\t");
            IP = words[0].trim();
            user = words[1].trim();
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy H:m:s", Locale.ENGLISH);
            date = new Date();
            try {
                date = format.parse(words[2].trim());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String strOp = words[3].trim();
            int pos = strOp.indexOf("TASK");
            if (pos > 0) {
                id = strOp.substring(pos + 4).trim();
                strOp = strOp.substring(0, pos + 4);
            } else {
                id = "";
            }
            switch (strOp) {
                case "LOGIN":
                    operation = Event.LOGIN;
                    break;
                case "DOWNLOAD_PLUGIN":
                    operation = Event.DOWNLOAD_PLUGIN;
                    break;
                case "WRITE_MESSAGE":
                    operation = Event.WRITE_MESSAGE;
                    break;
                case "SOLVE_TASK":
                    operation = Event.SOLVE_TASK;
                    break;
                case "DONE_TASK":
                    operation = Event.DONE_TASK;
                    break;
                default:
                    operation = Event.LOGIN;

            }
            switch (words[4].trim()) {
                case "OK":
                    opStatus = Status.OK;
                    break;
                case "FAILED":
                    opStatus = Status.FAILED;
                    break;
                case "ERROR":
                    opStatus = Status.ERROR;
                    break;
                default:
                    opStatus = Status.ERROR;
            }

            logStrings.add(new LogObj(IP, user, date, operation, opStatus, id));
        }
    }

    private class LogFileVisitor extends SimpleFileVisitor<Path> {
        private PathMatcher matcher;

        public LogFileVisitor(String pattern) {
            try {
                this.matcher = FileSystems.getDefault().getPathMatcher(pattern);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (matcher.matches(file.getFileName())) {
                readLogFile(file);
            }
            return super.visitFile(file, attrs);
        }
    }

    private void readDir() {
        try {
            Files.walkFileTree(logDir, new LogFileVisitor("glob:*.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class LogObj {
        String IP;
        String user;
        Date date;
        Event operation;
        String id;
        Status opStatus;

        private void initObj(String IP, String user, Date date, Event operation, Status opStatus, String id) {
            this.IP = IP;
            this.user = user;
            this.date = date;
            this.operation = operation;
            this.opStatus = opStatus;
            this.id = id;
        }

        public LogObj(String IP, String user, Date date, Event operation, Status opStatus, String id) {
            initObj(IP, user, date, operation, opStatus, id);
        }

        public LogObj(String IP, String user, Date date, Event operation, Status opStatus) {
            initObj(IP, user, date, operation, opStatus, "");
        }

        public Status getOpStatus() {
            return opStatus;
        }

        public Event getOperation() {
            return operation;
        }

        public String getUser() {
            return user;
        }

        public Date getDate() {
            return date;
        }

        public String getIP() {
            return IP;
        }
    }
}