package ru.af3412.benchpost;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Thread)
public class UserAgregator {

    private static final int USER_LIST_BENCHMARK_SIZE = 1000;
    private List<User> benchUsers;

    /**
     * Prepare for benchmark tests
     */
    @Setup
    public void setupBenhUsers() {
        benchUsers = new ArrayList<>(USER_LIST_BENCHMARK_SIZE);
        Random r = new Random();
        for (int i = 0; i < USER_LIST_BENCHMARK_SIZE; i++) {
            String userName = "User" + i;
            int emailNum = r.nextInt(10) + 1;
            Set<String> emails = new HashSet<>(emailNum);
            for (int j = 0; j < emailNum; j++) {
                var first = (char) (r.nextInt(26) + 'a');
                var second = (char) (r.nextInt(26) + 'a');
                var third = (char) (r.nextInt(26) + 'a');
                var four = (char) (r.nextInt(26) + 'a');
                var five = (char) (r.nextInt(26) + 'a');
                String email = "" + first + second + third + four + five + "@mail.ru";
                emails.add(email);
            }
            benchUsers.add(new User(userName, emails));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMergeDfs(Blackhole blackhole) {
        blackhole.consume(mergeDFS(benchUsers));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMergeBruteForce(Blackhole blackhole) {
        blackhole.consume(mergeBruteForce(benchUsers));
    }


    /**
     * Merge users use Breadth-first search
     * @param users is list users which need merge
     * @return list merged users
     */
    public List<User> mergeDFS(List<User> users) {
        List<User> result = new ArrayList<>();
        Map<String, String> uniqueEmailMap = getUniqueEmailMap(users);
        Map<String, Set<String>> graph = getGraph(users);
        Set<String> visited = new HashSet<>();
        uniqueEmailMap.forEach((mail, userName) -> {
            Set<String> emails = new HashSet<>();
            if (visited.add(mail)) {
                dfs(emails, mail, graph, visited);
                result.add(new User(userName, emails));
            }
        });
        return result;
    }

    /**
     * Merge users use Brute force search
     * @param users is list users which need merge
     * @return list merged users
     */
    public List<User> mergeBruteForce(List<User> users) {
        List<User> result = users.stream()
                .map(user -> new User(user.name, new HashSet<>(user.emails)))
                .collect(Collectors.toCollection(() -> new ArrayList<>(users.size())));

        int outerCounter = 0;
        while (outerCounter < result.size()) {
            User outerUser = result.get(outerCounter++);
            int i = outerCounter;
            while (i < result.size()) {
                User innerUser = result.get(i);
                if (containsSameEmail(outerUser.emails, innerUser.emails)) {
                    outerUser.emails.addAll(innerUser.emails);
                    result.remove(innerUser);
                    i--;
                    outerCounter = 0;
                }
                i++;
            }
        }
        return result;
    }

    private Map<String, String> getUniqueEmailMap(List<User> users) {
        Map<String, String> uniqueEmailMap = new HashMap<>();
        for (User user : users) {
            for (String email : user.emails) {
                uniqueEmailMap.putIfAbsent(email, user.name);
            }
        }
        return uniqueEmailMap;
    }

    private Map<String, Set<String>> getGraph(List<User> users) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (User user : users) {
            List<String> mailList = new ArrayList<>(user.emails);
            for (int i = 0; i < mailList.size(); i++) {
                graph.putIfAbsent(mailList.get(i), new HashSet<>());
                if (i == 0) continue;
                String prev = mailList.get(i - 1);
                graph.get(prev).add(mailList.get(i));
                graph.get(mailList.get(i)).add(prev);
            }
        }
        return graph;
    }

    private void dfs(Set<String> emails, String mail, Map<String, Set<String>> graph, Set<String> visited) {
        emails.add(mail);
        if (graph.get(mail).size() == 0) {
            return;
        }
        for (String neighbor : graph.get(mail)) {
            if (visited.add(neighbor)) {
                dfs(emails, neighbor, graph, visited);
            }
        }
    }

    private boolean containsSameEmail(Set<String> firstList, Set<String> secondList) {
        return firstList.stream().anyMatch(secondList::contains);
    }

}
