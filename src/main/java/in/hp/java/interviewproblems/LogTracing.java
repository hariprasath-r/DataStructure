package in.hp.java.interviewproblems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class LogTracing {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("0 A created",
                "0 A created",
                "1 B created",
                "2 C created",
                "3 D created",
                "10 A running",
                "11 A waiting",
                "12 B waiting",
                "13 B running",
                "14 C running",
                "17 B terminated",
                "18 A terminated");
        System.out.println(traceLog(14, list));
    }

    static String traceLog(int timing, List<String> logs) {
        final String CREATED = "created";
        final String WAITING = "waiting";
        final String RUNNING = "running";
        final String TERMINATED = "terminated";

        class Log {
            String process;
            String state;
            int time;

            public Log(String process, String state, int time) {
                this.process = process;
                this.state = state;
                this.time = time;
            }

            @Override
            public String toString() {
                return "Log{" +
                        "process='" + process + '\'' +
                        ", state='" + state + '\'' +
                        ", time=" + time +
                        '}';
            }
        }

        int timeBefore = -1;

        LinkedHashMap<String, Log> processes = new LinkedHashMap<>();

        for (int i = 0; i < logs.size(); i++) {
            String[] s = logs.get(i).split("\\s");
            if (s[2].equals(TERMINATED))
                break;
            if (null != processes.get(s[1])) {
                Log log = processes.get(s[1]);
                log.time = Integer.valueOf(s[0]);
                log.state = s[2];
                processes.put(s[1], log);
            } else {
                processes.put(s[1], new Log(s[1], s[2], Integer.valueOf(s[0])));
            }
        }

        String lastRunningProcess = "-1";
        Object[] processNames = processes.keySet().toArray();
        for (int i = 0; i < processNames.length; i++) {
            Log log = processes.get(processNames[i]);
            if (log.state.equals(RUNNING) && log.time <= timing) {
                if (lastRunningProcess.equals("-1"))
                    lastRunningProcess = log.process;
                else {
                    lastRunningProcess = "-1";
                    break;
                }
            }
        }

        System.out.println(processes);
        return lastRunningProcess;
    }

}
